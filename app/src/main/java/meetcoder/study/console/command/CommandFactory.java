package meetcoder.study.console.command;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

    private final Map<String, Command> commands;

    public CommandFactory(Map<String, Command> commands) {
        this.commands = new HashMap<>(commands);
    }

    public Command getCommand(String key) {
        return commands.get(key);
    }

}
