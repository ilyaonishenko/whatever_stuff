import java.util.function.BinaryOperator;

/**
 * Created by wopqw on 03.09.16.
 */
public class Main {

    public static void main(String[] args) {


        BinaryOperator<Integer> addInt = (x, y) -> x + y;

        System.out.println(addInt.apply(5,5));
    }
}
