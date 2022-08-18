import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создайте список покупок!");

        List<String> list = new ArrayList<>();
        list.add("1. Добавить");
        list.add("2. Показать");
        list.add("3. Удалить");
        list.add("4. Поиск по ключевому слову");

        List<String> product = new ArrayList<>();

        while (true) {
            System.out.println("Ведите номер операции: " + list);
            String input = scanner.nextLine();
            int inp = Integer.parseInt(input);

            switch (inp) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String inputString = scanner.nextLine();
                    product.add(inputString);
                    System.out.println("Итого в списке покупок: " + product.size() + "\n");
                    break;

                case 2:
                    printProduct(product);
                    break;

                case 3:
                    printProduct(product);
                    System.out.println("\nКакую позицию хотите удалить? Введите номер или название:");
                    String inputDelete = scanner.nextLine();

                    if (product.contains(inputDelete)) {
                        System.out.println("Покупка " + inputDelete + " удалена.");
                        product.remove(inputDelete);
                        printProduct(product);
                    } else {
                        int inputDeleteInt = Integer.parseInt(inputDelete);
                        for (int j = 0; j < product.size(); j++) {
                            if ((inputDeleteInt - 1) == j) {
                                System.out.println("Покупка " + product.get(j) + " удалена.");
                                product.remove(j);
                                printProduct(product);
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Введите текст для поиска:");
                    String inputSearch = scanner.nextLine();
                    String queryLower = inputSearch.toLowerCase();
                    System.out.println("Найдено:");
                    for (int i = 0; i < product.size(); i++) {
                        String itemLower = product.get(i).toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println((i + 1) + ". " + itemLower);
                        }
                    }
            }
        }
    }

    public static void printProduct(List product) {
        System.out.println("\nСписок покупок:");
        for (int i = 0; i < product.size(); i++) {
            System.out.println((i + 1) + ". " + product.get(i));
        }
    }
}


