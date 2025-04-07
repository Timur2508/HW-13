package org.skypro.skyshop;

import java.io.IOException;

public class BestResultNotFound extends RuntimeException {

    public BestResultNotFound(String request){
        super(request);
    }
}