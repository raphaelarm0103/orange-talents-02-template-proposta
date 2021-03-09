package com.api.proposta.solicitante;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/solicitacao")
public class PropostaController {


    @Autowired
    PropostaRepository propostaRepository;


    @PostMapping
    @Transactional
    public ResponseEntity solicita(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder uriComponentsBuilder) {

      if(propostaRepository.existsByDocumento(request.getDocumento())){
         return ResponseEntity.unprocessableEntity().build();
        }

        Proposta proposta = request.toModel();
        propostaRepository.save(proposta);
        URI uri;
        uri = uriComponentsBuilder.path("/solicitao/{id}").buildAndExpand(proposta.getId()).toUri();
        return ResponseEntity.created(uri).build();


    }
}
