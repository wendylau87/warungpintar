package com.warungpintar.simpleapi.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.warungpintar.simpleapi.model.Greet;
import com.warungpintar.simpleapi.service.GreetService;
import com.warungpintar.simpleapi.view.request.GreetRequest;
import com.warungpintar.simpleapi.view.response.BaseResponse;
import com.warungpintar.simpleapi.view.response.HistoryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@Component
@RequestMapping("/greet")
public class GreetController {

    @Autowired
    GreetService service;

    @PostMapping(value = "/send", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public BaseResponse send(@RequestBody GreetRequest request) {
        return service.send(request);
    }

    @GetMapping(value = "/collect", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public HistoryResponse collect() {
        return service.findAll();
    }
}
