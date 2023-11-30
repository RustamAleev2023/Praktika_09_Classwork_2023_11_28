import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        task2();
//        task3();
//        task4();
//        task5();
//        task6();
//        task7();
//        task8();
//        task9();
        task10();
    }

    //Task2
    public static void task2() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        System.out.println("Введите слово для поиска");
        String searchWord = scanner.next();
        String[] words = string.split("\\W+");
        int count = 0;

        for (int i = 0; i < words.length; i++) {
//            System.out.println(words[i]);
            if (words[i].equalsIgnoreCase(searchWord)) {
                count++;
            }
        }
        System.out.println(count);
    }

    //Task3
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        System.out.println("Введите искомое слово");
        String searchWord = scanner.next();
        System.out.println("Введите слово для замены");
        String replaceWord = scanner.next();
        String[] words = string.split("\\W+");

        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(searchWord)) {
                words[i] = replaceWord;
            }
        }

        for (int i = 0; i < words.length; i++) {
            System.out.print(words[i] + " ");
        }
    }

    //Task4
    public static void task4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку");
        String string = scanner.nextLine();
        String[] words = string.split(" ");

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            stringBuilder.append(words[i]);
        }
        String source = stringBuilder.toString();
        String revers = stringBuilder.reverse().toString();

        if (revers.equalsIgnoreCase(source)) {
            System.out.println("Введенная строка является палиндромом");
        } else {
            System.out.println("Введенная строка не является палиндромом");
        }
    }

    //Task5
    public static void task5() {
        String text = "в одномерном массиве1, заполненном случайными\n" +
                "числами, определить минимальный и максимальный\n" +
                "элементы, посчитать количество отрицательных элемен-\n" +
                "тов, посчитать колич3ество положите5льных элементов,\n" +
                "посчитать количество нулей. результаты вывести на\n" +
                "экран.";
        char[] chars = new char[text.length()];
        for (int i = 0; i < chars.length; i++) {
            chars[i] = text.charAt(i);
        }
        //каждое предложение начинается с загланой буквы
        chars[0] = Character.toUpperCase(chars[0]);
        for (int i = 1; i < chars.length - 2; i++) {
            if (chars[i] == '.' && chars[i + 1] == ' ') {
                chars[i + 2] = Character.toUpperCase(chars[i + 2]);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]);
        }
        System.out.println();
        //посчитать сколько цифр встречается в тексте
        int digitCounter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                digitCounter++;
            }
        }
        System.out.println("В тексте встречается " + digitCounter + " цифр");

        //посчитать кол-во знаков препинания
        int punctuationCount = 0;
        String regex = "[.,?!;:]";
        String[] words = text.split(regex);
        punctuationCount = words.length - 1;
        System.out.println("В тексте " + punctuationCount + " знаков препинания.");

        //каждое кол-во предложений
        int sentenceCount = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                sentenceCount++;
            }
        }
        System.out.println("В тексте " + sentenceCount + " предложений");
    }

    //Task6
    public static void task6() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Введите элемент массива");
            numbers[i] = scanner.nextInt();
            sum += numbers[i];
        }
        System.out.println("Сумма элементов массива = " + sum);
        System.out.println("Среднеарифметическое = " + sum / numbers.length);
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }

    //Task7
    public static void task7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите длину массива");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Введите элемент массива");
            numbers[i] = scanner.nextInt();
        }
        System.out.println("Введите число для поиска");
        int searchNumber = scanner.nextInt();
        int count = 0;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == searchNumber) {
                count++;
            }
        }
        System.out.println("Число " + searchNumber + " встречается " + count + " раз");
    }

    //Task8
    public static void task8() {
//        int[] numbers = {1,2,3,4,-1,-2,0,1,0,100};

        Random random = new Random();
        int size = random.nextInt(100);
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt();
        }
        //MIN
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
        }
        System.out.println("MIN = " + min);

        //MAX
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        System.out.println("MAX = " + max);

        //Positive, negative, zero
        int positive = 0;
        int negative = 0;
        int zero = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                negative++;
            }
            if (numbers[i] > 0) {
                positive++;
            }
            if (numbers[i] == 0) {
                zero++;
            }
        }
        System.out.println("Positive: " + positive);
        System.out.println("Negative: " + negative);
        System.out.println("Zero: " + zero);
    }

    //Task9
    public static void task9() {
//                int[] numbers = {-1,2,3,4,-1,-2,0,1,0,-100};

        Random random = new Random();
        int size = 20;
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-1000, 1000);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        int sumNegative = 0;
        int sumOddNum = 0;
        int sumEvenNum = 0;
        int multiply = 1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < 0) {
                sumNegative += numbers[i];
            }
            if (numbers[i] % 2 == 0) {
                sumEvenNum += numbers[i];
            } else {
                sumOddNum += numbers[i];
            }
            if (i % 3 == 0) {
                multiply *= numbers[i];
            }
        }
        System.out.println("Sum negative = " + sumNegative);
        System.out.println("Sum odd = " + sumOddNum);
        System.out.println("Sum even = " + sumEvenNum);
        System.out.println("Произведение элементов с индексами кратными 3 = " + multiply);

        //Произведение элементов между минимальным и максимальным элементом

        int minMaxMultiply = 1;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
        }
        for (int i = minIndex + 1; i < maxIndex; i++) {
            minMaxMultiply *= numbers[i];
        }
        System.out.println("Произведение элементов между минимальным и максимальным элементом = " + minMaxMultiply);

        //Сумму элементов, находящихся между первым и последним положительными элементами
        int sum = 0;
        int startIndex = 0;
        int endIndex = numbers.length - 1;

        boolean isFirstStartIndex = false;
        boolean isFirstEndIndex = false;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > 0 && !isFirstStartIndex) {
                startIndex = i;
                isFirstStartIndex = true;
            }
            if(numbers[numbers.length - 1 - i] > 0 && !isFirstEndIndex){
                endIndex = numbers.length - 1 - i;
                isFirstEndIndex = true;
            }
        }

        System.out.println("Start index = " + startIndex);
        System.out.println("End index = " + endIndex);

        for (int i = startIndex; i <= endIndex; i++) {
            sum += numbers[i];
        }

        System.out.println("Сумма элементов, находящихся между первым и последним положительными элементами = " + sum);
    }

    //Task10
    public static void task10(){
        Random random = new Random();
        int size = 20;
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-1000, 1000);
            System.out.print(numbers[i] + " ");
        }
        System.out.println();


    }
}
