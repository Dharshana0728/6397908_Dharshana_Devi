import java.util.Scanner;

public class FinancialForecasting {
    static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        } else {
            return (1 + growthRate) * futureValue(presentValue, growthRate, years - 1);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter Present Value (e.g. 1000): ");
            double pv = scanner.nextDouble();

            System.out.print("Enter Annual Growth Rate (as decimal, e.g. 0.05 for 5%): ");
            double rate = scanner.nextDouble();

            System.out.print("Enter Number of Years: ");
            int years = scanner.nextInt();

            double fv = futureValue(pv, rate, years);
            System.out.printf("Predicted Future Value after %d years: %.2f\n", years, fv);
        }
    }
}
