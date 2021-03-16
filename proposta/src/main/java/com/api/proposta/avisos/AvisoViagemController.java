package com.api.proposta.avisos;


import com.api.proposta.cartoes.AnaliseCartaoResponse;
import com.api.proposta.cartoes.Cartao;
import com.api.proposta.cartoes.ConectaCartao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/aviso")
public class AvisoViagemController {


    @PersistenceContext
    private EntityManager manager;

    @Autowired
    ConectaCartao conectaCartao;

    public ResponseEntity criaAviso(@PathVariable Long id, @RequestHeader("user-agent") String agent, HttpServletRequest requestInfos, @RequestBody @Valid AvisoViagemRequest request) {
        Cartao cartao = Optional.ofNullable(manager.find(Cartao.class, id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "o id do cartão não foi encontrado"));
        try {
            conectaCartao.avisoViagem(cartao.getNumeroCartao(), request);

            AvisoViagem avisoViagem = request.toModel(cartao, requestInfos.getRemoteAddr(), agent);

            manager.persist(avisoViagem);

            return ResponseEntity.ok().build();
        } catch (FeignException e) {
            return ResponseEntity.badRequest().build();
        }

    }
}
