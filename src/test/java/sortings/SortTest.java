package sortings;

import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Created by wopqw on 27.10.16.
 */
@Log
public class SortTest {

    @SuppressWarnings("FieldCanBeLocal")
    private String file1 = "/Users/woqpw/GitHub/java/whatever_stuff/src/main/java/sortings/resources/first.txt";

    private int[] arrayToSort;
    private Sortings sortings;

    @Before
    public void preparation(){
        generateList(file1,10);
        arrayToSort = readList(file1);
        log.info(Arrays.toString(arrayToSort));
    }

    @Test
    public void bubbleSortTest(){

        sortings = new BubbleSort();
        sortings.sort(arrayToSort);
    }

    @Test
    public void insertionSortTest(){

        sortings = new InsertionSort();
        sortings.sort(arrayToSort);
    }

    @Test
    public void mergeSortTest(){

        sortings = new MergeSort();
        sortings.sort(arrayToSort);
    }

    @Test
    public void quickSortTest(){

        sortings = new QuickSort();
        sortings.sort(arrayToSort);
    }

    @Test
    public void shellSortTest(){

        sortings = new ShellSort();
        sortings.sort(arrayToSort);
    }

    @After
    public void finalView() {
        log.info(Arrays.toString(arrayToSort));
    }


        @SneakyThrows
    private static void generateList(String name, int size) {

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
    private static int[] readList (String name){

        try(BufferedReader br = new BufferedReader(new FileReader(name))){

            return br.lines().flatMap(t -> Stream.of(t.split(" "))).mapToInt(Integer::parseInt).toArray();
        }
    }

}