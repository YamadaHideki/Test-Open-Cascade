import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long arraySize = 0;

        while (true) {
            System.out.println("Введите размер массива");
            try {
                arraySize = Long.parseLong(scanner.nextLine());
                if (arraySize < 10) {
                    System.out.println("Вы ввели цифру меньше 10");
                } else {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Ошибка, нужно ввести целое число не меньше 10");
            }
        }

        MyArray myArray = new MyArray(arraySize);
        myArray.deleteRandomElement();
        myArray.shuffle();

        System.out.println(myArray);
        System.out.println("XOR search: " + myArray.searchMissingNumberXor());
        System.out.println("Base search: " + myArray.searchMissingNumberBase());
    }
}
