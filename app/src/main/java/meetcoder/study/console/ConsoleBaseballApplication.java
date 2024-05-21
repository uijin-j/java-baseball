package meetcoder.study.console;

import static meetcoder.study.console.ConsoleApplicationConfig.EXIT_APPLICATION_KEY;
import static meetcoder.study.console.ConsoleApplicationConfig.PLAY_GAME_KEY;
import static meetcoder.study.console.ConsoleMessage.COMMAND_DESCRIPTION;
import static meetcoder.study.console.ConsoleMessage.EXIT_MESSAGE;

import java.util.Map;
import meetcoder.study.console.command.Command;
import meetcoder.study.console.command.CommandFactory;
import meetcoder.study.console.command.ExitCommand;
import meetcoder.study.console.command.PlayGameCommand;
import meetcoder.study.console.enums.ApplicationStatus;
import meetcoder.study.console.io.ConsolePrinter;
import meetcoder.study.console.io.ConsoleReader;

public class ConsoleBaseballApplication {

  private final ConsolePrinter consolePrinter;
  private final ConsoleReader consoleReader;
  private final CommandFactory commandFactory;
  private ApplicationStatus status;

  public ConsoleBaseballApplication(
      ConsolePrinter consolePrinter, ConsoleReader consoleReader
  ) {
    this.consolePrinter = consolePrinter;
    this.consoleReader = consoleReader;
    this.commandFactory = new CommandFactory(
        Map.of(
            PLAY_GAME_KEY, new PlayGameCommand(
                new ConsoleBaseballGame(consolePrinter, consoleReader)
            ),
            EXIT_APPLICATION_KEY, new ExitCommand(this)
        ));
    status = ApplicationStatus.RUNNING;
  }

  public void start() {
    status = ApplicationStatus.RUNNING;
    while (isNotEnd()) {
      processCommand();
    }
  }

  public void end() {
    consolePrinter.print(EXIT_MESSAGE);
    status = ApplicationStatus.EXIT;
  }

  private void processCommand() {
    try {
      consolePrinter.print(COMMAND_DESCRIPTION);
      Command command = consoleReader.readCommand(commandFactory);
      command.execute();
    } catch (Exception e) {
      consolePrinter.printError(e.getMessage());
    }
  }

  private boolean isNotEnd() {
    return status != ApplicationStatus.EXIT;
  }

}
