package com.vb.userservice.exceptions;

public class ResourceNotFoundException  extends RuntimeException{
    public ResourceNotFoundException(String s) {
        super(s);
    }
    public ResourceNotFoundException(){
        super();
    }
}
