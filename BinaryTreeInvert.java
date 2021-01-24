import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class BinaryTreeInvert {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Node root = createTree();
        Node invertedRoot = invertTree(root);
        List<List<Integer>> solution = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(invertedRoot);
        while (!queue.isEmpty()) {
            List<Integer> tempSol = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node currNode = queue.poll();
                tempSol.add(currNode.data);
                if (currNode.left != null)
                    queue.offer(currNode.left);
                if (currNode.right != null)
                    queue.offer(currNode.right);
            }
            solution.add(tempSol);
        }
        System.out.println(solution);
    }

    static Node invertTree(Node root) {
        if (root == null)
            return null;
        Node left = invertTree(root.left);
        Node right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    static Node createTree() {
        Node root = null;

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1)
            return root;

        root = new Node(data);
        System.out.println("Left subtree data for " + data + ": ");
        root.left = createTree();

        System.out.println("Right subtree data for " + data + ": ");
        root.right = createTree();

        return root;
    }
}