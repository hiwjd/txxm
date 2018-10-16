package com.hiwjd.app.controller;

import com.hiwjd.bal.BalService;
import com.hiwjd.bal.OperatorDTO;
import com.hiwjd.cardealer.CardealerDTO;
import com.hiwjd.cardealer.CardealerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private BalService balService;

  @Autowired
  private CardealerService cardealerService;

  @RequestMapping(value = "/api/operator/create")
  public void abc() {
    OperatorDTO dto = new OperatorDTO();
    dto.setCardealerId(1L);
    dto.setUn("un1");
    dto.setMobile("15967123303");
    dto.setPassword("123123");
    balService.create(dto);
  }

  @RequestMapping(value = "/api/cardealer/create")
  public void createCardealer() {
    CardealerDTO dto = new CardealerDTO();
    dto.setUn("un1");
    dto.setMobile("15967123303");
    dto.setPassword("123123");
    dto.setName("cardealer1");
    cardealerService.create(dto);
  }

}
