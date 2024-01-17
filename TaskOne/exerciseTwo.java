/* 1.2 Сделайте три простых класса из любой (одной) компьютерной темы, которая вам интересна, и которые логически связаны друг с другом.
В каждом классе должно быть не менее трёх (лучше 5-7) полей. Например, можно взять описание игры Dwarf Fortress.
Почитайте, кто такие дварфы, какое у них бывает оружие, и какие в игре существуют животные.
Создайте несколько объектов этих классов, поприсваивайте значения их полям, выведите их на экран.*/

package TaskOne;

class Hunter {
    String name = "Охотник";
    String weapon = "Лук";
    int agility;
    int strenght;  
    double damage;  
    int mana;
  }
    class Warrior {
      String name = "Воин";
      String weapon = "Меч";
      int agility;
      int strenght; 
      double damage;  
      int mana;
    }
      class Dwarf {
        String name = "Дварф";
        String weapon = "Посох";
        int agility;
        int strenght; 
        double damage;  
        int mana;
      }
  public class exerciseTwo {
      public static void main(String[] args) {
        Hunter myHunter = new Hunter();
        Warrior myWarrior = new Warrior();
        Dwarf myDwarf = new Dwarf();
        
        myDwarf.damage = 50;
        myDwarf.mana = 500;
        myHunter.damage = 100;
        myWarrior.damage = 200;
        myDwarf.agility = 5;
        myHunter.agility = 15;
        myWarrior.agility = myHunter.agility / 2;
        myHunter.mana = myDwarf.mana / 2;
        myWarrior.mana = myDwarf.mana / 3;
        myWarrior.strenght = 20;
        myHunter.strenght = myWarrior.strenght / 2;
        myDwarf.strenght = myWarrior.strenght / 3;
  
        System.out.println("Характеристики Дварфа");
          System.out.println("Ловкость: " + myDwarf.agility);
          System.out.println("Сила: " + myDwarf.strenght);
          System.out.println("Оружие: " + myDwarf.weapon);
          System.out.println("Урон: " + myDwarf.damage);
          System.out.println("Мана: " + myDwarf.mana);
        System.out.println("Характеристики Охотника");
          System.out.println("Ловкость: " + myHunter.agility);
          System.out.println("Сила: " + myHunter.strenght);
          System.out.println("Оружие: " + myHunter.weapon);
          System.out.println("Урон: " + myHunter.damage);
          System.out.println("Мана: " + myHunter.mana);
        System.out.println("Характеристики Воина");
          System.out.println("Ловкость: " + myWarrior.agility);
          System.out.println("Сила: " + myWarrior.strenght);
          System.out.println("Оружие: " + myWarrior.weapon);
          System.out.println("Урон: " + myWarrior.damage);
          System.out.println("Мана: " + myWarrior.mana);
      }
  }