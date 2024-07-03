import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DictionaryTask {

    public static ArrayList<Integer> repeatEval(ArrayList<Integer> Numbers, Integer numberOfRepetitions) {
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
            if (repeat.get(i).equals(numberOfRepetitions)) {
                filtered.add(i);
            }
        }
        assert (!repeat.isEmpty()) : "Словарь не заполнен";
        return filtered;
    }

    public static void main (String[] args) {
        HashMap<Integer, String> Dictionary = new HashMap<>();
        Random rand = new Random();
        int N = 100;
        while(Dictionary.size() < N) {
            Dictionary.put(rand.nextInt(200)+1, "String" + rand.nextInt(200)+1);
        }
        assert (Dictionary.size() > N) : "Словарь больше заданного значения";

        for (Integer i : Dictionary.keySet()) {
            System.out.println("key: " + i + " value: " + Dictionary.get(i));
        }

        Dictionary.clear();
        assert (Dictionary == null) : "Словарь не очищен";

        if(Dictionary.isEmpty()) {
            System.out.println("Словарь пуст");
        }

        // Второе задание - создаем список и генерируем значения от 1 до 10
        ArrayList<Integer> Numbers = new ArrayList<>();
        int numberOfRepetitions = 10;
        for (int i = 0; i < 100; i++) {
            Numbers.add(rand.nextInt(10)+1);
            assert (i > 0) : "Отрицательный счетчик";
        }
        System.out.println(repeatEval(Numbers,numberOfRepetitions));
    }
}