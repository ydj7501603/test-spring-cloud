package com.yindejin.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/** 对称二叉树，左子树先序遍历、右子树后续遍历结果相反
 * @author: YDJ
 * @Date: 2020/2/14
 * @Description:
 */
public class IsSymmetric {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    public boolean isSymmetric(TreeNode root){
        if (null == root) {
            return true;
        }
        return isMirror(root, root);
    }


    /**
     * 关键在最后，镜像，首先父相同，并且我的左边等于你的右边，我的右边等于你的左边
     * @param t
     * @param f
     * @return
     */
    private boolean isMirror(TreeNode t, TreeNode f) {
        if (null == t && f == null) return true;
        if (null == t || f == null) return false;

        return t.val == f.val && isMirror(t.left, f.right) && isMirror(t.right, f.left);
    }

}
