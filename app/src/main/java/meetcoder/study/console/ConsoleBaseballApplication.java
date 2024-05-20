package meetcoder.study.console;

import java.util.Map;
import meetcoder.study.console.command.Command;
import meetcoder.study.console.command.CommandFactory;
import meetcoder.study.console.command.ExitCommand;
import meetcoder.study.console.command.PlayGameCommand;
import meetcoder.study.console.enums.ApplicationStatus;
import meetcoder.study.console.io.ConsolePrinter;
import meetcoder.study.console.io.ConsoleReader;

public class ConsoleBaseballApplication {

    private static final String COMMAND_DESCRIPTION = "게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.";
    private static final String EXIT_MESSAGE = "애플리케이션이 종료되었습니다.";
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
                "1", new PlayGameCommand(new ConsoleBaseballGame(consolePrinter, consoleReader)),
                "9", new ExitCommand(this)
            ));
        status = ApplicationStatus.RUNNING;
    }

    public void start() {
        status = ApplicationStatus.RUNNING;
        while (isNotEnd()) {
            processCommand();
        }
    }

    public void processCommand() {
        try {
            consolePrinter.print(COMMAND_DESCRIPTION);
            Command command = consoleReader.readCommand(commandFactory);
            command.execute();
        } catch (Exception e) {
            consolePrinter.printError(e.getMessage());
        }
    }

    public void end() {
        consolePrinter.print(EXIT_MESSAGE);
        status = ApplicationStatus.EXIT;
    }

    private boolean isNotEnd() {
        return status != ApplicationStatus.EXIT;
    }

}
