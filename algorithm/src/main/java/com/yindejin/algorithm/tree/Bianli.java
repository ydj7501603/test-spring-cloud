package com.yindejin.algorithm.tree;

import java.util.Stack;

/**
 * @author: YDJ
 * @Date: 2020/2/25
 * @Description:
 */
public class Bianli {


    /**
     * 前序遍历非递归
     * @param node
     */
    void preOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack();
        while (node != null || !stack.isEmpty()) {
            while (node != null){
                System.out.println(node.value);
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }


    /**
     * 非递归的中序遍历
     * @param node
     */
    void midOrder(TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.println(node.value);
                node = node.right;
            }
        }
    }

}

class TreeNode//节点结构
{
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int value)
    {
        this.value = value;
    }
}

