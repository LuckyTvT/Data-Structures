package top.karlo.tree;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 2019/1/22 17:15
 */
public class MainTest {

    public static void main(String[] args) {
        MaxHeap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < 15; i++) {
            heap.add(i);
        }
        heap.toString1();

    }
}
