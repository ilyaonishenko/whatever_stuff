package trees.BinarySearchTree;

import trees.Node;

import java.util.Stack;

/**
 * Created by wopqw on 05.12.16.
 */
@SuppressWarnings("Duplicates")
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public Node find(int key) {

        Node current = root;

        while (current.key != key) {

            if (current.key < key)
                current = current.leftChild;
            else current = current.rightChild;

            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int key, double data) {

        Node newNode = new Node(key, data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while (true) {

            parent = current;

            if (current.key < newNode.key) {
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }

        }
    }

    public boolean delete(int key) {

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while (current.key != key) {
            parent = current;
            if (current.key < key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } else if (current.rightChild == null) {
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (current.leftChild == null) {
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        } else {
            Node successor = getSuccessor(current);

            if (current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {

            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successor.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }

    public void traverse(int traverseType) {

        switch (traverseType) {
            case 1:
                System.out.println("PreOrder");
                preOrder(root);
                break;
            case 2:
                System.out.println("inOrder");
                inOrder(root);
                break;
            case 3:
                System.out.println("postOrder");
                postOrder(root);
                break;
        }
    }

    private void preOrder(Node localRoot) {

        if (localRoot != null) {
            System.out.println(localRoot.data);
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(Node localRoot) {

        if (localRoot != null) {
            inOrder(localRoot.leftChild);
            System.out.println(localRoot.data);
            inOrder(localRoot.rightChild);
        }
    }

    private void postOrder(Node localRoot) {

        if (localRoot != null) {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.println(localRoot.data);
        }
    }

    public void displayTree() {
        Stack<Node> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("......................................................");
        while (!isRowEmpty) {
            Stack<Node> localStack = new Stack<>();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++)
                System.out.print(' ');
            while (!globalStack.isEmpty()) {
                Node temp = globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.data);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globalStack.push(localStack.pop());
        }
        System.out.println("......................................................");
    }
}
