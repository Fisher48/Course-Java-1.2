import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskFifteen {
    
    public static void main (String[]args) {
    File root = new File("."); // Связываем имя root с текущим каталогом, в котором запускаем программу (берётся всё, включая скрытые папки)
    ArrayList<File> expand = new ArrayList<>(); // Создаем список expand состоящий из файлов каталогов и подкаталогов
    expand.add(root); // Добавляем объект, который содержит все объекты корневой папки (файлы, каталоги и подкаталоги)

       for(int depth = 0; depth < 10; depth++) { // Цикл до глубины 10 текущего каталога
        File[] expandCopy = expand.toArray(new File[expand.size()]); // Создаем массив по длине как список expand и преобразуем список элементов в массив
        expand.clear(); // Очистить список при переходе на след. уровень глубины
        for (File file : expandCopy) { // В цикле проходимся по каждому элементу массива expandCopy
            System.out.println(depth + " " + file); // Печатаем глубину и путь
            if (file.isDirectory()) { // Если элемент является папкой -> входим в условие
                expand.addAll(Arrays.asList(file.listFiles())); // Возвращаем массив файлов и подкаталогов, которые находятся в определенном каталоге
            }
        }
       }
    }
}