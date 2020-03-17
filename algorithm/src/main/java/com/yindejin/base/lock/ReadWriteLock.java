package com.yindejin.base.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: YDJ
 * @Date: 2020/3/1
 * @Description:
 */
public class ReadWriteLock {

    public static void main(String[] args) throws InterruptedException {
//        lockShengji();
//        lockJiangji();
        testMultiThread();

        testMultiThread2();
    }



    private static ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();



    private static void testMultiThread() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //主线程先拿读锁不释放。

        readWriteLock.readLock().lock();
        System.out.println("主线程拿到了读锁，等待三秒释放");

        pool.submit(()->{
            readWriteLock.writeLock().lock();

            System.out.println("线程1，拿到了写锁");
            readWriteLock.writeLock().unlock();
        });

        TimeUnit.SECONDS.sleep(3);

        readWriteLock.readLock().unlock();
        pool.shutdown();

    }

    private static void testMultiThread2() throws InterruptedException {
        ExecutorService pool = Executors.newFixedThreadPool(5);
        //主线程先拿读锁不释放。

        readWriteLock.writeLock().lock();
        System.out.println("主线程拿到了读锁，等待三秒释放");

        pool.submit(()->{
            readWriteLock.writeLock().lock();

            System.out.println("线程2，拿到了写锁");
            readWriteLock.writeLock().unlock();
        });

        TimeUnit.SECONDS.sleep(3);

        readWriteLock.writeLock().unlock();
        pool.shutdown();

    }


    /**
     * 读锁不能升级为写锁，出现死锁
     */
    private static void lockShengji(){
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        readWriteLock.readLock().lock();;

        readWriteLock.writeLock().lock();

        System.out.println("我死锁了...");
    }


    private static void lockJiangji(){
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        readWriteLock.writeLock().lock();
        readWriteLock.readLock().lock();

        System.out.println("我没有死锁....");
    }


}
