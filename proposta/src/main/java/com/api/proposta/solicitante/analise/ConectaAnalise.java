package com.api.proposta.solicitante.analise;


import com.api.proposta.cartoes.AnaliseCartaoRequest;
import com.api.proposta.cartoes.AnaliseCartaoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "analise", url = "${analise.url}")
public interface ConectaAnalise {

    @PostMapping("/api/solicitacao")
     AnalisePropostaResponse responseAnalise(AnalisePropostaRequest requestAnalise);
}
