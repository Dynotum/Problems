import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

public class Main {
    public static void main(String[] args) {
/*        int toMove = 2;
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

        System.out.println("Result = " + caesarCypherEncryptor("keeppracticing", 54));
        System.out.println(isPalindrome("a"));
        System.out.println(getNthFib(4));*/

        final List<String> versions = new ArrayList<>();
        versions.add("2.3.1");
        versions.add("12.3.1");
        versions.add(".3.1");
        versions.add("22.3.1");
        versions.add("00.0.1");
        versions.add("12.3.1");

        for (String version : versions) {
            validVersion(version);
        }

        smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});

    }


    public static void validVersion(String version) {
        // 18.0.0
        final Pattern pattern = Pattern.compile("(\\d{2}).(\\d).(\\d)");
        final Matcher matcher = pattern.matcher(version);

        System.out.println(version + " -> " + matcher.matches());
    }

    public static int getNthFib(int n) {
        int a = 0;
        int b = 1;
        int counter = 3;

        if (n == 1)
            return a;
        if (n == 2)
            return b;

        while (counter <= n) {

            int nextNum = a + b;
            a = b;
            b = nextNum;
            counter++;
        }

        return b;
    }

    public static String caesarCypherEncryptor(String str, int key) {
        StringBuilder sb = new StringBuilder();
        int newK = key % 26;
        for (char ichar : str.toCharArray()) {
            int newN = ichar + newK;
            // System.out.println(newN);
            // System.out.println(newK + "\n");
            ichar = (char) (newN > 'z' ? 96 + (newN % 122) : newN);
            sb.append(ichar);
        }
        return sb.toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(new StringBuilder(string).reverse().toString());
    }

    public static boolean isPalindrome2(String str) {
        int L = 0, R = str.length() - 1;
        while (L <= R) {
            if (str.charAt(L) != str.charAt(R)) {
                return false;
            }
            L++;
            R--;
        }

        return true;
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

    public static void longestPeak(int[] input) {
        // find all peaks
        // then count its adjacents
        // dont cry :)
        // you can do it :')
    }

    /**
     * Not working propertly :(
     *
     * @param queries
     * @return
     */
    public int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int totalWT = 0;
        for (int i = 0; i < queries.length; i++) {
            int duration = queries[i];
            int queriesLeft = queries.length - (i + 1);
            totalWT += duration * queriesLeft;
        }
        return totalWT;
    }

    // Smallest Difference AlgoExpert

    /**
     * O(nlog(n) + m(mlog(m)) time | O(1) space
     */
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int index1 = 0, index2 = 0;
        int closeZero = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (index1 < arrayOne.length && index2 < arrayTwo.length) {
            int compa = Math.abs(arrayOne[index1] + (arrayTwo[index2] * -1));

            if (compa < closeZero) {
                closeZero = compa;
                result[0] = arrayOne[index1];
                result[1] = arrayTwo[index2];
            }

            if (arrayOne[index1] < arrayTwo[index2]) {
                index1++;
            } else if (arrayOne[index1] > arrayTwo[index2]) {
                index2++;
            } else {
                return new int[]{arrayOne[index1], arrayTwo[index2]};
            }
        }

        return result;
    }

    public static boolean isMonotonic(int[] array) {
        if (array == null || array.length == 0) {
            return true;
        }

        boolean upwards = true;
        boolean downwards = true;
        int i = 0, j = 1;
        while (i < array.length && j < array.length) {
            if (array[i] > array[j]) {
                downwards = false;
            }
            if (array[i] < array[j]) {
                upwards = false;
            }
            i++;
            j++;
        }

        return upwards || downwards;
    }

}

