import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by wopqw on 08.09.16.
 */
public class StreamsExample {

    public static void main(String[] args) {

        flatMapExample();
    }

    public static void flatMapExample(){

        List<Foo> foos = new ArrayList<>();

        IntStream
                .range(1,4)
                .forEach(i -> foos.add(new Foo("Foo"+i)));

        foos.forEach(i ->
                IntStream
                        .range(1,4)
                        .forEach(j ->
                        i.bars.add(new Bar("Bar"+j+"<--"+i.name)))

        );

        foos.stream()
                .flatMap(f -> f.bars.stream())
                .forEach(bar -> System.out.println(bar.name));
    }

}

class Foo{

    String name;

    ArrayList<Bar> bars = new ArrayList<>();

    Foo(String name){
        this.name = name;
    }

}

class Bar{

    String name;

    Bar(String name){
        this.name = name;
    }
}
