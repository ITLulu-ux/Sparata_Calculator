package Calculator;
import java.util.*;


class Calculator {
    // 연산 결과를 저장하는 컬렉션 필드
    private ArrayList<Double> results;
    private ArithmeticCalculator<Double> arithmeticCalculator;

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
        arithmeticCalculator = new ArithmeticCalculator<>();
    }

    public double calculate(double a, double b, OperatorType operator) {
        return arithmeticCalculator.calculate(a, b, operator);
    }
    // 사칙연산 > enum/제네릭 변환으로 삭제
        /*OperatorType operator;

        switch (c) {
            case '+':
                operator = OperatorType.ADD;
                break;

            case '-':
                operator = OperatorType.SUBTRACT;
                break;

            case '*':
                operator = OperatorType.MULTIPLY;
                break;

            case '/':
                operator = OperatorType.DIVIDE;
                break;

            default:
                throw new IllegalArgumentException("syntax error");
        }*/



    // 결과 저장
    public void addResult(double result) {
        results.add(result);
    }

    // Getter
    public ArrayList<Double> getResults() {
        return results;
    }

    // Setter
    public void setResults(ArrayList<Double> results) {
        this.results = results;
    }

    public void removeResult() {
        if(!results.isEmpty()) {
            results.remove(0);
        }
    }
}
