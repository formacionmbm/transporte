package com.practica.transporte.services.exceptions;

public class ErrorResponse {

    public class ErrorResponse {
        private int status;
        private String message;
        private long timestamp;

        // Constructor, Getters y Setters
        public ErrorResponse(int status, String message) {
            this.status = status;
            this.message = message;
            this.timestamp = System.currentTimeMillis();
        }
        // ... getters ...
    }

}
