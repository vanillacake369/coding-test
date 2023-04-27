package Codetree.LearnList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IntroList {
    private static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int commandNum = scanner.nextInt();
        scanner.nextLine(); // empty buffer
        for (int i = 0; i < commandNum; i++) {
            String command = scanner.nextLine();
            doCommand(command);
        }
    }

    private static void doCommand(String commandStr) {
        String[] commandArr = commandStr.split(" ");
        String commandDetail = commandArr[0];
        int commandNum = 0;
        if (commandArr.length > 1)
            commandNum = Integer.parseInt(commandArr[1]);

        if (commandDetail.equals("push_front"))
            list.addFirst(commandNum);
        else if (commandDetail.equals("push_back"))
            list.addLast(commandNum);
        else if (commandDetail.equals("pop_front"))
            System.out.println(list.pollFirst());
        else if (commandDetail.equals("pop_back"))
            System.out.println(list.pollLast());
        else if (commandDetail.equals("size"))
            System.out.println(list.size());
        else if (commandDetail.equals("empty"))
            if (list.isEmpty() == true)
                System.out.println(1);
            else System.out.println(0);
        else if (commandDetail.equals("front"))
            System.out.println(list.peekFirst());
        else if (commandDetail.equals("back"))
            System.out.println(list.peekLast());
    }
}
