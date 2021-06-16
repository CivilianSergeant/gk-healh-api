package technology.grameen.gk.health.api.responses;

import org.springframework.http.HttpStatus;

import java.util.List;

public class ExceptionResponse implements IResponse {

    private int status;
    private String message;
    private List<String> errors;

    public ExceptionResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public ExceptionResponse(HttpStatus unprocessableEntity, String message, List<String> errors) {
        this.status = unprocessableEntity.value();
        this.message = message;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
