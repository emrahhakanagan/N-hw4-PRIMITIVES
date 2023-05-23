package tax;

public class CalculateTaxSystems {
    public static final double TAX_1 = 0.06; // tax Earnings
    public static final double TAX_2 = 0.15; // tax Earnings Minus Spendings
    public static final String TAX_1_RATE = "%6"; // Принято такое решение, в случае изменение Налоговой Системы
    public static final String TAX_2_RATE = "%15"; // Принято такое решение, в случае изменение Налоговой Системы

    public static final double taxEarnings(int earnings, int spendings) {
        double tax = earnings * TAX_1; // по задаче int требуется, по-этому выполняю здесь приведение
        if (tax >= 0) {
            return tax;
        } else { // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }
    public static final double taxEarningsMinusSpendings(int earnings, int spendings) {
        double tax = (earnings - spendings) * TAX_2;
        if (tax >= 0) {
            return tax;
        } else { // если расходы оказались больше, то налог посчитается отрицательным
            return 0;
        }
    }

    public static final void adviceBestTaxSystem() {
        double tax1 = taxEarnings(FinancialStatement.earnings, FinancialStatement.spendings);
        double tax2 = taxEarningsMinusSpendings(FinancialStatement.earnings, FinancialStatement.spendings);

        if (FinancialStatement.earnings > FinancialStatement.spendings) {
            if (tax1 < tax2) {
                Setup.linesDouble();
                System.out.println("Мы советуем вам налоговую систему < УСН доходы: " + TAX_1_RATE + " >");
                System.out.println("Ваш налог составит: " + tax1 + " рублей");
                System.out.println("Налог на другой системе: " + tax2 + " рублей");
                System.out.println("Экономия: " + (tax2 - tax1) + " рублей");
                Setup.linesDouble();
            } else if (tax1 > tax2) {
                Setup.linesDouble();
                System.out.println("Мы советуем вам налоговую систему < УСН доходы минус расходы: " + TAX_2_RATE + " >");
                System.out.println("Ваш налог составит: " + tax2 + " рублей");
                System.out.println("Налог на другой системе: " + tax1 + " рублей");
                System.out.println("Экономия: " + (tax1 - tax2) + " рублей");
                Setup.linesDouble();
            } else {
                Setup.linesDouble();
                System.out.println("Налоги на обеих системах равны;");
                System.out.println("Можете выбрать любую систему налогообложения!");
                Setup.linesDouble();
            }
        } else if ((FinancialStatement.earnings < FinancialStatement.spendings) && FinancialStatement.earnings !=0) {
                Setup.linesDouble();
                System.out.println("Ваши расходы: " + FinancialStatement.spendings + " рублей больше чем доходы "
                        + FinancialStatement.earnings + " рублей.");
                System.out.println("Сумма к оплате налогов составит 0 рублей.");
                Setup.linesDouble();
        } else if (FinancialStatement.earnings == 0) {
                Setup.linesDouble();
                System.out.println("У Вас нет доходов!");
                System.out.println("Сумма к оплате налогов составит 0 рублей.");
                Setup.linesDouble();
        } else {
                Setup.linesDouble();
                System.out.println("Ваши расходы: " + FinancialStatement.spendings + " рублей больше чем доходы "
                                + FinancialStatement.earnings + " рублей.");
                System.out.println("Сумма к оплате налогов составит 0 рублей.");
                Setup.linesDouble();
        }
    }
}
