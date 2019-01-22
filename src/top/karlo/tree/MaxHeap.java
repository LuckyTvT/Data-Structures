package top.karlo.tree;

import top.karlo.array.Array;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/1/22 15:28
 *
 * 最大堆：每个子树的左右叶子节点都小于其父节点
 * left子元素索引= 父元素索引 * 2 + 1
 * right子元素索引 = 父元素索引 * 2 + 2
 * （前提是根元素索引从0开始）
 *
 *
 */
public class MaxHeap<E extends Comparable<E>> {

    //定义一个数组用来存储变量
    private Array<E> data;
    //定义最大堆的堆顶对象
    private E root = null;
    //统计堆内元素个数
    private int size ;

    public MaxHeap(){
        this(10);
    }

    public MaxHeap(int capacity){
        data = new Array<>(capacity);
        size = 0;
    }

    /**
     * 向堆中添加数据
     * @param e
     */
    public void add(E e){
        if(e == null ){
            throw new IllegalArgumentException("无法添加空元素");
        }

        //如果内部数组为空就将数据直接丢进数组index为0的位置，并设置root值
        if(size == 0){
            data.add(0,e);
            root = e;
            size ++;
        }else{
            //添加元素涉及到扩容的问题
            if(size == data.getCapacity()){
                reCapacity();
            }
            data.add(size,e);
            //上浮操作，将新加入的元素调整的正确的位置
            siftUp(size);
            size ++;
        }
    }

    /**
     * 上浮操作
     * @param index
     */
    private void siftUp(int index) {
        //跟父元素比较
        while(index != 0 && (index-1)/2 >= 0){
            E child = data.get(index);
            E parent = data.get((index - 1)/2);
            if(child.compareTo(parent) > 0){
                data.setEle((index -1) /2,child);
                data.setEle(index,parent);
                index = (index - 1)/2;
            }
        }

    }

    public E getRoot(){
        return root;
    }

    private void reCapacity() {
        Array<E> newData = new Array(data.getCapacity() * 2);
        for (int i = 0; i < data.getCapacity(); i++) {
            newData.setEle(i,data.get(i));
        }
        data = newData;
    }

    public int getSize(){
        return size;
    }



    public void toString1() {
        StringBuilder sb = new StringBuilder();
        sb.append(data.get(0));
        for (int i = 1; i < data.getSize(); i++) {
            sb.append(","+data.get(i));
        }
        System.out.println("MaxHeap{" +
                "data=" + sb.toString() +
                '}');

    }
}
