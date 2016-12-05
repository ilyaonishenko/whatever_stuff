package trees.BinarySearchTree;

import trees.Node;

/**
 * Created by wopqw on 05.12.16.
 */
public class BinarySearchTree {

    private Node root;

    public BinarySearchTree(){
        root = null;
    }

    public Node find(int key){

        Node current = root;

        while(current.key != key){

            if (current.key < key)
                current = root.leftChild;
            else current = root.rightChild;

            if(current == null)
                return null;
        }
        return current;
    }

    public void insert(int key, double data){

        Node newNode = new Node(key, data);

        if(root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent;

        while(true){

            parent = current;

            if(current.key < newNode.key) {
                current = current.leftChild;
                if(current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else {
                current = current.rightChild;
                if(current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }

        }
    }

    public boolean delete(int key){

        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.key != key){
            parent = current;
            if(current.key < key) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null)
                return false;
        }
        if(current.leftChild == null && current.rightChild == null){
            if (current == root)
                root = null;
            else if (isLeftChild)
                parent.leftChild = null;
            else
                parent.rightChild = null;
        } else if (current.rightChild == null){
            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                parent.leftChild = current.leftChild;
            else
                parent.rightChild = current.leftChild;
        } else if (current.leftChild == null){
            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                parent.leftChild = current.rightChild;
            else
                parent.rightChild = current.rightChild;
        } else {
            Node successor = getSuccessor(current);

            if(current == root)
                root = successor;
            else if (isLeftChild)
                parent.leftChild = successor;
            else
                parent.rightChild = successor;
        }
        return true;
    }

    private Node getSuccessor(Node delNode){

        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null){

            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != delNode.rightChild){
            successor.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }
}
