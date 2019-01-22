package top.karlo.queue;

/**
 * 功能描述:
 *      循环队列
 * @author karlo
 * @date 2018/12/8 21:14
 * @since 1.0.0
 */

public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front,tail;

    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        data = (E[])new Object[capacity+1];
        int front = 0;
        int tail = 0;

    }

    //往队尾部添加元素
    @Override
    public void enqueue(E e) {
        //因为循环队列需要浪费一个空间， 则判断队列满的条件为 (tail+1)%data.length = front
        if((tail+1)%data.length == front){
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail++;
        if(tail == data.length && front >1){
            tail = 0;
        }

    }

    private void resize(int newCapacity) {
        E[] eArray = (E[])new Object[newCapacity+1];
        for (int i = 0; i < getCapacity() ; i++) {
            eArray[i] = data[(i+front)%data.length];
        }
        front = 0;
        tail = getCapacity();
        data = eArray;

    }

    //从队列首部移除元素
    @Override
    public E dequeue() {
        E e = data[front];
        data[front] = null;

        if(front == getCapacity() - 1){
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
            size = tail-1 - front;
        }else{
            size = tail + (data.length - front);
        }
        return size;
    }

    public int getCapacity(){
        return data.length-1;
    }

    @Override
    public E peek() {
        return data[front];
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        String s = String.format("LoopQueue size:%d , capacity:%d", getSize(), getCapacity());
        System.out.println(s);
        sb.append("front [");


        for (int i = front; i != tail ; i = (i+1)%data.length) {
            sb.append(data[i]);
            if(i != tail-1){
                sb.append(", ");
            }
        }
        sb.append("] tail");
        return sb.toString();
    }

}
