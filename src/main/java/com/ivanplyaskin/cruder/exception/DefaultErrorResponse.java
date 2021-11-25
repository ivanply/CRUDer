package com.ivanplyaskin.cruder.exception;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class DefaultErrorResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = - 4645277256810229160L;

    private String timestamp;
    private int status;
    private List<String> errors;
    private String path;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
