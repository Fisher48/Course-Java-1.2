# Отчёт в формате md со скриншотами вывода программы в консоль Far-a

**Код программы для запуска через Far**
```Java
package TaskSeven;
import java.util.Scanner;
public class FarTest
{
  public static void main(String[] args)
  {
    Scanner keyboard = new Scanner(System.in);
    
    System.out.println("Введите кол-во цен:");
    int prices = keyboard.nextInt(); // Кол-во цен
    int p, price, min_price = 0, max_price = 0;
    System.out.println("Введите цены:");
    for(p = 0; p < prices; p ++) {
        price = keyboard.nextInt(); // Очередная цена
        
        if(p == 0) { 
          min_price = price;
          max_price = price;
        } else
        if(price < min_price)
          min_price = price; else
        if(price > max_price)
          max_price = price;
    }
    System.out.println("Минимальная цена: " + min_price);
    System.out.println("Максимальная цена: " + max_price);
  }
}
```
- ***Расположение файлов***  

![Расположение файлов](https://github.com/Fisher48/Course-Java-1.2/assets/156232888/5a8d33ca-9a35-4bdd-8047-410a74b58492)  
  
- ***Просмотр кода в программе Far***
  
![Просмотр кода в программе Far](https://github.com/Fisher48/Course-Java-1.2/assets/156232888/1ae079f7-24f1-49cc-aeb9-dd3472936caa)
  
- ***Скриншот запуска программы в Far***  
  
![Скриншот запуска программы в Far](https://github.com/Fisher48/Course-Java-1.2/assets/156232888/59559d37-8b7d-4b08-ac2a-2f1a251e7dd9)

