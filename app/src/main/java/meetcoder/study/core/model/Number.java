package meetcoder.study.core.model;

import static meetcoder.study.util.Validator.validate;

import java.util.Objects;

public class Number {

  public static final int MAX_NUMBER = 9;
  public static final int MIN_NUMBER = 1;
  private final int number;

  private Number(int number) {
    this.number = number;
  }

  public static Number of(int number) {
    validate(number >= MIN_NUMBER && number <= MAX_NUMBER, "유효하지 않은 숫자입니다.");
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
