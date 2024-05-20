package meetcoder.study.console.command;

import meetcoder.study.console.ConsoleBaseballGame;

public class PlayGameCommand implements Command {

    private final ConsoleBaseballGame baseballGame;

    public PlayGameCommand(ConsoleBaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    @Override
    public void execute() {
        baseballGame.play();
    }

}
