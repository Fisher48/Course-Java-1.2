import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DictionaryTask {

    public static ArrayList<Integer> repeatEval(ArrayList<Integer> Numbers, Integer X) {
        HashMap<Integer, Integer> repeat = new HashMap<>();
        ArrayList<Integer> filtered = new ArrayList<>();

        // Проходимся по списку и вносим в словарь значения и счетчик повторения числа
        for (Integer i : Numbers) {
            if (!repeat.containsKey(i)) {
                repeat.put(i,1);
            }
            else {
                repeat.put(i,repeat.get(i)+1);
            }
        }

        // Собираем список из значений, которые повторяются не менее X раз
        for (Integer i : repeat.keySet()) {
            if (repeat.get(i) >= X) {
                filtered.add(i);
            }
        }
        return filtered;
    }

    public static void main (String[] args) {
        // Первое задание - Создаем объект HashMap и называем его Dictionary
        HashMap<Integer, String> Dictionary = new HashMap<>();
        Random rand = new Random();
        int N = 100;

        // Заполняем словарь 100 случайными парами
        while(Dictionary.size() < N) {
            Dictionary.put(rand.nextInt(200)+1, "String" + rand.nextInt(200)+1);
        }

        // Считываем по ключам все значения и выводим на экран
        for (Integer i : Dictionary.keySet()) {
            System.out.println("key: " + i + " value: " + Dictionary.get(i));
        }

        // Удалить все пары
        Dictionary.clear();

        if(Dictionary.isEmpty()) {
            System.out.println("Словарь пуст");
        }

        // Второе задание - создаем список и генерируем значения от 1 до 10
        ArrayList<Integer> Numbers = new ArrayList<>();
        int X = 10; // Кол-во повторений
        for (int i = 0; i < 100; i++) {
            Numbers.add(rand.nextInt(10)+1);
        }
        System.out.println(repeatEval(Numbers,X));
    }
}