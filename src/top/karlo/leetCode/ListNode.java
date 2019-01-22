package top.karlo.leetCode;

/**
 * 功能描述：
 *
 * @author Karlo
 * @date 12/18/2018 15:33
 */
public class ListNode<E> {
    E val;
    ListNode next;
    ListNode(E x){
        val = x;
    }

    public ListNode(E[] arr){
        if(arr == null|| arr.length == 0){
            throw new IllegalArgumentException("arr is empty!");
        }
        this.val = arr[0];
        ListNode<E> cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }


    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("head ");
        ListNode<E> cur = this;
        while(cur != null){
            res.append(cur.val+"->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

    private ListNode<E> removeEle(ListNode<E> head, E val){
        if(head == null){
            return null;
        }
        head.next = removeEle(head.next,val);
        return val.equals(head.val) ? head.next : head;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{1,2,3,6,4,5,6};
        ListNode<Integer> listNode = new ListNode<>(arr);
        System.out.println(listNode);
        ListNode<Integer> integerListNode = listNode.removeEle(listNode, 6);
        System.out.println(integerListNode);
    }

}




