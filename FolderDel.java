import java.io.File;
import java.io.IOException;

/* Напишите функцию, которая удаляет заданный каталог (возможно, непустой) и все файлы внутри него.
Если внутри каталога есть подкаталоги, ничего удалять не надо. Функция возвращает флажок успешно/неудача.*/
public class FolderDel {
    public static boolean del(File dir) throws IOException {
        File[] files = dir.listFiles();
        for(int depth = 0; depth < files.length; depth++) {
            for (File dirs : files) {
                if (dirs.isDirectory()) {
                    return false;
                }
            }
            // Если нет подкаталогов удалить все содержимое и саму папку
            for (File file : files) {
                if (file.isDirectory()) {
                    return false;
                }
                file.delete();
                dir.delete();
            }
        }
        dir.delete();
        return true;
    }
    public static void main (String[]args) throws IOException {
        File dir = new File("D:\\Test");
        if(del(dir)){
            System.out.println("Успешно");
        }
        else
            System.out.println("Неудача");
    }
}
