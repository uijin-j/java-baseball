package meetcoder.study.console;

import static meetcoder.study.console.ConsoleMessage.CLEAR_MESSAGE;
import static meetcoder.study.console.ConsoleMessage.END_MESSAGE;
import static meetcoder.study.console.ConsoleMessage.INPUT_MESSAGE;
import static meetcoder.study.console.ConsoleMessage.SETUP_MESSAGE;

import meetcoder.study.console.enums.GameStatus;
import meetcoder.study.console.io.ConsolePrinter;
import meetcoder.study.console.io.ConsoleReader;
import meetcoder.study.core.model.BaseballGuessResult;
import meetcoder.study.core.model.BaseballNumber;
import meetcoder.study.util.RandomBaseballNumberGenerator;

public class ConsoleBaseballGame {

  private final ConsolePrinter consolePrinter;
  private final ConsoleReader consoleReader;
  private BaseballNumber baseballNumber;
  private GameStatus gameStatus;

  public ConsoleBaseballGame(ConsolePrinter consolePrinter, ConsoleReader consoleReader) {
    this.consolePrinter = consolePrinter;
    this.consoleReader = consoleReader;
  }

  public void play() {
    gameStatus = GameStatus.PLAYING;
    baseballNumber = RandomBaseballNumberGenerator.generate();
    consolePrinter.printEmpty();
    consolePrinter.print(SETUP_MESSAGE);
    consolePrinter.printEmpty();
    while (isNotEnd()) {
      guess();
    }
  }

  private void guess() {
    try {
      consolePrinter.printInput(INPUT_MESSAGE);
      BaseballNumber guessedNumber = consoleReader.readBaseballNumber();
      BaseballGuessResult result = baseballNumber.evaluateGuess(guessedNumber);
      consolePrinter.printBaseballResult(result);
      if (result.isAllStrike()) {
        end();
      }
    } catch (Exception e) {
      consolePrinter.printError(e.getMessage());
    }
  }

  private void end() {
    consolePrinter.printEmpty();
    consolePrinter.print(CLEAR_MESSAGE);
    consolePrinter.printWithDashLine(END_MESSAGE);
    consolePrinter.printEmpty();
    gameStatus = GameStatus.END;
  }

  private boolean isNotEnd() {
    return gameStatus != GameStatus.END;
  }

}
