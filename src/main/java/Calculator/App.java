package Calculator;
import java.util.*;
import java.util.Scanner;


class Calculator {
    // 연산 결과를 저장하는 컬렉션 필드
    private ArrayList<Double> results;

    // 생성자
    public Calculator() {
        results = new ArrayList<>();
    }

    // 사칙연산
    public double calculate(double a, double b, char c) {
        switch (c) {
            case '+':
                return a + b;

            case '-':
                return a - b;

            case '*':
                return a * b;

            case '/':
                if (b == 0) {
                    throw new ArithmeticException("math error");
                }
                return a / b;

            default:
                throw new IllegalArgumentException("syntax error");
        }

    }

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
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Calculator 인스턴스 생성
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            double a = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            double b = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            char c = sc.next().charAt(0);

            try {
                // Calculator에게 계산을 맡김
                double result = calculator.calculate(a, b, c);

                // 계산 결과 저장
                calculator.addResult(result);

                calculator.removeResult();

                System.out.println("결과: " + result);

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료 */
            sc.nextLine();  // 앞선 nextInt()/next()가 남긴 엔터 제거
            String answer = sc.nextLine();

            if (answer.equals("exit")) {
                break;
            } else {
                continue;
            }
        }

        sc.close();
    }
}