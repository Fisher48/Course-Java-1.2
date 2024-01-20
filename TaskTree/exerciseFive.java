/* Задания
5.1. Разделите видимость полей (сделайте все поля приватными) и методов во всех классах вашей программы.
5.2. Добавьте в каждый класс конструктор.
5.3. Постройте небольшую иерархию классов в вашей программе. */

package TaskTree;
class Person {
    protected int HP;
    protected int agility;
    protected int strenght;
    protected double damage;
    protected int mana;
    
    Person (int h, int a, int s, double d, int m) {
        this.HP = h;
        this.agility = a;
        this.strenght = s;
        this.damage = d;
        this.mana = m;
    }
    
      // эликсир увеличит ХП 
      void healing() {
        this.HP += 100;
      }

      // потеря ХП 
      void loss() {
        this.HP -= 200;
      }
      
      // эликсир восстановит ману
      void feed_mana(int new_mana) {
        this.mana += new_mana;
      }
    
      // атака на персонажа - ХП и мана
      void magic_attack() {
        this.feed_mana(-200); 
        this.loss();
      }
}
    class Hunter extends Person {
        protected String name;
        protected String weapon;

      Hunter (int h, int a, int s, double d, int m, String n, String w) {
        super(h, a, s, d, m);
        this.name = n;
        this.weapon = w;
      }
    }

    class Warrior extends Person {
        protected String name;
        protected String weapon;

      Warrior (int h, int a, int s, double d, int m, String n, String w) {
        super(h, a, s, d, m);
        this.name = n;
        this.weapon = w;
     }    
    }

    class Dwarf extends Person {
        protected String name;
        protected String weapon;

      Dwarf (int h, int a, int s, double d, int m, String n, String w) {
        super(h, a, s, d, m);
        this.name = n;
        this.weapon = w;
    }
}

  public class exerciseFive {
    public static void main(String[] args) {
        
        Dwarf myDwarf = new Dwarf(500, 20, 15, 120, 350, "Грумер", "Посох");
        Hunter myHunter = new Hunter(600, 25, 20, 150, 150, "Хантер", "Лук");
        Warrior myWarrior = new Warrior(800, 30, 10, 200, 100, "Дуэйн", "Меч");

        myDwarf.healing(); // увеличение здоровья эликсиром
        myDwarf.feed_mana(100);  // пополнение маны

        myHunter.feed_mana(200);
        myHunter.magic_attack(); // магическая атака (-Хп и - мана)

        myWarrior.magic_attack();
        myWarrior.feed_mana(350);
        
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