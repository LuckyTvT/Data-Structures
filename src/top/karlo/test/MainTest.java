package top.karlo.test;

import top.karlo.tree.BST;

import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/12/8 22:00
 * @since 1.0.0
 */

public class MainTest {
    public static void main(String[] args) {
//        Array<Integer> array = new Array<>();
//        for (int i = 0; i < 25; i++) {
//            array.addFirst(i);
//            System.out.println(array.toString());
//        }
//        for (int i = 0; i < 20; i++) {
//            array.removeFirstEle();
//            System.out.println(array.toString());
//        }

//        ArrayQueue<Integer> queue = new ArrayQueue<>();
//        for (int i = 0; i < 25; i++) {
//            queue.enqueue(i);
//            System.out.println(queue.toString());
//        }
//        for (int i = 0; i < 20; i++) {
//            queue.dequeue();
//            System.out.println(queue.toString());
//        }

//        LoopQueue<Integer> queue1 = new LoopQueue<>();
//        for (int i = 0; i < 40; i++) {
//            if(i%3==2){
//                queue1.dequeue();
//                System.out.println(queue1.toString());
//            }else{
//                queue1.enqueue(i);
//                System.out.println(queue1.toString());
//            }
//        }


        BST<Integer> bst = new BST<>();
        List<Integer> list = new ArrayList<>();
        list.add(15);
        list.add(7);
        list.add(6);
        list.add(3);
        list.add(13);
        list.add(25);
        list.add(22);
        // 15,7,6,3,13,25,22
        /**
         *            15
         *          /    \
         *         7     25
         *        / \    /
         *       6  13  22
         *      /
         *     3
         */


        for (int i = 0; i < list.size(); i++) {
            bst.add(list.get(i));
        }
        bst.levelOrder(bst.root);

    }
}
