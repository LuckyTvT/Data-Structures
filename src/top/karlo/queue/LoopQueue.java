package top.karlo.queue;

import top.karlo.array.Array;

/**
 * 功能描述:
 *      循环队列
 * @author karlo
 * @date 2018/12/8 21:14
 * @since 1.0.0
 */

public class LoopQueue<E> implements Queue<E> {

    private Array<E> array;
    private int front,tail;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        array = new Array<E>(capacity);
        int front = 0;
        int tail = 0;

    }

    //往队尾部添加元素
    @Override
    public void enqueue(E e) {
        if(tail < front && front - tail == 1){
            //如果容量达到上限，则进行扩容
            resize();
        }
        if(tail > front && tail - front == array.getCapacity()){
            resize();
        }
        if(tail == getCapacity() && front >1){
            tail = 0;
        }
        array.add(tail,e);
        tail++;

    }

    private void resize() {
        Array<E> eArray = new Array<>(array.getCapacity() * 2);
        if(tail > front){
            for (int i = front; i <= tail - 1; i++) {
                eArray.addLast(array.findEle(i));
            }
        }else{
            for (int i = front; i != tail; i++) {
                eArray.addLast(array.findEle(i));
                if(i+1 == array.getCapacity()){
                    i = -1;
                }
            }
        }
        front = 0;
        tail = array.getSize();
        array = eArray;

    }

    //从队列首部移除元素
    @Override
    public E dequeue() {
        E e = array.findEle(front);
        array.setEle(front,null);

        if(front == array.getCapacity() - 1){
            front = 0;
        }else{
            front ++;
        }
        return e;
    }

    @Override
    public int getSize() {
        int size = 0;
        if(front < tail ){
            size = tail - front;
        }else{
            size = tail - 1 + front;
        }
        return size;
    }

    public int getCapacity(){
        return array.getCapacity();
    }

    @Override
    public E peek() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        String s = String.format("LoopQueue size:%d , capacity:%d", getSize(), array.getCapacity());
        System.out.println(s);
        sb.append("front [");


        for (int i = front; i != tail; i++) {
            sb.append(array.findEle(i));
            if(i+1 >= array.getCapacity()){
                i = 0;
            }
            if(i != tail-1){
                sb.append(", ");
            }else{
                sb.append("] tail");
            }
        }

        return sb.toString();
    }

}
