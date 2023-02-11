package CalcWithMemory;
import java.util.Scanner;

public class View {
    static Scanner console = new Scanner(System.in);

    static void outView(double result) {
        System.out.printf("Результат %.2f\n", result);
    }

    static String inView() {
        System.out.print("Введите целое число: ");
        String temp;
        if (console.hasNextInt()) {
            temp = console.next();
        } else if(!getKey()){
            System.out.println("Неверное число. Попробуйте ещё раз.");
            console.next();
            temp = inView();
        }else {
            temp = console.next();
        }
        return temp;
    }

    static String operatorView() {
        System.out.println("Введите символ арифметического действия: ");
        String operator;
        String s = console.next();

        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
            operator = s;
        } else {
            System.out.println("Оператор не распознан. Попробуйте ещё раз!");
            operator = operatorView();
        }
        return operator;
    }

    static boolean getKey() {
        return console.hasNext("[bq]");
    }
}
