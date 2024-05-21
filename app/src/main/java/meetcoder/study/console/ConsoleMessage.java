package meetcoder.study.console;

import static meetcoder.study.ApplicationConfig.BASEBALL_NUMBER_SIZE;

final class ConsoleMessage {

  /**
   * 어플리케이션
   */
  static final String COMMAND_DESCRIPTION = "게임을 새로 시작하려면 1, 종료하려면 9를 입력하세요.";
  static final String EXIT_MESSAGE = "애플리케이션이 종료되었습니다.";

  /**
   * 야구 게임
   */
  static final String SETUP_MESSAGE = "컴퓨터가 숫자를 뽑았습니다.";
  static final String INPUT_MESSAGE = "숫자를 입력해주세요";
  static final String CLEAR_MESSAGE =
      BASEBALL_NUMBER_SIZE + "개의 숫자를 모두 맞히셨습니다.";
  static final String END_MESSAGE = "게임 종료";

}
