package top.karlo.queue;

import top.karlo.array.Array;

/**
 * 功能描述: 数组构建的队列
 *
 * @author karlo
 * @date 2018/12/8 21:14
 * @since 1.0.0
 */

public class ArrayQueue<E> implements Queue<E>{
    private Array<E> array;
    private int size;

    public ArrayQueue(int capacity) {
        array = new Array<E>(capacity);
        size = 0;
    }

    public ArrayQueue() {
        this(10);
    }

    public boolean find(E e){
        for (int i = 0; i < array.getSize(); i++) {
            if(array.findEle(i).equals(e)){
                return true;
            }
        }
        return false;
    }

    public int getCapacity(){
        return array.getCapacity();
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        String s = String.format("Queue size : %d ,capacity : %d", size, getCapacity());
        System.out.println(s);
        sb.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.findEle(i));
            if(i != array.getSize()-1){
                sb.append(", ");
            }else{
                sb.append("] tail");
            }
        }
        return sb.toString();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirstEle();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
