package com.api.proposta.cartoes;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cartoes", url = "${cartao.url}")
public interface ConectaCartao {


    @PostMapping("/api/cartoes")
    AnaliseCartaoResponse criarCartao(AnaliseCartaoRequest requestCartao);

}
