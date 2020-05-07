package com.warungpintar.simpleapi.view.response;

import java.util.Date;

public class BaseResponse {
    private long latency;

    private String status;

    private String message;

    public BaseResponse(){

    }

    public long getLatency() {
        return latency;
    }

    public void setLatency(long latency) {
        this.latency = latency;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
