package com.kh.com.kh.domain.svc;

import com.kh.com.kh.domain.dao.Home;
import com.kh.com.kh.domain.dao.HomeDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Slf4j
@Service
@RequiredArgsConstructor
public class HomeSVCImpl implements HomeSVC{

  private final HomeDAO homeDAO;

  @Override
  public Long save(Home home) {
    return homeDAO.save(home);
  }
}

