import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            class Person {
                String name;
                int HP;
                int mana;

                public Person(String n, int h, int m) {
                    this.name = n;
                    this.HP = h;
                    this.mana = m;
                }
            }
            File my_file = new File("Persons.txt");
            br = new BufferedReader(new FileReader(my_file));
            String st = br.readLine();
            ArrayList<Person> list = new ArrayList<>();
            while (st != null) {
                String text = st;
                String[] param = text.split(" ");
                list.add(new Person(param[0], Integer.parseInt(param[1]), Integer.parseInt(param[2])));
                System.out.println(Arrays.toString(param));
                st = br.readLine();
            }
        } catch (IOException ignored) {
            System.err.println("Возникла ошибка");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}