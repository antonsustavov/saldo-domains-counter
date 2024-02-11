package com.saldo.domains.counter.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.saldo.domains.counter.service.impl.MapDomainCounterService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class MapDomainCounterServiceTest {

  private Map<String, Integer> domainCountMap;
  private MapDomainCounterService service;

  @BeforeEach
  void setUp() {
    domainCountMap = new HashMap<>();
    service = new MapDomainCounterService(domainCountMap);
  }

  @Test
  void should_calculate() {
    List<String> domains = List.of("gmail.com", "gmail.com", "dd.com");

    service.calculate(domains);

    assertThat(domainCountMap.size()).isEqualTo(2);
  }

  @Test
  void should_groupByDomain() {
    List<String> domains = List.of("gmail.com", "gmail.com", "dd.com");

    service.calculate(domains);
    Map<String, Integer> actual = service.groupByDomain();

    assertThat(actual.get("gmail.com")).isEqualTo(2);
  }

}