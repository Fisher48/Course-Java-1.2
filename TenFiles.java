import java.io.*;
import java.util.*;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

public class TenFiles {

    public static class NotCorrectQuantityofStringException extends Exception {
        public NotCorrectQuantityofStringException (String message) {
            super(message);
        }
    }

    public static int[] filesSum(ArrayList list) {
        Random rand = new Random();
        int[] res = new int[2];
        res[0] = 0;
        res[1] = 0;
        for (int i = 0; i < 2; i++) {
            int[] r;
            r = func((File) list.get(rand.nextInt(list.size())+1));
            if (r[1] != 0) {
                res[1] = r[1];
                return res;
            }
            res[0] += r[0];
        }
        return res;
    }

    public static int[] func(File file) {
        Logger log = Logger.getLogger(TenFiles.class.getName());
        BufferedReader br = null;
        int[] res = new int[2];
        res[1] = 0;
        int sum = 0;
        int count = 0;
        try {
            File my_file = new File(String.valueOf(file));
            br = new BufferedReader(new FileReader(my_file));
            String st = br.readLine();
            assertNotNull(st, "Файл пустой");
            while (st != null) {
                log.info(st);
                sum += Integer.parseInt(st);
                st = br.readLine();
                count++;
            }
            if (count != 3) {
                throw new NotCorrectQuantityofStringException ("Неверное кол-во строк");
            }
            log.info("Файл номер - " + file.getName());
        } catch (IOException e) {
            log.warning("Error");
        } catch (NumberFormatException e) {
            res[1] = 1;
            log.warning("Файл не парсится");
        } catch (NotCorrectQuantityofStringException exception) {
            res[1] = 2;
            log.warning("Неверное кол-во строк");
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    res[1] = 3;
                    log.warning("Ошибка чтения файла");
                }
            }
        }
        res[0] = sum;
        return res;
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
                System.out.println("Сумма из 2-х файлов = " + Arrays.toString(filesSum(list)));
            } catch (Exception e) {
                log.warning("Ошибка записи файла");
            }
        }
}