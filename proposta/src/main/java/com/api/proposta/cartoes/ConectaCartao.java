package com.api.proposta.cartoes;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cartoes", url = "http://localhost:8888/")
public interface ConectaCartao {


    @PostMapping("/api/cartoes")
    AnaliseCartaoResponse criarCartao(AnaliseCartaoRequest requestCartao);

}
