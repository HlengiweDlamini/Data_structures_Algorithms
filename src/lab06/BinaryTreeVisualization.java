package lab06;

import javax.swing.*;
        import java.awt.*;
        import java.util.function.Consumer;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int key) {
        this.key = key;
        left = null;
        right = null;
    }

    public TreeNode insert(int key, BinaryTreeVisualizationApp app) {
        if (key < this.key) {
            if (left == null)
                left = new TreeNode(key);
            else
                left = left.insert(key, app);
        } else if (key > this.key) {
            if (right == null)
                right = new TreeNode(key);
            else
                right = right.insert(key, app);
        }
        app.repaint();
        return this;
    }

    public boolean search(int key) {
        if (key == this.key)
            return true;
        else if (key < this.key && left != null)
            return left.search(key);
        else if (key > this.key && right != null)
            return right.search(key);
        return false;
    }

    public TreeNode delete(int key, BinaryTreeVisualizationApp app) {
        if (key < this.key && left != null)
            left = left.delete(key, app);
        else if (key > this.key && right != null)
            right = right.delete(key, app);
        else if (key == this.key) {
            if (left == null && right == null)
                return null;
            else if (left == null)
                return right;
            else if (right == null)
                return left;
            else {
                this.key = right.getMin();
                right = right.delete(this.key, app);
            }
        }
        app.repaint();
        return this;
    }

    public int findMinimum() {
        if (left == null)
            return key;
        return left.findMinimum();
    }

    public void inorder(Consumer<Integer> op) {
        if (left != null) left.inorder(op);
        op.accept(key);
        if (right != null) right.inorder(op);
    }

    private int getMin() {
        if (left == null)
            return key;
        return left.getMin();
    }
}

class BinaryTreeVisualizationApp extends JPanel {
    private TreeNode root;

    public BinaryTreeVisualizationApp() {
        root = null;
    }

    public void insert(int key) {
        root = (root == null) ? new TreeNode(key) : root.insert(key, this);
    }

    public boolean search(int key) {
        return root != null && root.search(key);
    }

    public void delete(int key) {
        if (root != null)
            root = root.delete(key, this);
    }

    public int findMinimum() {
        return (root == null) ? Integer.MIN_VALUE : root.findMinimum();
    }

    public void inorder(Consumer<Integer> op) {
        if (root != null) root.inorder(op);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null)
            drawTree(g, root, getWidth() / 2, 30, getWidth() / 4);
    }

    private void drawTree(Graphics g, TreeNode node, int x, int y, int xOffset) {
        g.setColor(Color.BLACK);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(node.key), x + 10, y + 20);

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 15, x - xOffset + 15, y + 60);
            drawTree(g, node.left, x - xOffset, y + 60, xOffset / 2);
        }
        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 15, x + xOffset + 15, y + 60);
            drawTree(g, node.right, x + xOffset, y + 60, xOffset / 2);
        }
    }
}

public class BinaryTreeVisualization {
    public static void main(String[] args) {
        BinaryTreeVisualizationApp app = new BinaryTreeVisualizationApp();
        JFrame frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(app);
        frame.setVisible(true);

        // Example usage:
        app.insert(30);
        app.insert(30);
        app.insert(20);
        app.insert(40);
        app.insert(7);
        app.insert(60);
        app.insert(8);

        // To demonstrate other methods, you can interact with the BST via GUI buttons or by calling the methods directly
        System.out.println("Minimum element in the tree: " + app.findMinimum());
        System.out.println("Is 40 present in the tree?: " + app.search(80));
        app.delete(80);
        System.out.println("Is 40 present in the tree after deletion? " + app.search(80));
    }
}

