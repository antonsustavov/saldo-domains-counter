package com.saldo.domains.counter;

import com.saldo.domains.counter.service.IConsoleReader;
import com.saldo.domains.counter.service.IDomainCounter;
import com.saldo.domains.counter.service.ILogging;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class SaldoDomainsCounterApplication implements CommandLineRunner {

  private final IDomainCounter domainCounter;
  private final IConsoleReader consoleReader;
  private final ILogging logging;

  public static void main(String[] args) {
    SpringApplication.run(SaldoDomainsCounterApplication.class, args);
  }

  @Override
  public void run(String... args) {
    List<String> domains = consoleReader.readData();
    domainCounter.calculate(domains);
    Map<String, Integer> groupByDomain = domainCounter.groupByDomain();
    logging.print(groupByDomain);
  }

}

