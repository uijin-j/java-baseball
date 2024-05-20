package meetcoder.study.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import meetcoder.study.core.model.BaseballNumber;
import meetcoder.study.core.model.Number;

public final class RandomBaseballNumberGenerator {

  public static BaseballNumber generate() {
    List<Integer> numbers = createNumberRange(
        Number.MIN_NUMBER,
        Number.MAX_NUMBER
    );

    Collections.shuffle(numbers);

    return BaseballNumber.of(
        new ArrayList<>(numbers.subList(0, BaseballNumber.BASEBALL_NUMBER_LENGTH)));
  }


  private static List<Integer> createNumberRange(int min, int max) {
    List<Integer> numbers = new ArrayList<>();

    for (int i = min; i <= max; i++) {
      numbers.add(i);
    }

    return numbers;
  }

}
