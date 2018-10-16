package com.hiwjd.operator;

public class OperatorDAO {

    private final OperatorMapper operatorMapper;

    public OperatorDAO(OperatorMapper operatorMapper) {
        this.operatorMapper = operatorMapper;
    }

    public void create(Operator operator) {
        operatorMapper.create(operator);
    }
}
