package CalcWithMemory;

import java.lang.management.MemoryManagerMXBean;

public class Controller {
    static String key = "key";

    static void control() {
        parseX(View.inView());

        while (true) {
            parseY(View.inView());
            if (key.equals("b")) {
                MainClick.logger.info("Отмена операции.");
                if (Memory.memory.size() < 2) {
                    Memory.memory.pollFirst();
                    parseX(View.inView());
                }
                Calc.x = Memory.memory.peekFirst();
                System.out.println("x = " + Calc.x);
                if (Memory.memory.size() > 1) {
                    Memory.memory.pollLast();
                }
                parseY(View.inView());
            } else if (key.equals("q")) {
                MainClick.logger.info("Выход из программы.");
                return;
            }
            if (Memory.memory.size() == 2) {
                Memory.memory.pollFirst();
            }
            String operator = View.operatorView();
            double res = switch (operator) {
                case "+" -> Calc.sum();
                case "-" -> Calc.sub();
                case "*" -> Calc.mult();
                case "/" -> Calc.div();
                default -> 0.0;
            };
            View.outView(res);
            Memory.memory.addLast(res);
            Calc.x = Memory.memory.peekLast();
            System.out.println(Memory.memory);
        }
    }

    static void parseX(String s) {
        if (s.matches("[0-9]+")) {
            Calc.x = Integer.parseInt(s);
            Memory.memory.addFirst(Calc.x);
        } else {
            key = s;
        }
    }

    static void parseY(String s) {
        if (s.matches("[0-9]+")) {
            Calc.y = Integer.parseInt(s);
        } else {
            key = s;
        }
    }
}
