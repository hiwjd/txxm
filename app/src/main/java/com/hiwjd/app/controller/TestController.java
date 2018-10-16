package com.hiwjd.app.controller;

import com.hiwjd.bal.BalService;
import com.hiwjd.bal.OperatorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

  @Autowired
  private BalService balService;

  @RequestMapping(value = "/api/operator/create")
  public void abc() {
    OperatorDTO dto = new OperatorDTO();
    dto.setUn("un1");
    dto.setMobile("15967123303");
    dto.setPassword("123123");
    balService.create(dto);
  }

}
