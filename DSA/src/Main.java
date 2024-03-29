import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.StrictMath.PI;
import static java.lang.StrictMath.abs;
import static org.junit.Assert.assertTrue;
// module _n{
//    requires m$;
//    exports p;
// }
// module m${
//    requires _n;
//    exports o;
// }
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
    //        final String A = "apple";
    //        final String B = "pear";
    //        lettersToAnagram(A, B);

    //        System.out.println(solution(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2}));
    //        System.out.println(solution(new int[]{2, 1}, new int[]{3, 3}));
    //
    //        bubbleSort(new int[]{8, 5, 2, 9, 5, 6, 3});
    //        NOFibonacci();
    //        translator();

    //        IDragon dragon = (name) -> "Hello " + name;
    //        System.out.println(dragon.sayHelloWord());
    //        System.out.println(dragon.sayHello("Dragon!"));
    //
    //        Hilo hilo = new Hilo();
    //        IDragon dragon1 = hilo::hiloWord;
    //
    //        Predicate<String> stringPredicate = a -> a.startsWith("H");
    //        System.out.println(stringPredicate.test(dragon1.sayHello("Dyno")));
    //        System.out.println(stringPredicate.test(dragon1.sayHelloWord()));
    //
    //        System.out.println(dragon1.sayHello("Dyno"));
    //        System.out.println(dragon1.sayHelloWord());
    //
    //        int[] A = new int[]{1, 7, 9};
    //        int[] B = new int[]{2, 4, 8, 0, 0, 0};
    //
    //        B = mergeTwoSortedArrays(A, B);
    //
    //        Arrays.stream(B).forEach(System.out::println);
    //        System.out.println(sumUp(new Scanner(System.in).nextLong()));
    //        getPercent();

    //        System.out.println(firstNotRepeatingCharacter("abacabad"));

    //        System.out.println(sumOdd(5));

    //        interval(new int[][]{{1, 5}, {3, 9}, {4, 8}, {10, 13}}, 4);
    //                [1, 5],
    //    [3, 9],
    //    [4, 8],
    //    [10, 13]
    // ]});
    //    addOne(new int[] {1, 2, 3});
    //    System.out.println();
    //    addOne(new int[] {1, 2, 9});
    //    System.out.println();
    //    addOne(new int[] {1, 9, 9});
    //    System.out.println();
    //    addOne(new int[] {9, 9, 9});
    System.out.println(memesoft1());
  }

  public static int[] addOne(int[] digits) {
    // 9,9,9
    // 1,0,0,0

    // 1,2,9,9
    // 1,3,0,0

    boolean carry = false;
    for (int i = digits.length - 1; i >= 0; i--) {

      if (digits[i] == 9) {
        digits[i] = 0;
        carry = true;
        continue;
      }

      if (carry) {
        digits[i] = digits[i] + 1;
        carry = false;
      } else if (i == digits.length - 1) {
        digits[i] = digits[i] + 1;
      }
    }
    if (carry) {
      int[] newArray = new int[digits.length + 1];
      newArray[0] = 1;

      System.arraycopy(digits, 0, newArray, 1, digits.length);
      Arrays.stream(newArray).forEach(System.out::print);
      return newArray;
    }

    Arrays.stream(digits).forEach(System.out::print);

    return digits;
  }

  public int solve(int[] nums) {
    Arrays.sort(nums);

    int largestGap = 0;
    for (int i = 0; i < nums.length - 1; i++) {
      int sum = Math.abs(nums[i] - nums[i + 1]);
      largestGap = sum > largestGap ? sum : largestGap;
    }
    return largestGap;
  }

  public static int sumOdd(int n) {
    int sum = 0;
    int number = 1;
    while (n < 0) {
      if (number % 2 != 0) {
        System.out.println(number);
        sum += number;
        n--;
      }

      number++;
    }

    return sum;
  }

  public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {

    StringBuilder w1 = new StringBuilder();
    StringBuilder w2 = new StringBuilder();

    for (String str : word1) {
      w1.append(str);
    }
    for (String str : word2) {
      w2.append(str);
    }

    return w1.toString().equals(w2.toString());
  }

  public static String tournamentWinner(
      ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

    final Map<String, Integer> hash = new HashMap<>();

    String currentWinner = "";
    int aux = 0;
    for (int i = 0; i < results.size(); i++) {
      final List<String> list = competitions.get(i);
      final String comp1 = list.get(0);
      final String comp2 = list.get(1);
      final String winner = results.get(i) == 1 ? comp1 : comp2;
      final String loser = results.get(i) == 0 ? comp2 : comp1;

      if (hash.containsKey(winner)) {
        hash.put(winner, hash.get(winner) + 3);
      } else {
        hash.put(winner, 3);
      }

      if (!hash.containsKey(loser)) {
        hash.put(loser, 0);
      }

      if (hash.get(winner) > aux) {
        aux = hash.get(winner);
        currentWinner = winner;
      }
    }

    return currentWinner;
  }

  /*
   *
   *  Given an array A of N integers, returns the smallest positive integer (greater than 0) that
   *  does not occur in A
   *
   *  For example, given A = [1,3,6,4,1,2], the function should return 5
   *  A = [1,2,3], the function should return 4
   *  A = [-1,-3], the function should return 1
   *
   * N = [1...100,000]
   * element of array - range [-1M...1M]
   * */
  public static int memesoft1(/*int[] A*/ ) {
    //            final int[] A = {1, 3, 6, 4, 1, 2};
    //        final int[] A = {-1, -3};
    //        final int[] A = {1,2,3};
    //    final int[] A = {1, 2, 3};
    //    final int[] A = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 99};
//        final int[] A = {2, 3, 7, 6, 8, -1, -10, 15};
//        final int[] A = { 2, 3, -7, 6, 8, 1, -10, 15 };
    final int[] A = {1, 1, 0, -1, -2};

    // sort array
    Arrays.sort(A); // 1,1,2,3,4,6
    // 1 1 2 3 4 6

    int p1, p2;
    for (int i = 0; i < A.length - 1; i++) {

      p1 = A[i];
      if (p1 <= 0) continue;

      p2 = A[i + 1];

      if (p1 == p2) {
      } else if (p1 + 1 == p2 && A.length == i + 2) {
        return p2 + 1;
      } else if (p1 + 1 == p2) {
      } else {
        return p1 + 1;
      }
    }

    return 1;
  }

  public static int thirdMax(int[] nums) {
    LinkedHashSet<Integer> set = new LinkedHashSet<>();

    for (int elem : nums) {
      set.add(elem);
    }

    Object[] array = set.toArray();
    return (int) array[array.length - 1];
  }

  public static boolean buddyStrings(String a, String b) {

    /*
    [ a a a b c a]
    [ a a a c b a]
    */

    if (a.length() != b.length()) {
      return false;
    }

    if (a.equals(b)) {
      // this piece of code was copied by the solution
      int[] count = new int[26];
      for (int i = 0; i < a.length(); ++i) count[a.charAt(i) - 'a']++;

      for (int c : count) if (c > 1) return true;
      return false;
      // this piece of code was copied by the solution
    }

    List<Integer> list = new LinkedList<>();

    for (int i = 0; i < a.length(); i++) {

      if (a.charAt(i) != b.charAt(i)) {
        list.add(i);
      }

      if (list.size() > 2) {
        return false;
      }
    }

    if (list.size() != 2) {
      return false;
    }

    char aux = a.charAt(list.get(0));
    char aux2 = a.charAt(list.get(1));

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < a.length(); i++) {
      if (i == list.get(0)) {
        sb.append(aux2);
      } else if (i == list.get(1)) {
        sb.append(aux);
      } else {
        sb.append(a.charAt(i));
      }
    }
    //    a b c d e f g h i j k l m n o p q r s t u v w x y z
    return sb.toString().equals(b);
  }

  public static char firstNotRepeatingCharacter(String s) {
    int[] counter = new int[26];

    for (char c : s.toCharArray()) {
      System.out.println(c - 'a');
      counter[c - 'a']++;
    }

    for (char c : s.toCharArray()) {
      if (counter[c - 'a'] == 1) return c;
    }

    return '_';
  }
  /*
   * Set collection can be worth it
   */

  public static int firstDuplicate(int[] array) {

    for (int i = 0; i < array.length; i++) {
      if (array[Math.abs(array[i]) - 1] < 0) {
        return Math.abs(array[i]);
      } else {
        array[Math.abs(array[i]) - 1] = -array[Math.abs(array[i]) - 1];
      }
    }
    return -1;
  }

  public static int[] mergeTwoSortedArrays(int[] A, int[] B) {

    int aLen = A.length - 1;
    int bLen = B.length / 2 - 1;
    int index = B.length - 1;

    while (index >= 0) {
      if (aLen < 0) {
        B[index] = B[bLen--];
      } else if (bLen < 0) {
        B[index] = A[aLen--];
      } else {
        if (B[bLen] > A[aLen]) {
          B[index] = B[bLen--];
        } else {
          B[index] = A[aLen--];
        }
      }
      index--;
    }

    return B;
  }

  private static int sumUp(long n) {
    return sumUp(n, 0);
  }

  private static int sumUp(long n, int residuo) {
    if (n == 0) {
      return residuo;
    }

    return sumUp(n / 10, (int) (n % 10 + residuo));
  }

  public static void getPercent() {
    final List<String> list = Arrays.asList("#4421574144#");
    final String[] str = list.get(0).split("#");
    System.out.println(str[1]);
  }

  public static void translator() {
    final Scanner sc = new Scanner(System.in);
    final int noTranslator = sc.nextInt();
    final int noTranslate = sc.nextInt();
    final Map<Integer, Integer> hash = new HashMap<>();

    for (int i = 0; i < noTranslator; i++) {
      hash.put(sc.nextInt(), sc.nextInt());
    }

    for (int i = 0; i < noTranslate; i++) {
      int keyToTranslate = sc.nextInt();
      System.out.println(hash.containsKey(keyToTranslate) ? hash.get(keyToTranslate) : "C?");
    }
  }

  public static void fraccionMix() {
    final Scanner scanner = new Scanner(System.in);
    final int n = scanner.nextInt();
    final int m = scanner.nextInt();

    if (n % m == 0) {
      System.out.println(n / m);
      return;
    }

    final StringBuilder sb = new StringBuilder();
    sb.append(n / m).append(" ").append(n % m).append("/").append(m);
    System.out.println(sb.toString());
  }

  public static void NOFibonacci() {
    final int n = new Scanner(System.in).nextInt();
    if (n == 1 || n == 0) {
      return;
    }

    int prevPrev, prev = 1, next = 1;
    boolean[] fibo = new boolean[n + 1];

    for (int i = 2; i < fibo.length; i++) {
      prevPrev = prev + next;
      next = prev;
      prev = prevPrev;

      if (prevPrev > n) {
        fibo[n] = true;

      } else {
        fibo[prevPrev] = true;
      }
    }

    for (int i = 2; i < fibo.length; i++) {
      if (!fibo[i]) {
        System.out.print(i + " ");
      }
    }
  }

  // omegaUp

  public static void triples() {
    final Scanner sc = new Scanner(System.in);

    int n = sc.nextInt();
    int counter = 0;

    final List<Integer> indexFound = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int element = sc.nextInt();
      if (element % 3 == 0) {
        counter++;
        indexFound.add(i + 1);
      }
    }
    if (indexFound.size() != 0) {
      System.out.println(counter);
      indexFound.forEach(i -> System.out.print(i + " "));
    } else {
      System.out.println("No hay triples.");
    }
  }

  public static int[] bubbleSort(int[] array) {
    boolean isSorted = false;

    while (!isSorted) {
      isSorted = true;
      for (int i = 0; i < array.length; i++) {
        if (array[i] > array[i + 1]) {
          int temp = array[i + 1];
          array[i + 1] = array[i];
          array[i] = temp;
          isSorted = false;
        }
      }
    }
    return array;
  }

  public static int solution(int[] A, int[] B) {
    int n = A.length;
    int m = B.length;
    ;
    Arrays.sort(A);
    Arrays.sort(B);
    int i = 0;
    for (int k = 0; k < n; k++) {
      if (i < m - 1 && B[i] < A[k]) i += 1;
      if (A[k] == B[i]) return A[k];
    }
    return -1;
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

    if (n == 1) return a;
    if (n == 2) return b;

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

  public static int interval(int[][] intervals, int point) {
    int counter = 0;
    for (int i = 0; i < intervals.length; i++) {
      for (int j = 0; j < intervals[i].length - 1; j++) {
        int a = intervals[i][j];
        int b = intervals[i][++j];
        if (point >= a && point <= b) {
          counter++;
        }
      }
    }
    return counter;
  }

  public static int numIdenticalPairs(int[] nums) {

    Map<Integer, Integer> map = new HashMap<>();

    for (int elem : nums) {

      if (map.containsKey(elem)) {
        map.put(elem, map.get(elem) + 1);
      } else {
        map.getOrDefault(elem, 1);
      }

      int total = 0;
      for (int value : map.values()) {
        if (value > 1) {
          total += value;
        }
      }
      return (total * (total - 1)) / 2;
    }

    return 0;
  }

  public static int wealth(int[][] accounts) {

    int richest = -1;
    for (int[] a : accounts) {
      int total = 0;
      for (int i = 0; i < a.length; i++) {
        total += a[i];
      }
      richest = Math.max(richest, total);
    }
    return richest;
  }

  public boolean isPalindrome3(String s) {

    for (int i = 0, j = s.length() - 1; i < s.length() - 1; i++, j--) {
      if (i == j) {
        return true;
      }
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
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

  /*
      public static int getDecimal(String binary) {
  //        final String revBinary = new StringBuilder(binary).reverse().toString();

          int decNumber = 1, binNumber = 1;
          for (int i = binary.length() -1; i >= 0; --i) {
              if (i == 0) {
                  binNumber = 1;
              } else {
                  binNumber *= 2;
              }

              if (binary.charAt(i) == '1') {
                  decNumber += binNumber;
              }
          }
          System.out.println(decNumber);
          return decNumber;
      }
  */

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

  public static int[][] rotateImage(int[][] a) {

    int n = a.length;

    for (int layer = 0; layer < n / 2; layer++) {
      int first = layer;
      int last = n - 1 - layer;

      for (int i = first; i < last; i++) {
        int offset = i - first;
        int top = a[first][i];

        // left -> top
        a[first][i] = a[last - offset][first];
        // bottom -> left
        a[last - offset][first] = a[last][last - offset];
        // rigth -> bottom
        a[last][last - offset] = a[i][last];
        // top -> rigth
        a[i][last] = top;
      }
    }
    return a;
  }

  public static int binaryToZeroBestSolution(String s) {
    final int firstOneAt = s.indexOf("1");
    return firstOneAt == -1 ? 0 : s.replace("0", "").length() + s.length() - firstOneAt - 1;
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
      if (i == a.length - 1) {
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

  // Asked coding assessment :(
  // Counts the no of manipulations required
  static int countManipulations(String s1, String s2) {
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
    for (int i = 0; i < s2.length(); i++) {
      char_count[s2.charAt(i) - 'a']--;
    }

    for (int i = 0; i < 26; ++i) {
      if (char_count[i] != 0) {
        count += abs(char_count[i]);
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

  /** O(nlog(n) + m(mlog(m)) time | O(1) space */
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
        return new int[] {arrayOne[index1], arrayTwo[index2]};
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
        sumUp += (int) o;
      }
    }

    return sumUp * nivel;
  }

  public static int findClosestValueInBst(BST tree, int target) {
    return findClosestValueInBst(tree, target, tree.value);
  }

  public static int findClosestValueInBst(BST tree, int target, int closestValue) {
    // 10 - 12 = 2
    if (Math.abs(target - closestValue) > Math.abs(target - tree.value)) {
      closestValue = tree.value;
    }
    // 10				12
    if (tree.value < target && tree.right != null) {
      return findClosestValueInBst(tree.right, target, closestValue);
      // 15 > 12
    } else if (tree.value > target && tree.left != null) {
      return findClosestValueInBst(tree.left, target, closestValue);
    } else {
      return closestValue;
    }
  }

  static class BST {
    public int value;
    public BST left;

    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }

  public static int solution(String A, String B) {

    char[] a = A.toCharArray(), b = B.toCharArray();
    int result = 0;
    // sorting arrays
    Arrays.sort(a);
    Arrays.sort(b);

    List<Character> list = new ArrayList<>();

    // Gets ASCII of a and z (lowercase)
    int asciiA = (int) 'a'; // 97
    int asciiZ = Integer.valueOf('z'); // 122
    int alphabet = asciiZ - asciiA;
    int charArray[] = new int[alphabet];

    // Adds index and the current ascii value - ascci of a
    for (int i = 0; i < a.length; i++) {
      list.add(i, (char) (a[i] - asciiA));
    }

    for (int i = 0; i < list.size(); i++) {
      char value = list.get(i);
      if (value != 0) {
        int valueAbs = Math.abs(value);
        result = result + valueAbs;
      }
    }
    System.out.println(result);
    return result;
  }
}
