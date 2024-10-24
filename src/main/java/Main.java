import java.util.InputMismatchException;
import java.util.Scanner;

class Calculator {
    String nameItem;
    String nameItems = "";
    float priceItem;
    float priceItems = 0.0F;
    Scanner scanner1 = new Scanner(System.in);
    Scanner scannerItems = new Scanner(System.in);


    void addProducts() {

        System.out.println("Введите название товара");
        nameItem = scanner1.nextLine();

        nameItems += ("\n" + nameItem);
    }

    void calculate() {

        while (true) {
            try {
                System.out.println("Введите цену товара:");
                priceItem = scannerItems.nextFloat();

                if (priceItem <= 0) {
                    System.out.println("Цена должна быть больше 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите цену товара.");
                scannerItems.next();
                continue;
            }

            if (priceItem <= 0) {
                continue;
            }

            break;

        }
        priceItems = (float) (priceItems + priceItem);

    }

    public static String result(int howManyPerson, float sum) {
        String output;
        Float result;
        String ending;
        result = (float) (sum / howManyPerson);

        int numForEnding = (int) (result % 100);
        if (numForEnding > 9 && numForEnding < 20) {
            ending = " рублей";
        } else {
            numForEnding = numForEnding % 10;
            if (numForEnding == 1) {
                ending = " рубль";
            } else if (numForEnding > 1 && numForEnding < 5) {
                ending = " рубля";
            } else {
                ending = " рублей";
            }
        }
        String sumToEachPerson = "На каждого выходит %.2f" + ending;
        return String.format(sumToEachPerson, result);

    }
}


public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        Scanner scanner = new Scanner(System.in);
        int howManyPerson = 0;
        do {


            try {
                System.out.println("Введите количество человек");
                howManyPerson = scanner.nextInt();
                if (howManyPerson <= 1) {
                    System.out.println("Количество человек должно быть больше 1.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Неккоректный ввод");
                scanner.next();
            }

        }
        while (howManyPerson <= 1);


        Scanner scannerFin = new Scanner(System.in);
        String yesOrNo = "";
        while (true) {
            calculator.addProducts();
            calculator.calculate();

            System.out.println("Товар успешно добавлен.\nЕсли хотите ввести ещё один товар нажмите любую клавишу, если нет - введите \"Завершить\"");
            yesOrNo = scannerFin.nextLine();
            if (yesOrNo.equalsIgnoreCase("Завершить")) break;
        }

        System.out.println("Добавленные товары:" + "\n" + calculator.nameItems);
        System.out.println(calculator.result(howManyPerson, calculator.priceItems));


    }


}