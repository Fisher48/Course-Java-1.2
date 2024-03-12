import java.io.File;
import java.io.IOException;

public class FolderDel {
    public static boolean del(File dir) {
        try {
            File[] files = dir.listFiles();
            for (int depth = 0; depth < files.length; depth++) {
                for (File dirs : files) {
                    if (dirs.isDirectory()) {
                        return false;
                    }
                }
                // Если нет подкаталогов удалить все содержимое
                for (File file : files) {
                    file.delete();
                }
            }
            // И удалить саму папку
            dir.delete();
        } catch (NullPointerException e) {
            System.err.println("Ошибка папка не существует");
        }
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
