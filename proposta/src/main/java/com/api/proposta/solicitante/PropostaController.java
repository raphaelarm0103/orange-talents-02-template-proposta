package com.api.proposta.solicitante;


import com.api.proposta.cartoes.AnaliseCartaoRequest;
import com.api.proposta.cartoes.AnaliseCartaoResponse;
import com.api.proposta.cartoes.ConectaCartao;
import com.api.proposta.solicitante.analise.AnalisePropostaRequest;
import com.api.proposta.solicitante.analise.AnalisePropostaResponse;
import com.api.proposta.solicitante.analise.AnalisePropostasEnum;
import com.api.proposta.solicitante.analise.ConectaAnalise;
import feign.FeignException;
import javassist.NotFoundException;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    ConectaAnalise conectaAnalise;

    @PersistenceContext
    private EntityManager manager;

    @Autowired
    ConectaCartao conectaCartao;


    @PostMapping
    @Transactional
    public ResponseEntity<PropostaResponse> solicita(@RequestBody @Valid PropostaRequest request, UriComponentsBuilder uriComponentsBuilder) {

        Proposta proposta = request.toModel();
        manager.persist(proposta);

        URI uri = uriComponentsBuilder.path("/proposta/{id}").buildAndExpand(proposta.getId()).toUri();
        try {
            AnalisePropostaResponse response = conectaAnalise.responseAnalise(proposta.toStatus());
            proposta.setPropostaStatus(response.getResultadoSolicitacao());
        } catch (FeignException e) {
            proposta.setPropostaStatus(AnalisePropostasEnum.COM_RESTRICAO);
            ResponseEntity.created(uri).build();
        }
        return ResponseEntity.created(uri).body(new PropostaResponse(proposta));
    }

    @Transactional
    @Scheduled(fixedDelay = 5000)
    public void criaCartao() {
        Query query = manager.createNativeQuery("SELECT * FROM propostas WHERE status = :status AND" +
                " cartao_id is null limit 10 for update", Proposta.class);
        query.setParameter("status", StatusPropostaEnum.ELEGIVEL.toString());

        List<Proposta> propostas = query.getResultList();

        while (propostas.size() > 0) {
            Proposta proposta = propostas.get(0);

            AnaliseCartaoResponse cartaoResponse = conectaCartao.criarCartao(proposta.cartaoRequest());
            proposta.cartaoResponse(cartaoResponse.toModel(proposta));
            manager.merge(proposta);
            propostas.remove(0);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropostaResponse> getById(@PathVariable Long id) throws Exception{
        Proposta proposta = Optional.ofNullable(manager.find(Proposta.class, id))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Proposta não foi encontrada por esse ID"));

        return ResponseEntity.ok(new PropostaResponse(proposta));
    }
}



/*
//


            while(!elegivel.isEmpty()) {
            Long id = elegivel.get(0);

            try {
                Proposta proposta = manager.find(Proposta.class, id);
                AnaliseCartaoResponse cartaoResponse = conectaCartao.criarCartao(proposta.cartaoRequest());

                proposta.cartaoResponse(cartaoResponse.toModel((Proposta) manager));
                elegivel.remove(0);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
*/
