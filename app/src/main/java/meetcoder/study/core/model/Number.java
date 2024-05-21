package meetcoder.study.core.model;

import static meetcoder.study.ApplicationConfig.BASEBALL_NUMBER_SIZE;
import static meetcoder.study.ApplicationConfig.MAX_NUMBER;
import static meetcoder.study.ApplicationConfig.MIN_NUMBER;
import static meetcoder.study.util.Validator.validate;

import java.util.Objects;

public class Number {

  private final int number;

  private Number(int number) {
    this.number = number;
  }

  public static Number of(int number) {
    validate(number >= MIN_NUMBER && number <= MAX_NUMBER,
        "야구 숫자는 " + MIN_NUMBER + "~" + MAX_NUMBER + "사이의 서로 다른 " + BASEBALL_NUMBER_SIZE
            + "자리 숫자여야 합니다."
    );
    return new Number(number);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Number number1 = (Number) o;
    return number == number1.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

}
