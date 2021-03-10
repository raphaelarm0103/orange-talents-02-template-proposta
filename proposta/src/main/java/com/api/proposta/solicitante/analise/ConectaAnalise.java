package com.api.proposta.solicitante.analise;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "analise", url = "http://localhost:9999")
public interface ConectaAnalise {

    @PostMapping("/api/solicitacao")

    AnalisePropostaResponse responseAnalise(AnalisePropostaRequest requestAnalise);

}
