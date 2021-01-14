import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int toMove = 2;
        final List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);

        final List<Integer> resultList = moveElementToEndSolution1(list, toMove);
        System.out.println("moveElementToEndSolution1 :");
        System.out.println(resultList);
        final List<Integer> resultList2 = moveElementToEndSolution2(list, toMove);
        System.out.println("moveElementToEndSolution2 :");
        System.out.println(resultList2);

    }

    public static List<Integer> moveElementToEndSolution1(List<Integer> array, int toMove) {
        Collections.sort(array);

        int fElem = array.indexOf(toMove), lElem = array.lastIndexOf(toMove);

        if (fElem == -1) return array;

        final List<Integer> tmpList = new ArrayList<>();
        final int len = lElem - fElem + 1;

        for (int i = 0; i < len; i++) {
            tmpList.add(toMove);
        }

        array.removeAll(tmpList);
        array.addAll(tmpList);

        return array;
    }

    public static List<Integer> moveElementToEndSolution2(List<Integer> array, int toMove) {
        int i = 0, j = array.size() - 1;

        while (i < j) {
            while (i < j && array.get(j) == toMove) j--;
            if (array.get(i) == toMove) swap(i, j, array);
            i++;
        }

        return array;
    }

    private static void swap(int i, int j, List<Integer> array) {
        int tmp = array.get(j);
        array.set(j, array.get(i));
        array.set(i, tmp);
    }
}