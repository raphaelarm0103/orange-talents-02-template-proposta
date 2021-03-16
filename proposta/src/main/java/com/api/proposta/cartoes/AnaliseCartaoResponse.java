package com.api.proposta.cartoes;

import com.api.proposta.avisos.AvisoViagem;
import com.api.proposta.bloqueio.BloqueioResponse;
import com.api.proposta.carteiras.Carteira;
import com.api.proposta.carteiras.CarteiraPagamentoResponse;
import com.api.proposta.solicitante.Proposta;

import java.time.LocalDateTime;
import java.util.List;

public class AnaliseCartaoResponse {

    private String id;

    private String idProposta;

    private String titular;

    private LocalDateTime emitidoEm;

    private Double limite;

    private List<BloqueioResponse> bloqueios;

    private List<AvisoViagem> avisos;

    private List<CarteiraPagamentoResponse> carteiras;

    public String getId() {
        return this.id;
    }

    public String getIdProposta() {
        return idProposta;
    }

    public String getTitular() {
        return titular;
    }

    public LocalDateTime getEmitidoEm() {
        return emitidoEm;
    }

    public Double getLimite() {
        return limite;
    }

    public Cartao toModel(Proposta proposta){
        return new Cartao(id, emitidoEm, proposta, limite);
    }

    @Override
    public String toString() {
        return "AnaliseCartaoResponse{" +
                "id='" + id + '\'' +
                ", idProposta='" + idProposta + '\'' +
                ", titular='" + titular + '\'' +
                ", emitidoEm=" + emitidoEm +
                ", limite=" + limite +
                '}';
    }

    public BloqueioResponse getBloqueio() {
        return bloqueios.get(bloqueios.size() -1);
    }

    public CarteiraPagamentoResponse getCarteira() { return carteiras.get(carteiras.size() -1);
    }
}
