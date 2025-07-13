package org.hign.platform.u202318274.shared.domain.exceptions;


public class GeneralException extends RuntimeException{
    private final String code;

    public GeneralException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}
