import java.util.Scanner;
import tax.CalculateTaxSystems;
import tax.FinancialStatement;
import tax.Setup;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            Setup.printMenu();

            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }

            int operation = Integer.parseInt(input);
            switch (operation) {
                case 1:
                    System.out.print("Введите сумму дохода: ");
                    String moneyEarningsStr = scanner.nextLine();
                    int moneyEarnings = Integer.parseInt(moneyEarningsStr);
                    FinancialStatement.earnings += moneyEarnings;
                    break;

                case 2:
                    System.out.print("Введите сумму расходов: ");
                    String moneySpendingsStr = scanner.nextLine();
                    int moneySpendings = Integer.parseInt(moneySpendingsStr);
                    FinancialStatement.spendings += moneySpendings;
                    break;

                case 3:
                    CalculateTaxSystems.adviceBestTaxSystem();
                    break;

                default:
                    System.out.println("Такой операции нет");
            }
        }
        System.out.println("Программа завершена!");
    }
}