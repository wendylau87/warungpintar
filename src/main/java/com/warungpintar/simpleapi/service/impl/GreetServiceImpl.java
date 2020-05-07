package com.warungpintar.simpleapi.service.impl;

import com.warungpintar.simpleapi.helper.Util;
import com.warungpintar.simpleapi.model.Greet;
import com.warungpintar.simpleapi.service.FileService;
import com.warungpintar.simpleapi.service.GreetService;
import com.warungpintar.simpleapi.view.request.GreetRequest;
import com.warungpintar.simpleapi.view.response.BaseResponse;
import com.warungpintar.simpleapi.view.response.HistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GreetServiceImpl implements GreetService {

    @Autowired
    FileService fileService;

    @Override
    public BaseResponse send(GreetRequest request) {
        BaseResponse response = new BaseResponse();
        long startTime = Util.getTimeMilis();
        Greet greet = new Greet(Util.getTimeMilis(), request.getMessage());
        fileService.save(greet);
        response.setStatus("200");
        response.setMessage("Successfully send greeting");
        response.setLatency(Util.getTimeMilis() - startTime);
        return response;
    }

    @Override
    public HistoryResponse findAll() {
        HistoryResponse response = new HistoryResponse();
        response.setGreets(fileService.readAll());
        return response;
    }
}
