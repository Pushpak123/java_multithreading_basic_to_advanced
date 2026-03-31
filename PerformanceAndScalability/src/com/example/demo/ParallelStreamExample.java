package com.example.demo;

import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        numbers.stream().forEach(number->{
            System.out.println("Thread: "+Thread.currentThread().getName()+", Number: "+number+", square: "+ (number*number));
        });
    }
}
