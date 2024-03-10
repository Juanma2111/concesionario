package com.iessoterohernandez.concesionario.exceptions;

public class PruebaException extends RuntimeException{
    public PruebaException(){
        super();
    }

    public PruebaException(String msg){
        super(msg);
    }
}
