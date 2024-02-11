package com.saldo.domains.counter.service.impl;

import com.saldo.domains.counter.service.ILogging;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ConsoleLoggingService implements ILogging {

  @Override
  public void print(Map<String, Integer> domainCountMap) {
    domainCountMap.forEach((key, value) -> log.info("{} {}", key, value));
  }

}
