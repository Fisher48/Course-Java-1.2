import java.io.*;
import java.util.ArrayList;
import java.util.zip.*;

public class TaskSixteen {
    public static void arch(String name, ArrayList<String> Files) throws IOException {

        // Открываем поток - FileOutputStream, создавая объект fileOutputStream
        FileOutputStream fileOutputStream = new FileOutputStream(name);

        // Открываем поток файл - архив
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        // Цикл для записи в архив из массива имён файлов
        try {
            for (String file : Files) {

                // Присваиваем классу File каждый объект из массива
                File fileToZip = new File(file);

                // Файл для добавления в создаваемый архив
                ZipEntry zipEntry = new ZipEntry(fileToZip.getName());

                // Добавляем новую сущность (заголовок) в архив
                zipOutputStream.putNextEntry(zipEntry);

                // Копируем (записываем) исходный файл в архив
                FileInputStream fileInputStream = new FileInputStream(fileToZip);

                // Вводим длину как размер файла
                int length;

                // Вводим массив чисел - это буфер обмена своеобразный,
                // в который мы записываем файлы в битовом формате
                byte[] buffer = new byte[1024];

                // Выполнять запись файла в архив, пока не закончатся данные файла (length -1)
                while ((length = fileInputStream.read(buffer)) > 0) {
                    zipOutputStream.write(buffer, 0, length);
                }
                // Закрываем файловый поток
                fileInputStream.close();
            }
            // Закрываем все файлы и потоки
            zipOutputStream.closeEntry();
            zipOutputStream.close();
        } catch (FileNotFoundException e) { // Ловим исключение, если файл не существует
            System.err.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
        String file1 = "Tests.txt";
        String file2 = "Persons.txt";
        String archive = "Out.zip";
        ArrayList<String> Files = new ArrayList<>();
        Files.add(file1);
        Files.add(file2);

        arch(archive, Files); // в функцию подается имя архива и массив из списков файлов
    }
}
