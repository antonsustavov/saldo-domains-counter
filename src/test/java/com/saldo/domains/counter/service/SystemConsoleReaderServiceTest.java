package com.saldo.domains.counter.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.saldo.domains.counter.service.impl.SystemConsoleReaderService;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SystemConsoleReaderServiceTest {

  @Mock
  private Scanner scanner;
  private List<String> lines;
  private SystemConsoleReaderService service;

  @BeforeEach
  void setUp() {
    lines = new ArrayList<>();
    service = new SystemConsoleReaderService(scanner, lines);
  }

  @Test
  void should_readData() {

    when(scanner.hasNextLine()).thenReturn(true, true, true, false);
    when(scanner.nextLine()).thenReturn("1@gmail.com", "1@gmail.com", "4@dd.com");

    List<String> actual = service.readData();

    assertEquals(3, actual.size());
    assertEquals("gmail.com", actual.get(0));
    assertEquals("gmail.com", actual.get(1));
    assertEquals("dd.com", actual.get(2));
  }

}