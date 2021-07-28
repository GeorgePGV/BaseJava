package com.urise.webapp;

import java.util.ArrayList;
import java.util.List;

public class MainStream {
    private static int minValue(int[] values) {
        Thread thread0 = new Thread() {
            int result = 0;

            @Override
            public void run() {
                ArrayList<Integer> list = new ArrayList<>();
                for (Integer i : values) {
                    if (!list.contains(i)) {
                        list.add(i);
                    }
                }
                for (int a = 1; a < list.size(); a++) {
                    int min = list.get(0);
                    for (int i = 1; i < list.size(); i++) {
                        if (min > list.get(0)) min = list.get(i);
                    }
                    result += min * 10 * list.size();
                    list.remove(min);
                }
                return result;
            }

            public int getMin() {
                return result;
            }
        };

        thread0.start();


    }

    private static List<Integer> oddOrEven(List<Integer> integers) {
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                int sum = 0;
                for(int i = 0; i < integers.size(); i++) {
                    sum += integers.get(i);
                }
                if(sum % 2 == 0){
                    integers.removeIf(i -> i % 2 == 0);
                } else {
                    integers.removeIf(i -> i % 2 != 0);
                }
            }
        };
        thread0.start();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] mas = { 2, 3, 4, 8, 9 };
        List<Integer> list = new ArrayList();
        list.add(2);
        list.add(6);
        list.add(8);
        list.add(3);
        System.out.println(minValue(mas));
        System.out.println(oddOrEven(list));
    }
}
