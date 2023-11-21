package br.com.thr3r.domain.exceptions;

public class ClientException extends Exception {
    public ClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
