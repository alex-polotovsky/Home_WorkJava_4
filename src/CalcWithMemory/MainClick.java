/*К калькулятору из предыдущего дз добавить логирование.
В калькулятор добавьте возможность отменить последнюю операцию.*/

package CalcWithMemory;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class MainClick {
    static Logger logger = Logger.getLogger(Calc.class.getName());

    public static void main(String[] args) {
        FileHandler fh;

        {
            try {
                fh = new FileHandler("logCalc.txt");
                logger.addHandler(fh);
                SimpleFormatter sForm = new SimpleFormatter();
                fh.setFormatter(sForm);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Горячие клавиши: \"b\" - отмена последней операции,\n \"q\" - выход из программы.");
        Controller.control();


    }
}
