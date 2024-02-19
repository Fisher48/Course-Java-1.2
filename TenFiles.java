import java.io.*;
import java.util.Random;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TenFiles {
    public static int func(int path, int path2) {
        Logger log = Logger.getLogger(TenFiles.class.getName());
        BufferedReader br = null;
        int sum = 0;
        try {
            File my_file = new File(path + ".txt");
            br = new BufferedReader(new FileReader(my_file));
            String st = br.readLine();
            assertNotNull(st, "Файл пустой");
            while (st != null) {
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
            while (st2 != null) {
                System.out.println(st2);
                sum += Integer.parseInt(st2);
                st2 = br.readLine();
            }
            br.close();
            System.out.println("Файл номер - " + path2);
            return sum;
        } catch (IOException e) {
            System.err.println("Error");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    log.warning("Ошибка чтения файла");
                }
            }
        }
        return sum;
    }
        public static void main (String[]args) {
            Logger log = Logger.getLogger(TenFiles.class.getName());
            BufferedWriter bw;
            try {
                int n = 10;
                Random rand = new Random();
                for (int i = 1; i <= n; i++) {
                    File my_fil = new File(i + ".txt");
                    bw = new BufferedWriter(new FileWriter(my_fil));

                    bw.write(String.valueOf(rand.nextInt(100) + 1));
                    bw.newLine();
                    bw.write(String.valueOf(rand.nextInt(100) + 1));
                    bw.newLine();
                    bw.write(String.valueOf(rand.nextInt(100) + 1));
                    bw.close();
                }
                System.out.println("Сумма из 2-х файлов = " + func(rand.nextInt(10) + 1, rand.nextInt(10) + 1));
            } catch (Exception e) {
                log.warning("Ошибка записи файла");
            }
        }
}
