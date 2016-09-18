import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by wopqw on 06.09.16.
 */
class MonteCarlo {

    static Map<Integer,Double> parallelDiceRolls(int N){

        double fraction = 1.0/N;

        return IntStream.range(0,N)
                .parallel()
                .mapToObj(twoDiceThrows())
                .collect(Collectors.groupingBy(side -> (Integer)side, Collectors.summingDouble(n -> fraction)));
    }

    private static IntFunction<Integer> twoDiceThrows(){

        int firstThrow = ThreadLocalRandom.current().nextInt(1,7);
        int secondThrow = ThreadLocalRandom.current().nextInt(1,7);
        Integer answer = firstThrow+secondThrow;

        return value -> answer;
    }





}
