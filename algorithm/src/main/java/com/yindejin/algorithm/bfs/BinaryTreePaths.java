package com.yindejin.algorithm.bfs;

import java.util.ArrayList;
import java.util.List;

/** 二叉树的所有路径
 * @author: YDJ
 * @Date: 2020/2/12
 * @Description:
 */
public class BinaryTreePaths {


    List<String> output = new ArrayList<>();

    public List<String> binaryTreePaths(TreeNode treeNode) {
        if (null == treeNode) {
            return output;
        }
        binaryTreePaths(treeNode, "");
        return output;
    }


    private void binaryTreePaths(TreeNode treeNode, String combinaStr){
        if (treeNode == null) {
            return;
        }
        if ("".equalsIgnoreCase(combinaStr)){
            combinaStr = treeNode.val+"";
        }else {
            combinaStr = combinaStr + "->" + treeNode.val;
        }

        if (treeNode.left == null && treeNode.right == null){
            output.add(combinaStr);
            return;
        }

        binaryTreePaths(treeNode.left, combinaStr);
        binaryTreePaths(treeNode.right, combinaStr);

    }



    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
   }
}
