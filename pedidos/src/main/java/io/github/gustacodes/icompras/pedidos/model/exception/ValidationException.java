package io.github.gustacodes.icompras.pedidos.model.exception;

import lombok.Getter;

@Getter
public class ValidationException extends RuntimeException {
    private String field;
    private String message;

    public ValidationException(String fiel, String message) {
        super(message);
        this.field = fiel;
        this.message = message;
    }
}
