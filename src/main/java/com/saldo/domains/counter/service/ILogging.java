package com.saldo.domains.counter.service;

import java.util.Map;

public interface ILogging {

  void print(Map<String, Integer> domainCountMap);

}
