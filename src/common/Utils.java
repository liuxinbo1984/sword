package common;

import java.util.List;

public class Utils {
    public static void printArr(int[] bits) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < bits.length; i++) {
            sb.append(bits[i]);
            if (i < bits.length - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static <T> void printList(List<List<T>> list) {
        for(List<T> t : list){
            printSingleList(t);
        }
    }

    public static <T> void printSingleList(List<T> list) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            int size = list.size();
            for (int i=0;i<size;i++){
                sb.append(list.get(i));
                if (i < size - 1) {
                    sb.append(",");
                }
            }
            sb.append("]");
            System.out.println(sb.toString());
    }
}
