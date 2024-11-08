package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args)  {

        List<Integer> arr = new ArrayList<>(
                Arrays.asList(8,16,2,9,85,4,1,3,-11,-5,0)
        );

        ExecutorService es = Executors.newCachedThreadPool();

        Sorter s = new Sorter(arr , es);

        Future<List<Integer>> sortedArrF = es.submit(s);

        List<Integer> sortedArr = null;
        try {
            sortedArr = sortedArrF.get();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

        for(Integer val : sortedArr){
            System.out.print(val + " ");
        }

    }
}