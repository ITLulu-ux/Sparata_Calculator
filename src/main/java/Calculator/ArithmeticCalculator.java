package Calculator;

public class ArithmeticCalculator<T extends Double> {
    public double calculate(T a, T b, OperatorType operator) {

        double num1 = a.doubleValue();
        double num2 = b.doubleValue();

        switch (operator) {
            case ADD:
                return num1 + num2;

            case SUBTRACT:
                return num1- num2;

            case MULTIPLY:
                return num1 * num2;

            case DIVIDE:
                if (num2 == 0) {
                    throw new ArithmeticException("math error");
                }
                return num1 / num2;

            default:
                throw new IllegalArgumentException("syntax error");
        }

        //double result = calculator.calculate(a, b, c);
    }
}
