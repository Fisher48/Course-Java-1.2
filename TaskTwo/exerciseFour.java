/* Задание - Дополните три класса, которые вы спроектировали в предыдущем задании, методами, подходящими для логики работы с ними. */

package TaskTwo;
class Hunter {
    String name = "Охотник";
    String weapon = "Лук";
    int agility;
    int strenght;  
    double damage;  
    int mana;

Hunter(String n, String w, int a, int s, double d, int m)
  {
   this.name = n;
   this.weapon = w;
   this.agility = a;
   this.strenght = s;
   this.damage = d;
   this.mana = m;
  }   
    void feed_mana(int new_mana) {
      this.mana = new_mana;
    }
}
    class Warrior {
      String name = "Воин";
      String weapon = "Меч";
      int agility;
      int strenght; 
      double damage;  
      int mana;

    Warrior(String n, String w, int a, int s, double d, int m)
      {
        this.name = n;
        this.weapon = w;
        this.agility = a;
        this.strenght = s;
        this.damage = d;
        this.mana = m;
      }   
        void feed_mana(int new_mana) {
          this.mana = new_mana;
        }
    }

      class Dwarf {
        String name = "Дварф";
        String weapon = "Посох";
        int agility;
        int strenght; 
        double damage;  
        int mana;
        Dwarf(String n, String w, int a, int s, double d, int m)
        {
            this.name = n;
            this.weapon = w;
            this.agility = a;
            this.strenght = s;
            this.damage = d;
            this.mana = m;
        }   
          void feed_mana(int new_mana) {
            this.mana = new_mana;
          }
      }

public class exerciseFour {
    public static void main(String[] args) {
        Hunter myHunter = new Hunter("Сергей", "Арбалет", 20, 30, 400,100);
        Warrior myWarrior = new Warrior("Иван", "Двуручный меч", 10, 50, 500, 200);
        Dwarf myDwarf = new Dwarf("Алексей", "Посох", 15, 20, 350, 500);
        
  
        System.out.println("Характеристики Дварфа");
          System.out.println("Ловкость: " + myDwarf.agility);
          System.out.println("Сила: " + myDwarf.strenght);
          System.out.println("Оружие: " + myDwarf.weapon);
          System.out.println("Урон: " + myDwarf.damage);
          System.out.println("Мана: " + myDwarf.mana);
          myDwarf.feed_mana(100);
        System.out.println("Характеристики Охотника");
          System.out.println("Ловкость: " + myHunter.agility);
          System.out.println("Сила: " + myHunter.strenght);
          System.out.println("Оружие: " + myHunter.weapon);
          System.out.println("Урон: " + myHunter.damage);
          System.out.println("Мана: " + myHunter.mana);
          myHunter.feed_mana(200);
        System.out.println("Характеристики Воина");
          System.out.println("Ловкость: " + myWarrior.agility);
          System.out.println("Сила: " + myWarrior.strenght);
          System.out.println("Оружие: " + myWarrior.weapon);
          System.out.println("Урон: " + myWarrior.damage);
          System.out.println("Мана: " + myWarrior.mana);
          myWarrior.feed_mana(350);
    }
    
}
