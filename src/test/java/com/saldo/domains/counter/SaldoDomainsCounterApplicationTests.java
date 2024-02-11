package com.saldo.domains.counter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.saldo.domains.counter.service.impl.SystemConsoleReaderService;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SaldoDomainsCounterApplicationTests {

  @MockBean
  private SystemConsoleReaderService consoleReader;
  @Autowired
  private ApplicationContext context;

  @Test
  void contextLoads() {
    List<String> domains = List.of("1@gmail.com", "1@gmail.com", "4@dd.com");
    when(consoleReader.readData()).thenReturn(domains);

    assertThat(context).isNotNull();
  }

}
