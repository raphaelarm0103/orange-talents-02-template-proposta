package com.api.proposta.cartoes;


import com.api.proposta.avisos.AvisoViagemRequest;
import com.api.proposta.avisos.AvisoViagemResponse;
import com.api.proposta.bloqueio.BloqueioRequest;
import com.api.proposta.bloqueio.BloqueioResponse;
import com.api.proposta.carteiras.CarteiraPagamentoRequest;
import com.api.proposta.carteiras.CarteiraPagamentoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "cartoes", url = "${cartao.url}")
public interface ConectaCartao {


    @PostMapping("/api/cartoes")
    AnaliseCartaoResponse criarCartao(AnaliseCartaoRequest requestCartao);

    @PostMapping("/api/cartoes/{id}/bloqueios")
    BloqueioResponse bloqueioCartao(@PathVariable String id, BloqueioRequest bloqueioRequest);

    @GetMapping("/api/cartoes/{id}")
    AnaliseCartaoResponse cartaoPorId(@PathVariable String id);

    @PostMapping("api/cartoes/{id}/avisos")
    AvisoViagemResponse avisoViagem(@PathVariable String id, AvisoViagemRequest avisoRequest);

    @PostMapping("/api/cartoes/{id}/carteiras")
    CarteiraPagamentoResponse criarCarteira(@PathVariable String id, CarteiraPagamentoRequest carteiraRequest);

}
