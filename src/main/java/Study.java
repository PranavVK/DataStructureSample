import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.SimpleFormatter;
import java.util.Map.Entry;

public class Study {

    public static void main(String[] args) {
        Study study = new Study();
//        String str = "abcdefg";
//        System.out.println("String: " + str);
//        System.out.println("Reversed String: " + study.reverseString(str));

//        study.numberSwapWithoutThirdVariable(10, 20);

//        System.out.println(study.fibonacci(5));
//        study.printFibonacciSeries(5);

//        System.out.println(study.isPalindrome("malayualam"));
//        System.out.println(study.removeStartingWhiteSpaces(" dadad  dddd d "));

//        System.out.println(study.reverseLinkedList());

//        study.printPyramidPattern(9);

//        Integer[] a1 = {1, 2, 8, 5};
//        Integer[] a2 = {1, 2, 1, 1};
//
//        System.out.println(study.isArrayContainSameElements(a1, a2));

//        Integer[] a1 = {3, 0, 1, 1, 2, 2};
////        System.out.println(study.findSecondLargestInArray(a1));
//        System.out.println(study.findSecondHighest1(a1));

//        study.playArrayListSet();

//        String filePath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "test.txt";
//        study.createFileWithContent(filePath, "abcd");
//        boolean result = study.findStringInFile(filePath, "z");
//        System.out.println("String found status: " + result);

//        study.sortHashMapByValue();

//        study.arrayDescendingOrderSort();
//        study.pyramidTest(9);

        study.getUniqueCharacterSubstring("ghghkghmamayykamkammak");
    }

    public String reverseString(String str) {
        StringBuffer a = new StringBuffer(str);
        a.reverse();

        if (str == null) {
            throw new IllegalArgumentException("Invalid input");
        }

        StringBuilder result = new StringBuilder();
        char[] chars = str.toCharArray();

        for (int i = chars.length - 1; i >=0; i--){
            result.append(chars[i]);
        }
        return result.toString();
    }


    public void numberSwapWithoutThirdVariable(int a, int b) {
        System.out.println("Value a=" + a);
        System.out.println("Value b=" + b);
        b =  a + b;
        a = b - a;
        b = b - a;
        System.out.println("After swapping values");
        System.out.println("Value a=" + a);
        System.out.println("Value b=" + b);
    }

    public boolean stringContainVowels(String str){
        return str.toLowerCase().matches(".*[aeiou].*");
    }

