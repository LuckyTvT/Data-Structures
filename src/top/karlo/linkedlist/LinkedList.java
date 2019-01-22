package top.karlo.linkedlist;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 12/11/2018 09:41
 */
public class LinkedList<E> {

    private int size;
    /**
     *  虚拟头结点
     */
    private Node<E> dummyHead ;

    class Node<E>{
        Node<E> next;
        E e;
        public Node(E e, Node<E> next){
            this.next = next;
            this.e = e;
        }

        public Node(E e){
            this.e = e;
            next = null;
        }
    }

    public LinkedList(){
        this.size = 0;
        this.dummyHead = new Node<E>(null,null);
    }


    public void add(E e){
        Node<E> eNode = new Node<>(e);
        eNode.next = dummyHead.next;
        dummyHead.next = eNode;
        size++;
    }

    public boolean remove(E e){
        if(size == 0 || size < 0){
            throw new IllegalArgumentException("size illegal！");
        }
        Node<E> pre = dummyHead;
        Node<E> curNode = dummyHead.next;

        for (int i = 0;i < size;i++) {
            if(curNode != null && curNode.e.equals(e)){
                pre.next = curNode.next;
                curNode.next = null;
                size--;
                return true;
            }
            pre = curNode;
            curNode = curNode.next;
        }
        return false;

    }

    @Override
    public String toString(){
        Node<E> curNode = dummyHead.next;
        StringBuilder sb = new StringBuilder();
        sb.append("head [ ");
        while(curNode != null){
            sb.append(curNode.e);
            if((curNode = curNode.next) != null){
                sb.append(", ");
            }
        }
        sb.append(" ] ");
        return sb.toString();
    }

}
