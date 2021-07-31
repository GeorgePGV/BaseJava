package com.urise.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.partitioningBy;

public class MainStream {
    private static void minValue(int[] values) {
        IntStream stream = Arrays.stream(values);
        List<Integer> uniqueElements = Arrays.stream(values).boxed().collect(Collectors.toList()).stream().distinct().collect(Collectors.toList());


    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        return integers.stream().collect(partitioningBy(x -> x % 2 == 0)).get(integers.stream().collect(partitioningBy(x -> x % 2 == 0)).get(false).size() % 2 != 0);
    }

    public static void main(String[] args) throws InterruptedException {
        int[] mas = { 5,1,1,1,2,2,2,3,3,5 };
        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(3);
        list.add(1);
        minValue(mas);
        System.out.println(oddOrEven(list));
    }
}
