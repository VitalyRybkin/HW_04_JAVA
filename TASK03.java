
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;


public class TASK03 {
    public static void main(String[] args) {
        Scanner scan_line = new Scanner(System.in);
        Stack<Integer> calc_stack = new Stack<>();
        int num_1, num_2;
        String oper;
        String input;
        ArrayList<String> oper_list = new ArrayList<>() {{
            add("-");
            add("+");
            add("*");
            add("/");
        }};

        while (true) {
            boolean is_canceled = false;
            if (calc_stack.isEmpty()) {
                while (true) {
                    System.out.print("Введите число: ");
                    input = scan_line.next();
                    if (input.contains("Отмена")){
                        System.out.println("Список операций пуст!");
                    } else {
                        if (check_input(input)) {
                            num_1 = Integer.parseInt(input);
                            break;
                        }
                    }
                }
            }
            else {
                num_1 = calc_stack.peek();
            }

            while (true) {
                System.out.print("Введите операцию: ");
                oper = scan_line.next();
                if (!oper_list.contains(oper) && !oper.contains("Отмена")){
                    System.out.println("Вы ввели какую-то фигню!");
                } else if (oper.contains("Отмена") && !calc_stack.isEmpty()) {
                    calc_stack.remove(calc_stack.size() - 1);
                    is_canceled = true;
                    break;
                } else{
                    if (calc_stack.isEmpty() && oper.contains("Отмена")){
                        System.out.println("Список операций пуст!");
                    }
                    else {
                        break;
                    }
                }
            }

            if (!is_canceled){
                while (true) {
                    System.out.print("Введите число: ");
                    input = scan_line.next();
                    if (input.contains("Отмена") && (calc_stack.isEmpty())) {
                        System.out.println("Список операций пуст!");
                    } else if (check_input(input)) {
                        num_2 = Integer.parseInt(input);
                        try {
                            calc(num_1, oper, num_2, calc_stack);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                        break;

                    } else if (input.contains("Отмена")) {
                        calc_stack.remove(calc_stack.size() - 1);
                        break;
                    }
                }

                System.out.println("Результат: " + calc_stack.peek());
            }
        }
    }
    public static void calc(int num_1, String oper, int num_2, Stack<Integer> calc_stack) throws IOException {
        int res = switch (oper) {
            case "-" -> num_1 - num_2;
            case "+" -> num_1 + num_2;
            case "/" -> num_1 / num_2;
            case "*" -> num_1 * num_2;
            default -> 0;
        };
        calc_stack.push(res);
    }
    public static boolean check_input(String input){
        try {
            Integer.parseInt(input);
            return true;
        }
        catch (NumberFormatException e){
            System.out.println("Вы ввели какую-то фигню!");
        }
        return false;
    }
}
