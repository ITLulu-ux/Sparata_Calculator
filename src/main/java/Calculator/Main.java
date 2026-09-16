package Calculator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int a = sc.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            // Scanner를 사용하여 양의 정수를 입력받고 적합한 타입의 변수에 저장합니다.
            int b = sc.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            // 사칙연산 기호를 적합한 타입으로 선언한 변수에 저장합니다.
            char c = sc.next().charAt(0);

            int result = 0;

            try {
                switch (c) {
                    case '+':
                        result = a + b;
                        break;

                    case '-':
                        result = a - b;
                        break;

                    case '*':
                        result = a * b;
                        break;

                    case '/':
                        if (b == 0) {
                            throw new ArithmeticException("math error");
                        }
                        result = a / b;
                        break;

                    default:
                        throw new IllegalArgumentException("syntax error");

                }
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