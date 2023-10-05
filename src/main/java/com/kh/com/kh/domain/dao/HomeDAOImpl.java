package com.kh.com.kh.domain.dao;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;


@Slf4j
@Repository
@RequiredArgsConstructor
public class HomeDAOImpl implements HomeDAO{
  // 변수명을 :변수명으로 바꿔주는 개쩌는 코드
  private final NamedParameterJdbcTemplate template;


  @Override
  public Long save(Home home) {
    StringBuffer sql = new StringBuffer();
    sql.append("insert into info (info_num,p_name,p_cost,p_text) ");
    sql.append("values (info_seq.nextval,:pname,:pcost,:ptext) ");

    // SqlParameterSource sql를 객체로 만들어줌
    // BeanPropertySqlParameterSource 객체를 MAP형식으로 바꿔줌
    // RowMapper 쿼리를 꺼내는 코드를 간단한 람다식으로 표현하게 해줌
    // keyHolder 쿼리 실행시 자동으로 키생성
    SqlParameterSource param = new BeanPropertySqlParameterSource(home);
    KeyHolder keyHolder = new GeneratedKeyHolder();
    template.update(sql.toString(), param, keyHolder,new String[]{"info_num"});
    long info_id = keyHolder.getKey().longValue();

    return info_id;
  }
}
