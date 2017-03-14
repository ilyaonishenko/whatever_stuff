/**
 * Created by wopqw on 29.01.17.
 */
public class LinkedStack<T> {
    public class Node<U>{
        U item;
        Node<U> next;
        public Node(){
            item = null;
            next = null;
        }
        public Node(U item, Node next){
            this.item = item;
            this.next = next;
        }

        public boolean isEnd(){
            return next==null&&item==null;
        }
    }

    private Node<T> top = new Node();
    public void push(T item){
        top = new Node(item, top);
    }
    public T pop(){
        T result = top.item;
        if(!top.isEnd())
            top = top.next;
        return result;
    }


}
