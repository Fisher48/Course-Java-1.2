/* Задание - Дополните три класса, которые вы спроектировали в предыдущем задании, методами, подходящими для логики работы с ними. */

package TaskTwo;
class Hunter {
    String name = "Охотник";
    String weapon = "Лук";
    int HP = 500;
    int agility;
    int strenght;  
    double damage;  
    int mana;

Hunter (String n, String w, int h, int a, int s, double d, int m)
  {
    this.name = n;
    this.weapon = w;
    this.HP = h;
    this.agility = a;
    this.strenght = s;
    this.damage = d;
    this.mana = m;
  }   
    void feed_mana(int new_mana) {
      this.mana = new_mana;
    }

    // эликсир увеличит ХП 
    void healing(int HP){
        this.HP += HP;
      }

      void attack() {
        this.feed_mana(-100); 
        this.healing(-100);
      }
}
    class Warrior {
      String name = "Воин";
      String weapon = "Меч";
      int HP = 800;
      int agility;
      int strenght; 
      double damage;  
      int mana;

    Warrior (String n, String w, int h, int a, int s, double d, int m)
      {
        this.name = n;
        this.weapon = w;
        this.HP = h;
        this.agility = a;
        this.strenght = s;
        this.damage = d;
        this.mana = m;
      }   
        void feed_mana(int new_mana) {
          this.mana = new_mana;
        }

        // эликсир увеличит ХП 
        void healing(int HP){
            this.HP += HP;
          }

        void attack(int mana, int HP) {
            this.feed_mana(-100); 
            this.healing(-200);
          }
    }

      class Dwarf {
        String name = "Дварф";
        String weapon = "Посох";
        int HP = 400;
        int agility;
        int strenght; 
        double damage;  
        int mana;
        Dwarf (String n, String w, int h, int a, int s, double d, int m)
        {
          this.name = n;
          this.weapon = w;
          this.HP = h;
          this.agility = a;
          this.strenght = s;
          this.damage = d;
          this.mana = m;
        } 

          // эликсир восстановит ману
          void feed_mana(int new_mana) {
            this.mana = new_mana;
          }

          // эликсир увеличит ХП 
          void healing(int HP){
            this.HP += HP;
          }

          // атака на персонажа - ХП и мана
          void attack(int mana, int HP) {
            this.feed_mana(mana); 
            this.healing(HP);
          }
      }

public class exerciseFour {
    public static void main(String[] args) {
        Hunter myHunter = new Hunter("Сергей", "Арбалет", 600, 200, 30, 400,100);
        Warrior myWarrior = new Warrior("Иван", "Двуручный меч", 800, 10, 50, 500, 200);
        Dwarf myDwarf = new Dwarf("Алексей", "Посох",500, 15, 20, 350, 500);

        myDwarf.healing(100); // увеличение здоровья эликсиром
        myDwarf.feed_mana(100);

        myWarrior.attack(-100,-100);
        myWarrior.feed_mana(350);
        myHunter.feed_mana(200);
        
        System.out.println("Характеристики Дварфа");
          System.out.println("Здоровье: " + myDwarf.HP);
          System.out.println("Ловкость: " + myDwarf.agility);
          System.out.println("Сила: " + myDwarf.strenght);
          System.out.println("Оружие: " + myDwarf.weapon);
          System.out.println("Урон: " + myDwarf.damage);
          System.out.println("Мана: " + myDwarf.mana);
          System.out.println();

        System.out.println("Характеристики Охотника");
          System.out.println("Здоровье: " + myHunter.HP);
          System.out.println("Ловкость: " + myHunter.agility);
          System.out.println("Сила: " + myHunter.strenght);
          System.out.println("Оружие: " + myHunter.weapon);
          System.out.println("Урон: " + myHunter.damage);
          System.out.println("Мана: " + myHunter.mana);
          System.out.println();

        System.out.println("Характеристики Воина");
          System.out.println("Здоровье: " + myWarrior.HP);
          System.out.println("Ловкость: " + myWarrior.agility);
          System.out.println("Сила: " + myWarrior.strenght);
          System.out.println("Оружие: " + myWarrior.weapon);
          System.out.println("Урон: " + myWarrior.damage);
          System.out.println("Мана: " + myWarrior.mana);
          System.out.println();
    }
    
}
