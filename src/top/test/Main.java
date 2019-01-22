package top.test;

import top.karlo.linkedlist.LinkedList;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 12/11/2018 16:01
 */
public class Main {
    public static void main(String[] args) {
//        Date date = new Date();
//        long l = System.currentTimeMillis();
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        Date date = new Date();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
            System.out.println(list.toString());
        }
        for (int i = 10; i > 0; i--) {
            list.remove(i);
            System.out.println(list.toString());

        }

//        System.out.println(date.compareTo(new Timestamp(l)));

    }
}
