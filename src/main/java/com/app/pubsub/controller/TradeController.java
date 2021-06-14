package com.app.pubsub.controller;

import com.app.pubsub.model.TradeDetails;
import com.app.pubsub.service.TradeDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TradeController {

    @Autowired
    private final TradeDetailsService tradeDetailsService;

    @RequestMapping(value = "/api/v1/tradedetails/all", method = RequestMethod.GET)
    public @ResponseBody
    List<TradeDetails> tradeDetailListRest() {
        return (List<TradeDetails>) tradeDetailsService.findAll();
    }
}
