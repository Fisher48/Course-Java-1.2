import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TenFiles {
    public static int func(ArrayList list) {
        Random rand = new Random();
        Logger log = Logger.getLogger(TenFiles.class.getName());
        BufferedReader br = null;
        int sum = 0;
        int x = 2;
        try {
            for (int i = 0;  i < x; i++) {
                int r = rand.nextInt(list.size());
                File my_file = new File(r + ".txt");
                br = new BufferedReader(new FileReader(my_file));
                String st = br.readLine();
                assertNotNull(st, "Файл пустой");
                while (st != null) {
                    System.out.println(st);
                    sum += Integer.parseInt(st);
                    st = br.readLine();
                }
                br.close();
                System.out.println("Файл номер - " + r);
            }
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
            ArrayList<File> list = new ArrayList<>();
            try {
                int n = 222;
                Random rand = new Random();
                for (int i = 1; i <= n; i++) {
                    File my_fil = new File(i + ".txt");
                    bw = new BufferedWriter(new FileWriter(my_fil));

                    bw.write(String.valueOf(rand.nextInt(100) + 1));
                    bw.newLine();
                    bw.write(String.valueOf(rand.nextInt(100) + 1));
                    bw.newLine();
                    bw.write(String.valueOf(rand.nextInt(100) + 1));
                    list.add(my_fil);
                    bw.close();
                }
                System.out.println("Сумма из 2-х файлов = " + func(list));
            } catch (Exception e) {
                log.warning("Ошибка записи файла");
            }
        }
}
