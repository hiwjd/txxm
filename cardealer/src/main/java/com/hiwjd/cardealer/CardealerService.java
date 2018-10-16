package com.hiwjd.cardealer;

import com.hiwjd.bal.BalService;
import com.hiwjd.bal.OperatorDTO;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

public class CardealerService {

  private BalService balService;
  private CardealerDAO cardealerDAO;

  public CardealerService(BalService balService, DataSource dataSource) {
    this.balService = balService;

    SqlSessionFactory sqlSessionFactory = Helper.buildSqlSessionFactory(dataSource);
    SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
    CardealerMapper cardealerMapper = sqlSessionTemplate.getMapper(CardealerMapper.class);
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
