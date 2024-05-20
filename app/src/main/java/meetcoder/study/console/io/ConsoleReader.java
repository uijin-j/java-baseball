package meetcoder.study.console.io;

import static java.util.Objects.isNull;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import meetcoder.study.console.command.Command;
import meetcoder.study.console.command.CommandFactory;
import meetcoder.study.core.model.BaseballNumber;

public class ConsoleReader {

  private static final BufferedReader reader = new BufferedReader(
      new InputStreamReader(System.in));

  public Command readCommand(CommandFactory commandFactory) {
    Command command = commandFactory.getCommand(readString());
    if (isNull(command)) {
      throw new IllegalArgumentException("잘못된 명령어 입니다.");
    }

    return command;
  }

  public BaseballNumber readBaseballNumber() {
    return BaseballNumber.of(readInts());
  }

  private String readString() {
    try {
      return reader.readLine();
    } catch (Exception e) {
      throw new IllegalArgumentException("입력을 읽을 수 없습니다.");
    }
  }

  private List<Integer> readInts() {
    try {
      return readString().chars()
          .boxed()
          .map(Character::getNumericValue)
          .toList();
    } catch (Exception e) {
      throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
  }

}
