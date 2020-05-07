package com.warungpintar.simpleapi.view.response;

import com.warungpintar.simpleapi.model.Greet;

import java.util.List;

public class HistoryResponse {

    private List<Greet> greets;

    public List<Greet> getGreets() {
        return greets;
    }

    public void setGreets(List<Greet> greets) {
        this.greets = greets;
    }
}
