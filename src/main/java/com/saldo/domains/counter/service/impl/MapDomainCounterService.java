package com.saldo.domains.counter.service.impl;

import com.saldo.domains.counter.service.IDomainCounter;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MapDomainCounterService implements IDomainCounter {

  private final static Integer INCREMENT = 1;
  private final static Integer TOP_10 = 10;

  private final Map<String, Integer> domainCountMap;

  @Override
  public void calculate(List<String> domains) {
    domains.forEach(domain -> domainCountMap.merge(domain, INCREMENT, Integer::sum));
  }

  @Override
  public Map<String, Integer> groupByDomain() {
    return domainCountMap.entrySet()
                         .stream()
                         .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                         .limit(TOP_10)
                         .collect(Collectors.toMap(
                             Map.Entry::getKey,
                             Map.Entry::getValue,
                             (e1, e2) -> e1,
                             LinkedHashMap::new
                         ));
  }

}
