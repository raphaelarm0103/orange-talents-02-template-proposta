package com.api.proposta.solicitante;


import com.api.proposta.solicitante.analise.AnalisePropostaRequest;
import com.api.proposta.solicitante.analise.AnalisePropostaResponse;
import com.api.proposta.solicitante.analise.AnalisePropostasEnum;
import com.api.proposta.solicitante.analise.ConectaAnalise;
import feign.FeignException;
import org.apache.coyote.Response;
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
@RequestMapping("/proposta")
public class PropostaController {


    @Autowired
    PropostaRepository propostaRepository;

    @Autowired
    ConectaAnalise conectaAnalise;

    @PostMapping
    @Transactional
    public ResponseEntity<?> solicita(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder uriComponentsBuilder) {

      if(propostaRepository.existsByDocumento(request.getDocumento())){
         return ResponseEntity.unprocessableEntity().build();
        }

        Proposta proposta = request.toModel();
        propostaRepository.save(proposta);

        URI uri = uriComponentsBuilder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri();

      try {
          AnalisePropostaResponse analisePropostaResponse = conectaAnalise.responseAnalise(new AnalisePropostaRequest(proposta));
          AnalisePropostasEnum resultadoSolicitacao = analisePropostaResponse.getResultadoSolicitacao();
          proposta.setStatus(StatusPropostaEnum.analisaProposta(resultadoSolicitacao));

          return ResponseEntity.created(uri).build();

      } catch (FeignException e) {
            proposta.setStatus(StatusPropostaEnum.NAO_ELEGIVEL);
            return ResponseEntity.unprocessableEntity().location(uri).build();

        }

    }
}
