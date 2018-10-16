package com.hiwjd.operator;

import org.apache.ibatis.annotations.Insert;

public interface OperatorMapper {

  //@Insert("insert into operator(uid, un, mobile) values(#{uid}, #{un}, #{mobile})")
  void create(Operator operator);
}
