package com.warungpintar.simpleapi.model;


public class Greet {
    private long created;

    private String message;

    public Greet(long created, String message) {
        this.created = created;
        this.message = message;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
