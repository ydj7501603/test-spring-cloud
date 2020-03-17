package com.yindejin.base;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: YDJ
 * @Date: 2020/2/27
 * @Description: 如果不需要保证顺序，那么
 */
public class ThreadOrderRun {

    public static void main(String[] args) {

        semaporeOrder();
    }


    private static void conditionOrder() {
        ExecutorService pool = Executors.newFixedThreadPool(4);

        Lock lock = new ReentrantLock();
        Condition a = lock.newCondition();
        Condition b = lock.newCondition();
        Condition c = lock.newCondition();
        Condition d = lock.newCondition();

        pool.submit(new PrintThread("A",a, b, lock));

        pool.submit(new PrintThread("B",b, c, lock));

        pool.submit(new PrintThread("C",c, d, lock));

        pool.submit(new PrintThread("D", d, a, lock));

        lock.lock();
        try {
            a.signal();
        }finally {
            lock.unlock();
        }
    }


    private static void semaporeOrder() {

        ExecutorService pool = Executors.newFixedThreadPool(4);

        Semaphore s1 = new Semaphore(1);
        Semaphore s2 = new Semaphore(0);
        Semaphore s3 = new Semaphore(0);
        Semaphore s4 = new Semaphore(0);


        pool.submit(new PrintOrderThread("A", s1, s2));
        pool.submit(new PrintOrderThread("B", s2, s3));
        pool.submit(new PrintOrderThread("C", s3, s4));
        pool.submit(new PrintOrderThread("D", s4, s1));



    }

    static class PrintThread implements Runnable{

        private String letter;

        private Condition curr;

        private Condition next;

        private Lock lock;

        public PrintThread(String letter, Condition curr, Condition next, Lock lock) {
            this.letter = letter;
            this.curr = curr;
            this.lock = lock;
            this.next = next;
        }

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    curr.await();
                    System.out.println(letter);
                    next.signal();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                    try {
                        TimeUnit.SECONDS.sleep(1);
                        if ("D".equalsIgnoreCase(letter)) {
                            TimeUnit.MILLISECONDS.sleep(5);
                            lock.lock();
                            try {
                                next.signal();
                            }finally {
                                lock.unlock();
                            }
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    static class PrintOrderThread implements Runnable{

        private String letter;

        private Semaphore curr;

        private Semaphore next;


        public PrintOrderThread(String letter, Semaphore curr, Semaphore next) {
            this.curr = curr;
            this.next = next;
            this.letter = letter;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    curr.acquire();
                    System.out.println(letter);
                    next.release();

                }catch (Exception e){

                }



            }
        }
    }
}
