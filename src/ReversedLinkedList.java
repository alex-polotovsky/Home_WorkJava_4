/*Пусть дан LinkedList с несколькими элементами.
  Реализуйте метод, который вернет “перевернутый” список.*/

import java.util.*;

public class ReversedLinkedList {
    public static void main(String[] args) {
        LinkedList<String> llist = createLinkedList();
        Collections.reverse(llist);
        System.out.println("Reversed list: " + llist);
        reverse2(llist);
        System.out.println("Another reversed list: " + llist);
    }

    private static LinkedList<String> createLinkedList() {
        LinkedList<String> ll = new LinkedList<>();
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Введите строку: ");
            String temp = console.nextLine();
            if (temp.equals("quit")) {
                break;
            }
            ll.add(temp);
            System.out.printf("Input list: %s\n", ll);
        }
        console.close();
        return ll;
    }
    private  static void reverse2(List<String> list){
        Stack<String>stack = new Stack<>();
        for (String l:
            list ) {
            stack.push(l);
        }
        list.replaceAll(i -> stack.pop());




    }
}