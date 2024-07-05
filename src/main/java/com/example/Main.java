package com.example;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Integer min, max;
        Double median, average;
        List<Integer> max_seq, min_seq;

        List<Integer> num = File_Interaction.getData();

        max_seq = getMaxSeq(num);
        min_seq = getMinSeq(num);

        Collections.sort(num);

        min = num.get(0);
        max = num.get(num.size() - 1);
        median = getMedian(num);
        average = num.stream().mapToInt(x -> x).average().getAsDouble();


//        System.out.println(num.toString());
        System.out.println("max_num: " +  max);
        System.out.println("min_num: " + min);
        System.out.println("median: " + median);
        System.out.println("average: " + average);

        System.out.println("increases_seq: " + max_seq);
        System.out.println("decreasing_seq: " + min_seq);

    }

    public static Double getMedian (List<Integer> list) {

        if (list.size() % 2 == 0) {
            return (list.get(list.size() / 2 - 1) + list.get(list.size() / 2)) * 0.5 ;
        } else {
            return list.get(list.size() / 2) * 1.0 ;
        }
    }



    public static List<Integer> getMaxSeq(List<Integer> list) {
        List<Integer> memory = new ArrayList<>();
        List<Integer> temporarily = new ArrayList<>();

        for (Integer some : list) {
            if (temporarily.isEmpty() || temporarily.get(temporarily.size() - 1) <= some) {
                temporarily.add(some);
            } else {
                temporarily = new ArrayList<>();
                temporarily.add(some);
            }

            if (temporarily.size() > memory.size()) {
                memory = new ArrayList<>(temporarily);
            }
        }

        return memory;
    }




    public static List<Integer> getMinSeq(List<Integer> list) {
        List<Integer> memory = new ArrayList<>();
        List<Integer> temporarily = new ArrayList<>();

        for (Integer some : list) {
            if (temporarily.isEmpty() || temporarily.get(temporarily.size() - 1) >= some) {
                temporarily.add(some);
            } else {
                temporarily = new ArrayList<>();
                temporarily.add(some);
            }

            if (temporarily.size() > memory.size()) {
                memory = new ArrayList<>(temporarily);
            }
        }

        return memory;
    }


}