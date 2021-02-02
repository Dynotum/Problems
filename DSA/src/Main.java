import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.StrictMath.abs;
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

//        final List<String> versions = new ArrayList<>();
//        versions.add("2.3.1");
//        versions.add("12.3.1");
//        versions.add(".3.1");
//        versions.add("22.3.1");
//        versions.add("00.0.1");
//        versions.add("12.3.1");
//
//        for (String version : versions) {
//            validVersion(version);
//        }
//
//        smallestDifference(new int[]{-1, 5, 10, 20, 28, 3}, new int[]{26, 134, 135, 15, 17});
        final String A = "apple";
        final String B = "pear";
        lettersToAnagram(A, B);

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

    public static int longestPeak(int[] input) {
        // find all peaks
        // then count its adjacents
        // dont cry :)
        // you can do it :')
        return 0;
    }


    public static int longestPrefix(int x, int y, int[] input) {
        int counter = -1, xFound = 0, yFound = 0;

        for (int i = 0; i < input.length; i++) {
            if (x == input[i]) {
                xFound++;
            }
            if (y == input[i]) { // x and y can be equals!!
                yFound++;
            }

            if (xFound == yFound) {
                if (counter < i) {
                    counter = i;
                }
            }
        }
        return counter == 0 ? counter++ : counter;
    }

    public static int binaryToZero(String binary) {
        int decNumber = getDecimal(binary);
        int moves = 0;
        while (decNumber > 0) {
            if (decNumber % 2 == 0) {
                moves++;
                decNumber /= 2;
            }
            if (decNumber % 2 != 0) {
                moves++;
                decNumber--;
            }
        }
        return moves;
    }

    public static int getDecimal(String binary) {
        final String revBinary = new StringBuilder(binary).reverse().toString();

        int decNumber = 0, binNumber = 0;
        for (int i = 0; i < revBinary.length(); i++) {
            if (i == 0) {
                binNumber = 1;
            } else {
                binNumber *= 2;
            }

            if (revBinary.charAt(i) == '1') {
                decNumber += binNumber;
            }
        }
        return decNumber;
    }

    public static int binaryToZeroBestSolution(String s) {
        final int firstOneAt = s.indexOf("1");
        return firstOneAt == -1 ? 0
                : s.replace("0", "").length() + s.length() - firstOneAt - 1;
    }

    public static int lettersToAnagram(String A, String B) {

        if (A.equals(B)) {
            return 0;
        }

        char[] a = A.toCharArray(), b = B.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        StringBuilder result = new StringBuilder();
        int minLetters = 0;
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            if (i == a.length -1) {
                j++;
                continue;
            }

            if (a[i] < b[j]) {
                result.append(a[i]);


                i++;
            } else if (a[i] > b[j]) {
                result.append(b[j]);
                minLetters++;
                j++;
            } else {
                result.append(a[i]);
                i++;
                j++;
            }
        }
        System.out.println(result);
        System.out.println(minLetters);
        return minLetters;
    }

    // Counts the no of manipulations required
    static int countManipulations(String s1, String s2)
    {
        int count = 0;

        // store the count of character
        int char_count[] = new int[26];

        // iterate though the first String and update
        // count
        for (int i = 0; i < s1.length(); i++) {
            char_count[s1.charAt(i) - 'a']++;
        }

        // iterate through the second string
        // update char_count.
        // if character is not found in char_count
        // then increase count
        for (int i = 0; i < s2.length(); i++)
        {
            char_count[s2.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; ++i)
        {
            if(char_count[i] != 0)
            {
                count+=abs(char_count[i]);
            }
        }

        return count;
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

    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    public static int productSum(List<Object> array, int nivel) {
        int sumUp = 0;
        for (Object o : array) {
            if (o instanceof ArrayList) {
                ArrayList<Object> newArray = (ArrayList<Object>) o;
                sumUp += productSum(newArray, nivel + 1);
            } else {
                sumUp+= (int)o;
            }
        }

        return sumUp * nivel;
    }
}

