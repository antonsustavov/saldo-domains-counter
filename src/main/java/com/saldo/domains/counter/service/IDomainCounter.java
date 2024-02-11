package com.saldo.domains.counter.service;

import java.util.List;
import java.util.Map;

public interface IDomainCounter {

  void calculate(List<String> domain);

  Map<String, Integer> groupByDomain();

}
