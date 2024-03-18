import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class FolderDel {
    public static boolean del(File dir) {
        Logger log = Logger.getLogger(FolderDel.class.getName());
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
            log.warning("Ошибка папка не существует");
            return false;
        }
        return true;
    }
    public static void main (String[]args) throws IOException {
        Logger log = Logger.getLogger(FolderDel.class.getName());
        File dir = new File("D:\\Test");
        if(del(dir)){
            log.info("Успешно");
        }
        else
            log.info("Неудача");
    }
}