package com.urise.webapp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.partitioningBy;

public class MainStream {
    public static void main(String[] args) throws InterruptedException {
        int[] mas = {5, 1, 1, 1, 2, 2, 2, 3, 3, 5};
        List<Integer> list = Arrays.stream(mas).boxed().collect(Collectors.toList());
        System.out.println(minValue(mas));
        System.out.println(oddOrEven(list));
    }

    private static int minValue(int[] values) {
        return Arrays.stream(values).distinct().sorted().reduce(0, (x, y) -> x * 10 + y);
    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        return integers.stream().collect(partitioningBy(x -> x % 2 == 0)).get(integers.stream().collect(partitioningBy(x -> x % 2 == 0)).get(false).size() % 2 != 0);
    }
}
