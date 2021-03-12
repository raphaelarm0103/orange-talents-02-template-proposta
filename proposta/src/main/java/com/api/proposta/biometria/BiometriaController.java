package com.api.proposta.biometria;


import com.api.proposta.cartoes.Cartao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.Base64;
import java.util.Optional;

@RestController
@RequestMapping("/biometria")
public class BiometriaController {

    @PersistenceContext
    private EntityManager manager;

    @PostMapping("/{idCartao}")
    @Transactional
    public ResponseEntity<?> criaBiometria(@PathVariable("idCartao") Long idCartao, @RequestBody @Valid BiometriaRequest request, UriComponentsBuilder uriComponentsBuilder){

        Cartao cartao = Optional.ofNullable(manager.find(Cartao.class, idCartao)).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "o id do cartão não foi encontrado"));

        Biometria biometria = request.toModel(cartao);
        manager.persist(biometria);

        URI uri = uriComponentsBuilder.path("/biometria/id").buildAndExpand(biometria.getId()).toUri();

        return ResponseEntity.created(uri).body(new BiometriaResponse(biometria));
    }
}