    public boolean primeOrNot(int num) {
        if (num == 0 || num == 1) {
            return false;
        }

        if (num == 2) {
            return true;
        }

        for (int i = 2; i < num/2; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return  true;
    }

    public int fibonacci(int num) {
     if (num <= 1)
         return num;

     return fibonacci(num - 1) + fibonacci(num - 2);
    }

    public static void printFibonacciSeries(int count) {
        int a = 0;
        int b = 1;
        int c = 1;
        for (int i = 1; i <= count; i++) {
            System.out.print(a + ", ");
            a = b;
            b = c;
            c = a + b;
        }
    }

    public boolean isPalindrome(String str) {
        if (str.length() <= 1) {
            return false;
        }
        for (int i=0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public String removeWhiteSpaces(String str) {
        StringBuilder out = new StringBuilder();
        char[] chars = str.toCharArray();

        for (char c: chars) {
            if (!Character.isWhitespace(c)) {
                out.append(c);
            }
        }
        return out.toString();
    }

    public String removeStartingWhiteSpaces(String str) {
        return str.strip();
    }

    public LinkedList reverseLinkedList() {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("name1");
        ll.add("name2");
        ll.add("name4");

        LinkedList<String> ll1 = new LinkedList<>();
        ll.descendingIterator().forEachRemaining(ll1::add);
        return ll1;
    }

    public void printPyramidPattern(int rows) {
        for (int i=rows; i>=1; i--) {
            int numberOfWhiteSpaces = (rows - i) * 2;
            printString(" ", numberOfWhiteSpaces);
            printString1(i);
            System.out.println(" ");
        }
    }

    public void printString(String s, int count) {
        for (int i=1; i<=count; i++) {
            System.out.print(s);
        }
    }

    public void printString1(int count) {
        for (int i=1; i<=count; i++) {
            System.out.print(i + " ");
            if (i==count) {
                for (int j=count-1; j>=1; j--) {
                    System.out.print(j + " ");
                }
            }
        }
    }

    public boolean isArrayContainSameElements(Integer[] array1, Integer[] array2) {
        Set<Integer> uniqueElements1 = new HashSet<>(Arrays.asList(array1));
        Set<Integer> uniqueElements2 = new HashSet<>(Arrays.asList(array2));

        if (uniqueElements1.size() != uniqueElements2.size()) {
            return false;
        }

        for (Integer obj: uniqueElements1) {
            if (!uniqueElements2.contains(obj)) return false;
        }
        return true;
    }

    public int findSecondLargestInArray(int[] array) {
        Arrays.sort(array);
        return array[array.length - 2];
    }

    private static int findSecondHighest(int[] array) {
        int highest = 0;
        int secondHighest = 0;

        for (int i : array) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest) {
                secondHighest = i;
            }

        }
        return secondHighest;
    }

    private static int findSecondHighest1(Integer[] array) {
        int highest = 0;
        int secondHighest = 0;

        Set<Integer> uniqueElements = new HashSet<>(Arrays.asList(array));
        uniqueElements.stream().sorted();

        for (int i : uniqueElements) {
            if (i > highest) {
                secondHighest = highest;
                highest = i;
            } else if (i > secondHighest) {
                secondHighest = i;
            }

        }
        return secondHighest;
    }

    public void solve(String count, String numbers, String replaceNum) {
        int t_count = Integer.parseInt(count);
        System.out.println(t_count);

        String[] splitStr = numbers.split("\\s+");
        int[] numbersArray = new int[splitStr.length];
        for (int i = 0; i<splitStr.length; i++) {
            numbersArray[i] = Integer.parseInt(splitStr[i]);
            System.out.println(splitStr[i]);
        }


        int replaceNumber = Integer.parseInt(replaceNum);
        System.out.println(replaceNumber);

        List<Integer> al = new ArrayList<>();

        for (int i = 0; i<numbersArray.length; i++) {
            if (numbersArray[i]== replaceNumber || numbersArray[i] == 1) {
                al.add(0,1);
            } else {
                al.add(numbersArray[i]);
            }
        }

        System.out.println(al);

    }

    public void suffleAnArray(int[] array1){
        Random rand = new Random();

        for (int i=0; i<array1.length; i++) {
            int randomIndex = rand.nextInt(array1.length);
            int temp = array1[randomIndex];
            array1[randomIndex] = array1[i];
            array1[i] = temp;
        }
    }

    public void playArrayListSet() {
        Integer[] arrayOne = {1,2, 3, 5};
        String[] arrayTwo = {"1", "2", "3", "4"};

        Set<String> setOne = new HashSet<>();
        Set<Integer> setTwo = new HashSet<>(Arrays.asList(arrayOne));

        List<Integer> listOne = new ArrayList<>();
        List<Integer> lisTwo = new ArrayList<>();

        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.remove();
        linkedList.remove(0);
        linkedList.remove("3");


        setOne.add("1");
        listOne.add(1);
        setOne.add("2");
        listOne.add(2);

        listOne.add(0, 2);
        setOne.remove("1");
        listOne.remove(1);
        listOne.remove("1");
    }

    public void createFileWithContent(String filePath, String content){
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (FileOutputStream os = new FileOutputStream(file)) {
            os.write(content.getBytes());
            os.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean findStringInFile(String filePath, String str) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                if(scanner.nextLine().contains(str)) {
                    scanner.close();
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void dateFormatting() {
        String datePattern = "DD-MM-YYYY";
        SimpleDateFormat sf = new SimpleDateFormat(datePattern);

        String date = sf.format(new Date());
        System.out.println(date);
    }

    public void mergeList() {
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        List<Integer> list2 = new ArrayList<>();
        list1.add(4);
        list1.add(5);
        list1.add(6);

        list1.addAll(list2);

        List<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);
    }

    public void sortHashMapByValue() {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Pranav", 90);
        scores.put("Mitwa", 89);

        Map<String, Integer> sortedArray = new LinkedHashMap<>();

        Set<Entry<String, Integer>> entrySet = scores.entrySet();

        List<Entry<String, Integer>> entryList = new ArrayList<>(entrySet);

        entryList.sort((x, y) -> x.getValue().compareTo(y.getValue()));
        for(Entry<String, Integer> e : entryList) {
            sortedArray.put(e.getKey(), e.getValue());
        }
        System.out.println(sortedArray);
    }

    public void arrayDescendingOrderSort() {
        Integer[] array = {1, 5, 4, 6};
//        List<Integer> testList = Arrays.asList(array);
//        testList.contains(6);
//        Set<Integer> testSet = new HashSet<>(Arrays.asList(array));
        System.out.println("Before sorting" + Arrays.toString(array));
        Arrays.sort(array, Collections.reverseOrder());
        System.out.println("After descending order sorting" + Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("After Ascending order sorting" + Arrays.toString(array));

    }

    public void pyramidTest(int rows) {
        for (int i = rows; i >= 1; i--) {
            int numberOfWhiteSpaces = (rows - i);

            printPyramidValue(" ", numberOfWhiteSpaces);
            printPyramidValue("* ", i);
            System.out.println("");

        }
    }

    public void printPyramidValue(String str, int count){
        for ( int i = 1; i <= count; i++) {
            System.out.print(str);
        }
    }

    public void testEnums() {
        int choice = 2;

        switch (choice) {
            case 1:
                System.out.println(1);
                break;
            case 2:
                System.out.println(2);
                break;
            default:
                System.out.println(-1);
        }

    }

    public void testExample() {
//        String s1 = "abc";
//        String s2 = s1;
//        System.out.println("s1 == s2 is:" + s1 == s2);

//        String s3 = "JournalDev";
//        int start = 1;
//        char end = 5;
//        System.out.println(start + end);
//        System.out.println(s3.substring(start, end));

//        HashSet shortSet = new HashSet();
//        for (short i = 0; i < 100; i++) {
//            shortSet.add(i);
//            shortSet.remove(i - 1);
//        }
//        System.out.println(shortSet.size());

        String str = null;
        String str1="abc";
        System.out.println(str1.equals("abc") || str.equals(null));
    }

    public void findAllPalindrome(String str) {
        for(int i = 0; i <= str.length(); i++) {
            for (int j = i; j < str.length(); j++) {
                String subString = str.substring(i, j + 1);
                if (isPalindrome(subString)) {
                    System.out.println(subString);
                }
            }
        }
    }

    public void findLargestUniqueSubset(String str) {
        String output = "";
        for(int start = 0; start < str.length(); start++) {
            Set<Character> visited = new HashSet<>();
            int end = start;
            for (; end < str.length(); end++) {
                char currChar = str.charAt(end);
                if (visited.contains(currChar)) {
                    break;
                } else {
                    visited.add(currChar);
                }
            }

            if (output.length() < end - start + 1) {
                output = str.substring(start, end);
            }
        }
        System.out.println(output);
    }

    void getUniqueCharacterSubstring(String input) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        for (int start = 0, end = 0; end < input.length(); end++) {
            char currChar = input.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar)+1, start);
            }
            if (output.length() < end - start + 1) {
                output = input.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        System.out.println(output);
    }


}
