package com.hiwjd.cardealer;

import com.hiwjd.bal.BalService;
import com.hiwjd.bal.OperatorDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.transaction.annotation.Transactional;

public class CardealerService {

  private BalService balService;
  private CardealerDAO cardealerDAO;

  public CardealerService(BalService balService, SqlSessionFactory sqlSessionFactory) throws Exception {
    this.balService = balService;

    sqlSessionFactory.getConfiguration().addMapper(CardealerMapper.class);
    MapperFactoryBean mapperFactoryBean = new MapperFactoryBean();
    mapperFactoryBean.setSqlSessionFactory(sqlSessionFactory);
    mapperFactoryBean.setMapperInterface(CardealerMapper.class);
    CardealerMapper cardealerMapper = (CardealerMapper) mapperFactoryBean.getObject();
    cardealerDAO = new CardealerDAO(cardealerMapper);
  }

  @Transactional
  public void create(CardealerDTO cardealerDTO) {
    Cardealer cardealer = new Cardealer();
    cardealer.setName(cardealerDTO.getName());
    Long id = cardealerDAO.create(cardealer);

    OperatorDTO dto = new OperatorDTO();
    dto.setCardealerId(id);
    dto.setUn(cardealerDTO.getUn());
    dto.setMobile(cardealerDTO.getMobile());
    dto.setPassword(cardealerDTO.getPassword());
    balService.create(dto);
  }
}
