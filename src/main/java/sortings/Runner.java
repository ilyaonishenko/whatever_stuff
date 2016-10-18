package sortings;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by wopqw on 03.10.16.
 */
public class Runner {

    public static void main(String[] args) {

        String file1 = "/Users/woqpw/GitHub/java/whatever_stuff/src/main/java/sortings/resources/first.txt";
        String file2 = "/Users/woqpw/GitHub/java/whatever_stuff/src/main/java/sortings/resources/second.txt";

        generateList(file1,10);

        int[] arrayToSort = readList(file1);

        System.out.println(Arrays.toString(arrayToSort));

//        MergeSort.sort(arrayToSort);
//        QuickSort.sort(arrayToSort);
//        ShellSort.sort(arrayToSort); ????
//        InsertionSort.sort(arrayToSort);
        System.out.println(Arrays.toString(arrayToSort));


    }

    @SneakyThrows
    static void generateList(String name, int size) {

        try (Writer writer = new FileWriter(name)) {

            new Random().ints(size,0,20)
                    .forEach(t -> {
                        try {
                            writer.write(t+" ");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }

    @SneakyThrows
    static int[] readList (String name){

        try(BufferedReader br = new BufferedReader(new FileReader(name))){

            return br.lines().flatMap(t -> Stream.of(t.split(" "))).mapToInt(Integer::parseInt).toArray();
        }
    }
}
