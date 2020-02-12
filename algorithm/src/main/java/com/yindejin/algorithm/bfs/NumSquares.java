package com.yindejin.algorithm.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** 完全平方数
 * @author: YDJ
 * @Date: 2020/2/10
 * @Description:
 */
public class NumSquares {



    private class Node{

        private int val;

        private int step;

        public Node(int val, int step){
            this.val = val;
            this.step = step;
        }

    }

    public int numSquares(int n) {
        Queue<Node> queue = new LinkedList();
        queue.add(new Node(n, 1));
        boolean[] visited = new boolean[n];

        while (!queue.isEmpty()){
            Node node = queue.poll();
            int val = node.val;
            int step = node.step;

            for (int i = 1; ; i++) {
                int nextVal = val - i*i;
                if (nextVal < 0) {
                    break;
                }

                if (nextVal == 0){
                    return step;
                }

                if (!visited[nextVal]){
                    queue.add(new Node(nextVal, step+1));
                    visited[nextVal] = true;
                }

            }
        }
        return -1;
    }

}
