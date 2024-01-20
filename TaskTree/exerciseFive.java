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
    protected String name;
    protected String weapon;
    
    Person (int h, int a, int s, double d, String n, String w) {
        this.HP = h;
        this.agility = a;
        this.strenght = s;
        this.damage = d;
        this.name = n;
        this.weapon = w;
    }
    
      // эликсир увеличит ХП 
      protected void getHealing() {
        this.HP += 100;
      }

      // потеря ХП 
      protected void getLoss() {
        this.HP -= 200;
      }
    
      // атака на персонажа - ХП и мана
      protected void getAttack() {
        this.getLoss();
      }
}
    class Hunter extends Person {
        private int endurance;

      Hunter (int h, int a, int s, double d, int e, String n, String w) {
        super(h, a, s, d, n, w);
        this.endurance = e;
      }
        protected void getAttack() {
          this.getLoss();
          this.endurance = -100;
        }
        // восстановит выносливость
        public int getEndurance(int new_endurance) {
            if (new_endurance > endurance) {
              return endurance;
            }
              return this.endurance += new_endurance;
        }
    }

    class Warrior extends Person {
        private int fury;

      Warrior (int h, int a, int s, double d, int f, String n, String w) {
        super(h, a, s, d, n, w);
        this.fury = f;
     }
          protected void attack() {
            this.getLoss();
            this.fury = -100;
      }   
          // восстановит ярость
          public int getFury(int new_fury) {
              if (new_fury > fury) {
                return fury;
              }
                return this.fury += new_fury;
          } 
    }

    class Dwarf extends Person {
        private int mana;

      Dwarf (int h, int a, int s, double d, int m, String n, String w) {
        super(h, a, s, d, n, w);
        this.mana = m;
    }

        // эликсир восстановит ману
        public int getMana(int new_mana) {
            if (new_mana > mana) {
              return mana;
            }
              return this.mana += new_mana;
        }
}

  public class exerciseFive {
    public static void main(String[] args) {
        
        Dwarf myDwarf = new Dwarf(500, 20, 15, 120, 350, "Грумер", "Посох");
        Hunter myHunter = new Hunter(600, 25, 20, 150, 150, "Хантер", "Лук");
        Warrior myWarrior = new Warrior(800, 30, 10, 200, 100, "Дуэйн", "Меч");

        myDwarf.getHealing(); // увеличение здоровья эликсиром
        myDwarf.getMana(100);  // пополнение маны
        myDwarf.getAttack(); 

        myHunter.getEndurance(200); // восполнение выносливости
        myHunter.getAttack();

        myWarrior.getAttack();
        myWarrior.getFury(350);
        
        System.out.println("Характеристики Дварфа");
          System.out.println("Здоровье: " + myDwarf.HP);
          System.out.println("Ловкость: " + myDwarf.agility);
          System.out.println("Сила: " + myDwarf.strenght);
          System.out.println("Оружие: " + myDwarf.weapon);
          System.out.println("Урон: " + myDwarf.damage);
          System.out.println();

        System.out.println("Характеристики Охотника");
          System.out.println("Здоровье: " + myHunter.HP);
          System.out.println("Ловкость: " + myHunter.agility);
          System.out.println("Сила: " + myHunter.strenght);
          System.out.println("Оружие: " + myHunter.weapon);
          System.out.println("Урон: " + myHunter.damage);
          System.out.println();

        System.out.println("Характеристики Воина");
          System.out.println("Здоровье: " + myWarrior.HP);
          System.out.println("Ловкость: " + myWarrior.agility);
          System.out.println("Сила: " + myWarrior.strenght);
          System.out.println("Оружие: " + myWarrior.weapon);
          System.out.println("Урон: " + myWarrior.damage);
          System.out.println();
    } 
}