package com.api.proposta.bloqueio;

import com.api.proposta.cartoes.AnaliseCartaoResponse;
import com.api.proposta.cartoes.Cartao;
import com.api.proposta.cartoes.ConectaCartao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping("/bloqueio")
public class BloqueioController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    ConectaCartao conectaCartao;

    public ResponseEntity<?> criaBloqueio(@PathVariable Long id, HttpServletRequest requestInfo ,  @RequestHeader("user-agent") String agent){

        Cartao cartao = Optional.ofNullable(manager.find(Cartao.class, id)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "O id do cartão não foi encontrado"));

       try{
           conectaCartao.bloqueioCartao(cartao.getNumeroCartao(), new BloqueioRequest("proposta"));

           AnaliseCartaoResponse responseCartao = conectaCartao.cartaoPorId(cartao.getNumeroCartao());

           Bloqueio bloqueio = responseCartao.getBloqueio().toModel();

           bloqueio.setInformacoesDeRequest((requestInfo.getRemoteAddr()), agent, cartao);
           cartao.addBloqueio(bloqueio);

           manager.persist(bloqueio);

       }catch (FeignException e){
           return ResponseEntity.unprocessableEntity().build();
       }
       return ResponseEntity.ok().build();
    }
}
