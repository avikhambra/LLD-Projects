package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {

    List<Integer> arrToSort;
    ExecutorService es;

    Sorter(List<Integer> arrToSort , ExecutorService es){
        this.arrToSort = arrToSort;
        this.es = es;
    }

    public List<Integer> call() throws ExecutionException , InterruptedException{

        if(arrToSort.size() <= 1){
            return arrToSort;
        }

        int mid = arrToSort.size()/2;

        List<Integer> leftArray  = new ArrayList<>();
        List<Integer> rightArray = new ArrayList<>();

        for(int i = 0; i<mid; i++){
            leftArray.add(arrToSort.get(i));
        }

        for(int i = mid; i<arrToSort.size(); i++){
            rightArray.add(arrToSort.get(i));
        }

        Sorter LAS = new Sorter(leftArray , this.es);
        Sorter RAS = new Sorter(rightArray , this.es);

        Future<List<Integer>> LSAFuture = this.es.submit(LAS);
        Future<List<Integer>> RSAFuture = this.es.submit(RAS);

        List<Integer> sortedLA = LSAFuture.get();
        List<Integer> sortedRA = RSAFuture.get();

        int i = 0;
        int j = 0;
        List<Integer> sa = new ArrayList<>();

        while (i < sortedLA.size() && j < sortedRA.size()){

            if(sortedLA.get(i) <= sortedRA.get(j)){
                sa.add(sortedLA.get(i));
                i += 1;
            }else{
                sa.add(sortedRA.get(j));
                j += 1;
            }

        }

        while(i < sortedLA.size()){
            sa.add(sortedLA.get(i));
            i += 1;
        }

        while(j < sortedRA.size()){
            sa.add(sortedRA.get(j));
            j += 1;
        }

        return sa;

    }

}
