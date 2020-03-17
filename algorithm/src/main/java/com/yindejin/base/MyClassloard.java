package com.yindejin.base;

/**
 * @author: YDJ
 * @Date: 2020/2/28
 * @Description:
 */
public class MyClassloard extends ClassLoader {


    /**
     * 覆盖findclass，实现自己查找类，重写loadclass 可以破坏双亲委派
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {

        return super.findClass(name);
    }



}
