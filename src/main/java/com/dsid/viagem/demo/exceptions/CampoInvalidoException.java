package com.dsid.viagem.demo.exceptions;

public class CampoInvalidoException extends Exception {
    public CampoInvalidoException(String nomeCampo, String valor, String mensagemExtra) {
        super("Valor "+valor+" preenchido no campo "+nomeCampo+" invalido."+mensagemExtra);
    }
}
