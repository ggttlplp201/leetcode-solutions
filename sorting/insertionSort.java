package leetcode.sorting;

import java.util.LinkedList;

public class insertionSort {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(3);
        System.out.println(insertionSortList(list));
    }

    public static LinkedList<Integer> insertionSortList(LinkedList<Integer> head) {
        int n = head.size();
        for (int i = 1; i < n; ++i) {
            int key = head.get(i);
            int j = i - 1;
            while (j >= 0 && head.get(j) > key) {
                head.set(j + 1, head.get(j));
                j = j - 1;
            }
            head.set(j + 1, key);
        }
        return head;
    }
}
