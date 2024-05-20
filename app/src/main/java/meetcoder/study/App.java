package meetcoder.study;

import meetcoder.study.console.ConsoleBaseballApplication;
import meetcoder.study.console.io.ConsolePrinter;
import meetcoder.study.console.io.ConsoleReader;

public class App {

    public static void main(String[] args) {
        ConsoleBaseballApplication application = new ConsoleBaseballApplication(
            new ConsolePrinter(),
            new ConsoleReader()
        );

        application.start();
    }

}
