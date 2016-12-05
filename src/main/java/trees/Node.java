package trees;

/**
 * Created by wopqw on 05.12.16.
 */
public class Node {

    public int key;

    public double data;

    public Node leftChild;

    public Node rightChild;

    public Node(int key, double data){

        this.key = key;
        this.data = data;
    }

    public void displayNode(){
        System.out.print("{"+key+", "+data+"}");
    }
}
