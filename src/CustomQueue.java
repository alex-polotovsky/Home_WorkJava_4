/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
*/

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class CustomQueue {
    public static void main(String[] args) {
        Deque<String> deq = createLinkedList();
        System.out.printf("Our deque: %s\n", deq);

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String temp = sc.next();
        enqueue(deq, temp);
        System.out.println(deq);

        System.out.println("Delete first element " + dequeue(deq));
        System.out.println(deq);

        System.out.println("Retrieve first element " + first(deq));
        System.out.println(deq);

    }

    private static LinkedList<String> createLinkedList() {
        LinkedList<String> ll = new LinkedList<>();
        Scanner console = new Scanner(System.in);
        while (true) {
            System.out.print("Введите строку: ");
            String temp = console.next();
            if (temp.equals("quit")) {
                break;
            }
            ll.add(temp);
            System.out.printf("Input list: %s\n", ll);
        }
        //console.close();
        return ll;
    }
    private static void enqueue(Deque<String> d, String s){
        d.addLast(s);
    }
    private static String dequeue(Deque<String> d){
        return d.pollFirst();
    }
    private static String first(Deque<String> d){
        return d.peekFirst();
    }
}