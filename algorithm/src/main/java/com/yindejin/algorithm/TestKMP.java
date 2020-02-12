package com.yindejin.algorithm;

import java.util.HashMap;

/**
 * @author: YDJ
 * @Date: 2019/12/20
 * @Description: 什么KMP？两个字符串a, b 找到b在a字符串是否存在，存在的话，开始的位置是多少。这就是KMP。
 * 怎么找？一种是挨个比较。发生不匹配就回退。
 * KMP 就是想办法，怎么回退的少一些。做法就是发生不匹配的时候，a不会退，b回退。算法要做的就是要回退多少。
 * 这里有两篇文章，一篇是极客时间里的，一个是知乎的，知乎的见：https://www.zhihu.com/question/21923021/answer/281346746
 * 海纳的回答。
 * 这里就是要回退多少，是看next数组对应的值。
 * next数组是什么，就是要回退多少。怎么计算的？
 *
 */
public class TestKMP {


    public static void main(String[] args) {

    }
}