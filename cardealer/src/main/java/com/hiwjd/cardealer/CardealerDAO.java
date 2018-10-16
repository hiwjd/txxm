package com.hiwjd.cardealer;

public class CardealerDAO {

  private CardealerMapper cardealerMapper;

  public CardealerDAO(CardealerMapper cardealerMapper) {
    this.cardealerMapper = cardealerMapper;
  }

  public Long create(Cardealer cardealer) {
    cardealerMapper.create(cardealer);
    return cardealer.getId();
  }
}
