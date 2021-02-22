package co.com.colombia.api.model.commons;

import lombok.Getter;

public class PruebaException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    @Getter
    private String code;

    public PruebaException(String message) {
        super(message);
    }

    public PruebaException(String message, String code) {
        super(message);
        this.code = code;
    }

}
