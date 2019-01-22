package top.karlo.tree;

import java.util.LinkedList;
import java.util.Queue;


/**
 * 功能描述：
 *
 * @author Karlo
 * @date 12/20/2018 14:06
 */
public class BST<E extends Comparable<E>> {
    public int size;
    public Node root;

    private class Node<E>{
        E e;
        Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node, E e) {
        if(node == null){
            size ++;
            return new Node<E>(e);
        }
        if(e.compareTo((E)node.e) > 0){
            node.right = add(node.right,e);
        }else if(e.compareTo((E)node.e) < 0){
            node.left = add(node.left,e);
        }
        return node;
    }

    //前序遍历    root,left,right
    public void preOrder(Node root){
        if(root == null){
            return;
        }
        System.out.println(root.e);
        preOrder(root.left);
        preOrder(root.right);
    }

    //中序遍历    left,root,right
    public void inOrder(Node root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        System.out.println(root.e);
        inOrder(root.right);
    }

    //后序遍历    left,right,root
    public void postOrder(Node root){
        if(root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.e);
    }

    //层序遍历
    public void levelOrder(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.e);
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }

        }

    }





}
