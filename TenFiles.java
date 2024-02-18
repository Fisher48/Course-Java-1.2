import java.io.*;
import java.util.Random;
import static org.junit.jupiter.api.Assertions.*;

public class TenFiles {
    public static int func(int path, int path2) throws Exception {
        File my_file = new File(path + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(my_file));
        String st = br.readLine();
        int sum = 0;
        assertNotNull(st , "Файл пустой");
        while(st != null) {
            System.out.println(st);
            sum += Integer.parseInt(st);
            st = br.readLine();
        }
        br.close();
        System.out.println("Файл номер - " + path);

        File my_file2 = new File(path2 + ".txt");
        br = new BufferedReader(new FileReader(my_file2));
        String st2 = br.readLine();
        assertNotNull(st2, "Файл пустой");
        while(st2 != null) {
            System.out.println(st2);
            sum += Integer.parseInt(st2);
            st2 = br.readLine();
        }
        br.close();
        System.out.println("Файл номер - " + path2);

        return sum;
    }
    public static void main(String[] args) throws Exception {
        int n = 10;
        Random rand = new Random();
        for (int i = 1; i <= n; i++) {
            File my_fil = new File(i + ".txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(my_fil));

            bw.write(String.valueOf(rand.nextInt(100) + 1));
            bw.newLine();
            bw.write(String.valueOf(rand.nextInt(100) + 1));
            bw.newLine();
            bw.write(String.valueOf(rand.nextInt(100) + 1));
            bw.close();
        }
        System.out.println("Сумма из 2-х файлов = " + func(rand.nextInt(10)+1, rand.nextInt(10)+1));
    }
}
