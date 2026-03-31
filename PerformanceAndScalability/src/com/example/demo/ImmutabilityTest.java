package com.example.demo;

public class ImmutabilityTest {
    public static void main(String[] args) {
        Person person=new Person("Test",38);
        Runnable task=()->{
            System.out.println(Thread.currentThread().getName()+": "+person.getName()+" is "+person.getAge()+" years old ");

        };
        Thread thread1=new Thread(task,"Thread-1");
        Thread thread2=new Thread(task,"Thread-2");
        Thread thread3=new Thread(task,"Thread-3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
