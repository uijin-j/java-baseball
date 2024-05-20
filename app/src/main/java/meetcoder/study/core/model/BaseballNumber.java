package meetcoder.study.core.model;

import java.util.List;
import java.util.Objects;
import meetcoder.study.util.Validator;

public class BaseballNumber {

  public static final int BASEBALL_NUMBER_LENGTH = 3;
  private final List<Number> numbers;

  private BaseballNumber(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers.stream()
        .map(Number::of)
        .toList();
  }

  public static BaseballNumber of(List<Integer> numbers) {
    return new BaseballNumber(numbers);
  }

  public BaseballGuessResult evaluateGuess(BaseballNumber guessedNumber) {
    int strike = 0;
    int ball = 0;

    for (int i = 0; i < BASEBALL_NUMBER_LENGTH; i++) {
      GuessResultType result = evaluateSingleGuess(guessedNumber.numbers.get(i), i);
      if (Objects.equals(result, GuessResultType.STRIKE)) {
        strike++;
      } else if (Objects.equals(result, GuessResultType.BALL)) {
        ball++;
      }
    }

    return new BaseballGuessResult(strike, ball);
  }

  public GuessResultType evaluateSingleGuess(Number number, int position) {
    if (isStrike(number, position)) {
      return GuessResultType.STRIKE;
    }

    if (isBall(number, position)) {
      return GuessResultType.BALL;
    }

    return GuessResultType.NOTHING;
  }

  private boolean isStrike(Number number, int position) {
    return position < BASEBALL_NUMBER_LENGTH && numbers.get(position)
        .equals(number);
  }

  private boolean isBall(Number number, int position) {
    return !isStrike(number, position) && numbers.contains(number);
  }

  private void validate(List<Integer> numbers) {
    long count = numbers.stream()
        .distinct()
        .count();

    Validator.validate(
        count == BASEBALL_NUMBER_LENGTH, "야구 숫자는 서로 다른 " + BASEBALL_NUMBER_LENGTH + "자리 숫자여야 합니다.");
  }

}
