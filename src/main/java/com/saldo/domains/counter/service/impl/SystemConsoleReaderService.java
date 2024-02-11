package com.saldo.domains.counter.service.impl;

import com.saldo.domains.counter.service.IConsoleReader;
import java.util.List;
import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@RequiredArgsConstructor
public class SystemConsoleReaderService implements IConsoleReader {

  private final static char SHTRUDEL_SYMBOL = '@';

  private final Scanner scanner;
  private final List<String> lines;

  @Override
  public List<String> readData() {
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine();

      if (ObjectUtils.isEmpty(line)) {
        break;
      }

      var shtrudelIndex = line.indexOf(SHTRUDEL_SYMBOL);
      if (shtrudelIndex != -1) {
        lines.add(line.substring(shtrudelIndex + 1));
      }
    }

    return lines;
  }

}
