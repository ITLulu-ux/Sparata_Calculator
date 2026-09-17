package Calculator;


import java.util.*;
import java.util.Scanner;

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
                OperatorType operator;

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
                }

                double result = calculator.calculate(a, b, operator);

                calculator.addResult(result);

                calculator.removeResult();

                System.out.println("결과: " + result);

            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            // System.out.println("결과: " + result);

            System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
            /* exit을 입력 받으면 반복 종료*/
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
