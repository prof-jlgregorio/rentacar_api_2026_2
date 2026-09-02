package br.com.jlgregorio.rentacar.exception;

public enum ExceptionMessage {

    RESOURCE_NOT_FOUND("Recurso não encontrado"),

    SERVER_ERROR("Erro do servidor"),

    BAD_CREDENTIALS("Usuário e/ou senha inválidos"),

    EMAIL_ALREADY_IN_USE("O email informado já está em uso");

    private final String message;

    ExceptionMessage(String message){
        this.message = message;
    }

}
