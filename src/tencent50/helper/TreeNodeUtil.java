package tencent50.helper;

import java.util.Deque;
import java.util.LinkedList;

public class TreeNodeUtil {

    public static TreeNode buildTree(Integer[] nums) {
//        TreeNode[] nodes = new TreeNode[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            if (nodes[i] == null) {
//                nodes[i] = new TreeNode(nums[i]);
//            }
//            if (2*i+1 < nums.length){
//                if (nodes[2*i+1] == null) {
//                    nodes[2*i+1] = new TreeNode(nums[2*i+1]);
//                }
//                nodes[i].left = nodes[2*i+1];
//            }
//            if (2*i+2 < nums.length){
//                if (nodes[2*i+2] == null) {
//                    nodes[2*i+2] = new TreeNode(nums[2*i+2]);
//                }
//                nodes[i].right = nodes[2*i+2];
//            }
//
//        }
//        return nodes[0];

        if (nums.length == 0) {
            return new TreeNode(0);
        }
        Deque<TreeNode> nodeDeque = new LinkedList<>();
        TreeNode root = new TreeNode(nums[0]);
        nodeDeque.offer(root);
        TreeNode cur;
        int lineNodeNum = 2;
        int startIndex = 1;
        int restLength = nums.length - 1;
        while (restLength > 0) {
            for (int i = startIndex; i < startIndex + lineNodeNum; i += 2) {
                if (i == nums.length) {
                    return root;
                }
                cur = nodeDeque.poll();
                if (nums[i] != null) {
                    cur.left = new TreeNode(nums[i]);
                    nodeDeque.offer(cur.left);
                }
                if (i + 1 == nums.length) {
                    return root;
                }
                if (nums[i + 1] != null) {
                    cur.right = new TreeNode(nums[i + 1]);
                    nodeDeque.offer(cur.right);
                }
            }
            startIndex += lineNodeNum;
            restLength -= lineNodeNum;
            lineNodeNum = nodeDeque.size() * 2;
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        show(root);
    }

    // 用于获得树的层数
    public static int getTreeDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(getTreeDepth(root.left), getTreeDepth(root.right)));
    }


    private static void writeArray(TreeNode currNode, int rowIndex, int columnIndex, String[][] res, int treeDepth) {
        // 保证输入的树不为空
        if (currNode == null) return;
        // 先将当前节点保存到二维数组中
        res[rowIndex][columnIndex] = String.valueOf(currNode.val);

        // 计算当前位于树的第几层
        int currLevel = ((rowIndex + 1) / 2);
        // 若到了最后一层，则返回
        if (currLevel == treeDepth) return;
        // 计算当前行到下一行，每个元素之间的间隔（下一行的列索引与当前元素的列索引之间的间隔）
        int gap = treeDepth - currLevel - 1;

        // 对左儿子进行判断，若有左儿子，则记录相应的"/"与左儿子的值
        if (currNode.left != null) {
            res[rowIndex + 1][columnIndex - gap] = "/";
            writeArray(currNode.left, rowIndex + 2, columnIndex - gap * 2, res, treeDepth);
        }

        // 对右儿子进行判断，若有右儿子，则记录相应的"\"与右儿子的值
        if (currNode.right != null) {
            res[rowIndex + 1][columnIndex + gap] = "\\";
            writeArray(currNode.right, rowIndex + 2, columnIndex + gap * 2, res, treeDepth);
        }
    }


    private static void show(TreeNode root) {
        if (root == null) System.out.println("EMPTY!");
        // 得到树的深度
        int treeDepth = getTreeDepth(root);

        // 最后一行的宽度为2的（n - 1）次方乘3，再加1
        // 作为整个二维数组的宽度
        int arrayHeight = treeDepth * 2 - 1;
        int arrayWidth = (2 << (treeDepth - 2)) * 3 + 1;
        // 用一个字符串数组来存储每个位置应显示的元素
        String[][] res = new String[arrayHeight][arrayWidth];
        // 对数组进行初始化，默认为一个空格
        for (int i = 0; i < arrayHeight; i++) {
            for (int j = 0; j < arrayWidth; j++) {
                res[i][j] = " ";
            }
        }

        // 从根节点开始，递归处理整个树
        // res[0][(arrayWidth + 1)/ 2] = (char)(root.val + '0');
        writeArray(root, 0, arrayWidth / 2, res, treeDepth);

        // 此时，已经将所有需要显示的元素储存到了二维数组中，将其拼接并打印即可
        for (String[] line : res) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < line.length; i++) {
                sb.append(line[i]);
                if (line[i].length() > 1 && i <= line.length - 1) {
                    i += line[i].length() > 4 ? 2 : line[i].length() - 1;
                }
            }
            System.out.println(sb.toString());
        }
    }

    /**
     * 前序遍历
     * @param root
     */
    public static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    /**
     * 中序遍历
     * @param root
     */

    public static void midOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        midOrder(root.left);
        System.out.print(root.val + " ");
        midOrder(root.right);
    }

    /**
     * 后续遍历
     * @param root
     */
    public static void afterOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        afterOrder(root.left);
        afterOrder(root.right);
        System.out.print(root.val + " ");
    }

    public static void main(String[] args) {
        TreeNode root = buildTree(new Integer[]{3, 9, 20, null, null, 15, 7});
        printTree(root);
        preOrder(root);
        System.out.println();
        midOrder(root);
        System.out.println();
        afterOrder(root);
    }
}
