package top.karlo.array;

public class Array<E> {

    private E[] data;
    //数组元素个数
    private int size;

    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public Array(){
        this(10);
    }

    //获取数组容量
    public int getCapacity(){
        return data.length;
    }
    //获取数组大小
    public int getSize() {
        return size;
    }
    //判断数组是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    //添加元素至数组指定位置
    public void add(int index,E e){
        if(index < 0 || index > getCapacity()){
            throw new IllegalArgumentException("index illegal!");
        }
//        if(size == getCapacity()){
//            resize();
//        }
//        if(index == 0){
//            for (int i = size; i > 0 ; i--) {
//                data[i] = data[i-1];
//            }
//        }

        data[index] = e;
        size ++;

    }

    public E findEle(int index){
        if(index < 0 || index >=  getCapacity()){
            throw new IllegalArgumentException("index illegal! index : "+index);
        }
        return data[index];
    }

    private void resize() {
        E[] newData = (E[])new Object[getCapacity()*2];
        for (int i = 0; i < getSize(); i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //添加元素至数组第一个位置
    public void addFirst(E e){
        add(0,e);
    }
    //添加元素至数组最后一个位置
    public void addLast(E e){
        add(size,e);
    }


    //从数组中取出元素
    public E removeEle(int index){
        E e = data[index];
        for (int i = index; i < size-1; i++) {
            data[i] = data[i+1];
        }
        data[size] = null;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0){
            E[] newData = (E[])new Object[getCapacity() / 2];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        return e;
    }

    public E get(int index){
        return data[index];
    }

    public E removeFirstEle(){
        return removeEle(0);
    }

    public E removeLastEle(){
        return removeEle(getSize());
    }

    public void setEle(int index,E e){
        data[index] = e;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        String s = String.format("Array size:%d ,capacity:%d", size, getCapacity());
        System.out.println(s);
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if(i != size-1){
                sb.append(", ");
            }else{
                sb.append("]");
            }
        }
        return sb.toString();

    }



}
