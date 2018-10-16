package com.hiwjd.bal;

import com.hiwjd.operator.Operator;
import com.hiwjd.operator.OperatorService;
import com.hiwjd.user.User;
import com.hiwjd.user.UserService;
import org.springframework.transaction.annotation.Transactional;

public class BalService {

  private UserService userService;
  private OperatorService operatorService;

  public BalService(UserService userService, OperatorService operatorService) {
    this.userService = userService;
    this.operatorService = operatorService;
  }

  @Transactional
  public Long create(OperatorDTO dto) {
    User user = new User();
    user.setUn(dto.getUn());
    user.setPassword(dto.getPassword());
    Long uid = userService.create(user);

    Operator operator = new Operator();
    operator.setCardealerId(dto.getCardealerId());
    operator.setUid(uid);
    operator.setUn(dto.getUn());
    operator.setMobile(dto.getMobile());
    operatorService.create(operator);

    return uid;
  }
}
