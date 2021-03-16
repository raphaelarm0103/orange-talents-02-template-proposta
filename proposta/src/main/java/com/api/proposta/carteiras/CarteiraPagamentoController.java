package com.api.proposta.carteiras;


import com.api.proposta.cartoes.AnaliseCartaoResponse;
import com.api.proposta.cartoes.Cartao;
import com.api.proposta.cartoes.CartaoRequest;
import com.api.proposta.cartoes.ConectaCartao;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/carteiras")
public class CarteiraPagamentoController {

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    ConectaCartao conectaCartao;

    public ResponseEntity criaCarteira(@PathVariable Long id, @RequestBody @Valid CarteiraPagamentoRequest carteiraPagamentoRequest, UriComponentsBuilder uriComponentsBuilder){

        Cartao cartao = Optional.ofNullable(manager.find(Cartao.class, id)).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "O id do cartão não foi encontrado"));

        try{
            conectaCartao.criarCarteira(cartao.getNumeroCartao(), carteiraPagamentoRequest);
            AnaliseCartaoResponse cartaoResponse = conectaCartao.cartaoPorId(cartao.getNumeroCartao());

           Carteira carteira = cartaoResponse.getCarteira().toModel(cartao);

           manager.persist(carteira);

            URI uri = uriComponentsBuilder.path("carteiras/{id}").buildAndExpand(carteira.getId()).toUri();
            return ResponseEntity.created(uri).build();
        }catch (FeignException e){
            return ResponseEntity.unprocessableEntity().build();
        }

    }
}
