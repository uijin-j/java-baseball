package meetcoder.study.console.command;

import meetcoder.study.console.ConsoleBaseballApplication;

public class ExitCommand implements Command {

    private final ConsoleBaseballApplication application;

    public ExitCommand(ConsoleBaseballApplication application) {
        this.application = application;
    }

    @Override
    public void execute() {
        application.end();
    }

}
