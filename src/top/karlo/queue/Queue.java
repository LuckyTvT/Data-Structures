package top.karlo.queue;

public interface Queue<E> {

    //添加元素进队列
    void enqueue(E e);
    //从队列中取出元素
    E dequeue();
    //获取队列元素个数
    int getSize();
    //查看队列头元素
    E peek();
    //查看队列是否是空的
    boolean isEmpty();



}
