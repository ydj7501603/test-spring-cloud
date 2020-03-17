package com.yindejin.test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author: YDJ
 * @Date: 2020/3/10
 * @Description:
 */
public class TestReadWriteLock {

    public static void main(String[] args) {

        //读锁不可升级为写锁，写锁可降级为读锁
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

//        //测试是否可重入
//        System.out.println("readlock lock1");
//        readWriteLock.readLock().lock();
//        readWriteLock.readLock().lock();
//        System.out.println("readlock lock2");
//        readWriteLock.readLock().unlock();
//        readWriteLock.readLock().unlock();

        //测试在不释放写锁的情况下，获取读锁
//        readWriteLock.writeLock().lock();
//        System.out.println("writelock lock1");
//        readWriteLock.readLock().lock();
//        System.out.println("writelock lock2");
//        readWriteLock.writeLock().unlock();
//        readWriteLock.readLock().unlock();


        readWriteLock.readLock().lock();
        readWriteLock.readLock().lock();
        readWriteLock.writeLock().lock();
        System.out.println(1 << 16);

    }

}
