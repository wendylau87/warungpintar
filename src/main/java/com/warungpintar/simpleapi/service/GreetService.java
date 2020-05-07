package com.warungpintar.simpleapi.service;

import com.warungpintar.simpleapi.view.request.GreetRequest;
import com.warungpintar.simpleapi.view.response.BaseResponse;
import com.warungpintar.simpleapi.view.response.HistoryResponse;

import java.util.List;

public interface GreetService {

    public BaseResponse send(GreetRequest greetRequest);

    public HistoryResponse findAll();

}
