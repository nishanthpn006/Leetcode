import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private int preIndex = 0;
    private Map<Integer, Integer> inMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inMap.clear();

        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        return buildSubtree(preorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubtree(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInOrder = inMap.get(rootVal);

        root.left = buildSubtree(preorder, inStart, rootIndexInOrder - 1);
        root.right = buildSubtree(preorder, rootIndexInOrder + 1, inEnd);

        return root;
    }
}
