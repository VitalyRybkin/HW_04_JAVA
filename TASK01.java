import java.util.*;

public class TASK01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rnd = new Random();
        LinkedList<Integer> linked_list = new LinkedList<>();

        System.out.print("Введите размер списка: ");
        int list_size = scanner.nextInt();

        long start = System.nanoTime();

        for (int i = 0; i < list_size; i ++){
            linked_list.add(rnd.nextInt(1, 10));
        }
        System.out.println(linked_list);

        System.out.println("Цикл for и доп. лист: ");
        LinkedList<Integer> reversed_list = new LinkedList<>();
        for (int i = linked_list.size() - 1; i >= 0; i -- ){
            reversed_list.add(linked_list.get(i));
        }
        System.out.println(reversed_list);

        long finish = System.nanoTime();
        System.out.println("Время: " + (finish - start));

        System.out.println("Collections.swap: ");
        start = System.nanoTime();

        int i = 0;
        int j = reversed_list.size() - 1;
        while (i < j) {
            Collections.swap(reversed_list, i, j);
            i ++;
            j --;
        }
        System.out.println(reversed_list);
        finish = System.nanoTime();
        System.out.println("Время: " + (finish - start));

    }
}
