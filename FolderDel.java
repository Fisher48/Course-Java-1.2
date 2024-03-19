import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class FolderDel {

    public static List<List<Path>> func(File path) {
        Logger log = Logger.getLogger(FolderDel.class.getName());
        List<List<Path>> list = new ArrayList<>();
        List<Path> files = new ArrayList<>();
        try {
            files = Files.walk(Paths.get(String.valueOf(path)))
                    .filter(Files::isRegularFile)
                    .collect(Collectors.toList());

        } catch (IOException | NullPointerException e) {
            log.warning(String.valueOf(e));
        }

        List<Path> dirs = new ArrayList<>();
        try {
            dirs = Files.walk(Paths.get(String.valueOf(path)))
                    .parallel().filter(Files::isDirectory)
                    .collect(Collectors.toList());

        } catch (IOException e) {
            log.warning(String.valueOf(e));
        }
        list.add(dirs);
        list.add(files);
        return list;
    }

    public static boolean del(File dir) {
        Logger log = Logger.getLogger(FolderDel.class.getName());
        try {
            List<List<Path>> fil = func(dir);
            if (fil.get(0).size() > 1) {
                return false;
            }
            // Если нет подкаталогов удалить все содержимое
            File[] files = dir.listFiles();
            for (File file : files) {
                file.delete();
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
        if (del(dir)) {
            log.info("Успешно");
        }
        else
            log.info("Неудача");
    }
}