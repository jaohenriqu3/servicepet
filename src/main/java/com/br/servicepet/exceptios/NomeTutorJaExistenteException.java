package com.br.servicepet.exceptios;

public class NomeTutorJaExistenteException extends RuntimeException {

    public NomeTutorJaExistenteException(String mensagem) {
        super(mensagem);
    }

    public NomeTutorJaExistenteException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }
}