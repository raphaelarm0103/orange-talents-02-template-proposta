package com.api.proposta.solicitante.analise;

import com.api.proposta.cartoes.Cartao;
import com.api.proposta.solicitante.Proposta;

import java.time.LocalDateTime;

public class AnalisePropostaResponse {


    private  Long idProposta;
    private  String documento;
    private  String nome;
    private  AnalisePropostasEnum resultadoSolicitacao;

    public AnalisePropostaResponse(Long idProposta, String documento, String nome, AnalisePropostasEnum resultadoSolicitacao) {
        this.idProposta = idProposta;
        this.documento = documento;
        this.nome = nome;
        this.resultadoSolicitacao = resultadoSolicitacao;
    }

    public Long getIdProposta() {
        return idProposta;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNome() {
        return nome;
    }

    public AnalisePropostasEnum getResultadoSolicitacao() {
        return resultadoSolicitacao;
    }

}
