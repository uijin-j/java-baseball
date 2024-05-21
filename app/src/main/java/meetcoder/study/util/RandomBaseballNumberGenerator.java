package meetcoder.study.util;

import static meetcoder.study.ApplicationConfig.BASEBALL_NUMBER_SIZE;
import static meetcoder.study.ApplicationConfig.MAX_NUMBER;
import static meetcoder.study.ApplicationConfig.MIN_NUMBER;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import meetcoder.study.core.model.BaseballNumber;

public final class RandomBaseballNumberGenerator {

  public static BaseballNumber generate() {
    List<Integer> numbers = createNumberRange(
        MIN_NUMBER,
        MAX_NUMBER
    );

    Collections.shuffle(numbers);

    return BaseballNumber.of(
        new ArrayList<>(numbers.subList(0, BASEBALL_NUMBER_SIZE)));
  }


  private static List<Integer> createNumberRange(int min, int max) {
    List<Integer> numbers = new ArrayList<>();

    for (int i = min; i <= max; i++) {
      numbers.add(i);
    }

    return numbers;
  }

}
