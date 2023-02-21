package decorator;

import java.util.function.DoubleUnaryOperator;
import java.util.stream.Stream;

public class DecoratorLambda {

    public static void main(String... args) {
        new DefaultSalaryCalculator()
            .andThen(Taxes::generalTax)
            .andThen(Taxes::regionalTax)
            .andThen(Taxes::healthInsurance)
            .applyAsDouble(80000.00);

        System.out.println(
                calculateSalary(80000.00,
                        new DefaultSalaryCalculator(),
                        Taxes::generalTax,
                        Taxes::regionalTax,
                        Taxes::healthInsurance));
    }

    public static double calculateSalary(double annualGross, DoubleUnaryOperator... taxes) {
        return Stream.of(taxes)
                .reduce(DoubleUnaryOperator.identity(),
                        DoubleUnaryOperator::andThen)
                .applyAsDouble(annualGross);
    }

    public static class DefaultSalaryCalculator implements DoubleUnaryOperator {
        @Override
        public double applyAsDouble(double grossAnnual) {
            return grossAnnual / 12;
        }
    }
}
