/* Задания
5.1. Разделите видимость полей (сделайте все поля приватными) и методов во всех классах вашей программы.
5.2. Добавьте в каждый класс конструктор.
5.3. Постройте небольшую иерархию классов в вашей программе. */

package TaskTree;
class Person {
    private int HP;
    private int agility;
    private int strenght;
    private double damage;
    private String name;
    private String weapon;
    
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

      protected void getInfo() {
        System.out.println("Имя: " + this.name);
        System.out.println("Оружие: " + this.weapon);
        System.out.println("Здоровье: " + this.HP);
        System.out.println("Ловкость: " + this.agility);
        System.out.println("Сила: " + this.strenght);
        System.out.println("Урон: " + this.damage);
        System.out.println();
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
        protected int getEndurance(int new_endurance) {
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
          protected void getAttack() {
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
        protected void getAttack() {
          this.getLoss();
          this.mana = -100;
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

        myDwarf.getInfo(); // вывод на экран хар-ки персонажа
        myHunter.getInfo();
        myWarrior.getInfo();
    } 
}