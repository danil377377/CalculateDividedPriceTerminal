import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int howManyPerson;
        do {
            System.out.println("Введите количество человек");
            howManyPerson = scanner.nextInt();
        }
        while (howManyPerson <= 1);

        String nameItem;
        String nameItems = "";
        float priceItem;
        float priceItems = 0.0F;
        Scanner scannerNamesItems = new Scanner(System.in);
        Scanner scannerPricesItems = new Scanner(System.in);
        while (true) {
            String yesOrNo;
            System.out.println("Введите название товара");
            nameItem = scannerNamesItems.nextLine();

            nameItems +=("\n" + nameItem);
            System.out.println("Введите цену товара");
            priceItem = scannerPricesItems.nextFloat();
            priceItems =(float)(priceItems + priceItem);
            System.out.println("Товар успешно добавлен.\nЕсли хотите ввести ещё один товар нажмите любую клавишу, если нет - введите \"Завершить\"");
            yesOrNo = scannerNamesItems.nextLine();
            if (yesOrNo.equalsIgnoreCase("Завершить")) break;
        }

        System.out.println("Добавленные товары:" + "\n" + nameItems );
        System.out.println(result(howManyPerson,priceItems));


    }

    public static String result(int howManyPerson, float sum) {
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
            }}
            String sumToEachPerson = "На каждого выходит %.2f" + ending;
            return String.format(sumToEachPerson, result);

        }

    }