package com.api.proposta.solicitante;

import com.api.proposta.solicitante.analise.AnalisePropostasEnum;

public enum StatusPropostaEnum {

    ELEGIVEL, NAO_ELEGIVEL;

    public static StatusPropostaEnum analisaProposta(AnalisePropostasEnum analise){
        if(analise == AnalisePropostasEnum.SEM_RESTRICAO){
            return ELEGIVEL;
        }
        return NAO_ELEGIVEL;
    }
}
