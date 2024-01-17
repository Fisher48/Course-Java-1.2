/* 1.3. Напишите наглядный пример на основе задания 2, который демонстрирует побочный эффект от передачи объектов по ссылке. */

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
  public class exerciseTree {
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
  
        Dwarf myDwarf1 = new Dwarf();
        myDwarf = myDwarf1;
        
        myDwarf.strenght = myWarrior.strenght / 3;
        myDwarf.mana = myHunter.mana * 2;
        myDwarf.weapon = "Ножи";
  
        System.out.println("Характеристики Дварфа 1");
          System.out.println("Ловкость: " + myDwarf1.agility);
          System.out.println("Сила: " + myDwarf1.strenght);
          System.out.println("Оружие: " + myDwarf1.weapon);
          System.out.println("Урон: " + myDwarf1.damage);
          System.out.println("Мана: " + myDwarf1.mana);
        System.out.println("Характеристики Дварфа");
          System.out.println("Ловкость: " + myDwarf.agility);
          System.out.println("Сила: " + myDwarf.strenght);
          System.out.println("Оружие: " + myDwarf.weapon);
          System.out.println("Урон: " + myDwarf.damage);
          System.out.println("Мана: " + myDwarf.mana);
      }
  }
