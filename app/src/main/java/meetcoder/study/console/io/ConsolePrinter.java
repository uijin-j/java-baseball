package meetcoder.study.console.io;

import meetcoder.study.core.model.BaseballGuessResult;

public class ConsolePrinter {

  public void printInput(String message) {
    System.out.print(message + " : ");
  }

  public void print(String message) {
    System.out.println(message);
  }

  public void printWithDashLine(String message) {
    System.out.println("-------" + message + "-------");
  }

  public void printError(String message) {
    System.out.println("[ERROR] " + message);
  }

  public void printBaseballResult(BaseballGuessResult result) {
    System.out.println(result.summary());
  }

  public void printEmpty() {
    System.out.println();
  }

}
