    package com.meli.ordermanagement.dto;

    import java.time.LocalDateTime;
    import java.util.Map;

    public class ErrorResponseDTO {

        private LocalDateTime timestamp;
        private int status;
        private String error;
        private Map<String, String> validationErrors;
        private String path;

        // Constructor, Getters y Setters
        public ErrorResponseDTO(int status, String error, Map<String, String> validationErrors, String path) {
            this.timestamp = LocalDateTime.now();
            this.status = status;
            this.error = error;
            this.validationErrors = validationErrors;
            this.path = path;
        }

        // Getters y Setters...
        public LocalDateTime getTimestamp() { return timestamp; }
        public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
        public int getStatus() { return status; }
        public void setStatus(int status) { this.status = status; }
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
        public Map<String, String> getValidationErrors() { return validationErrors; }
        public void setValidationErrors(Map<String, String> validationErrors) { this.validationErrors = validationErrors; }
        public String getPath() { return path; }
        public void setPath(String path) { this.path = path; }
    }