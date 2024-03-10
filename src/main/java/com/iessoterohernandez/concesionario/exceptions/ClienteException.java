package com.iessoterohernandez.concesionario.exceptions;

public class ClienteException extends RuntimeException{
    public ClienteException() {
        super();
    }

    public ClienteException(String msg) {
        super(msg);
    }
}
