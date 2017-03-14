package trees.BinarySearchTree;

import trees.Node;

/**
 * Created by wopqw on 06.12.16.
 */
@SuppressWarnings("Duplicates")
public class BST {

    private Node root;

    public Node search(int key){

        if (root == null)
            return null;

        Node current = root;

        while( current.key != key){

            if (current.key > key)
                current = current.leftChild;
            else
                current = current.rightChild;

            if (current == null)
                return null;
        }

        return current;
    }

    public void insert(int key, double data){

        Node newNode = new Node(key, data);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = root;

        while(true){

            parent = current;

            if (current.key > key){
                current = current.leftChild;
                if (current == null){
                    parent.leftChild = newNode;
                    return;
                }
            } else if (current.key < key){
                current = current.rightChild;
                if (current == null){
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }

    public boolean delete(int key){

        if (root == null)
            return false;

        Node current = root;
        Node currentParent = root;
        boolean isLeftChild = true;

        while (true){

            currentParent = current;

            if(current.key > key){
                current = current.leftChild;
                isLeftChild = true;
            } else if( current.key < key){
                current = currentParent.rightChild;
                isLeftChild = false;
            }

            if (current.key == key)
                break;
        }

        if (current.leftChild == null && current.rightChild == null){

            if (current == root)
                root = null;
            else if (isLeftChild)
                currentParent.leftChild = null;
            else
                current.rightChild = null;
        } else if (current.rightChild == null){

            if (current == root)
                root = current.leftChild;
            else if (isLeftChild)
                currentParent.leftChild = current.leftChild;
            else
                currentParent.rightChild = current.leftChild;
        } else if (current.leftChild == null){

            if (current == root)
                root = current.rightChild;
            else if (isLeftChild)
                currentParent.leftChild = current.rightChild;
            else
                currentParent.rightChild = current.rightChild;
        } else {

            Node successor = getSuccessor(current);

            if(current == root)
                root = successor;
            else if(isLeftChild)
                current.leftChild = successor;
            else
                current.rightChild = successor;
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

        if (successor != delNode.rightChild){
            successor.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }

        return successor;
    }
}
