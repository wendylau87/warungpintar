package com.warungpintar.simpleapi.service.impl;

import com.warungpintar.simpleapi.helper.Util;
import com.warungpintar.simpleapi.model.Greet;
import com.warungpintar.simpleapi.service.FileService;
import com.warungpintar.simpleapi.service.GreetService;
import com.warungpintar.simpleapi.view.request.GreetRequest;
import com.warungpintar.simpleapi.view.response.BaseResponse;
import com.warungpintar.simpleapi.view.response.HistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;


@Service
public class GreetServiceImpl implements GreetService {

    @Autowired
    FileService fileService;

    @Autowired
    private SimpMessagingTemplate template;

    @Override
    public BaseResponse send(GreetRequest request) {
        BaseResponse response = new BaseResponse();
        long startTime = Util.getTimeMilis();
        Greet greet = new Greet(Util.getTimeMilis(), request.getMessage());
        if(fileService.save(greet)){
            response.setContent(greet);
            response.setStatus("200");
            response.setMessage("Successfully send greeting");
            this.template.convertAndSend("/topic/greetings", response);
        }
        else{
            response.setMessage("Failed send greeting");
            response.setStatus("500");
        }
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
