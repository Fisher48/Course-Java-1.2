package TaskFour;
import java.util.Random;
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
      protected void healing() {
        this.HP += 100;
      }

      // потеря ХП 
      protected void loss() {
        this.HP -= 200;
      }
    
      // атака на персонажа
      protected void attack() {
        this.loss();
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

      // Пример ad-hoc полиморфизма
      public int adHoc(int HP, int agility) {
        return HP + agility;
      }
      public String adHoc(String name, String weapon) {
        return name + weapon;
      }
}
    class Hunter extends Person {
        private int endurance;
        private Hands Glooves; // объявлен объект Перчатки класса Hands у класса Hunter
        private Head Helmet;

      Hunter (int h, int a, int s, double d, int e, String n, String w) {
        super(h, a, s, d, n, w);
        this.endurance = e;
        this.Helmet = null;
        this.Glooves = null;
      }

      protected void equip(Hands BigHands, Head Heller) {
          Glooves = BigHands;
          Helmet = Heller;
          if (Glooves != null) {
              HP += Glooves.HPi; // если не пусто, то идет прирост ХП для персонажа
          }
          if (Helmet != null) {
              HP += Helmet.HPi;
          }
      }
        // измененный родительский метод
        protected void attack() {
          this.loss();
          this.endurance -= 100;
        }
        // восстановит выносливость
        protected int refill(int new_endurance) {
            if (new_endurance > endurance) {
                return endurance;
            }
            return this.endurance += new_endurance;
        }
    }

    class Warrior extends Person {
        private int fury;
        private Head Helmet;
        private Foot Boots;

      Warrior (int h, int a, int s, double d, int f, String n, String w) {
        super(h, a, s, d, n, w);
        this.fury = f;
        this.Helmet = null;
        this.Boots = null;
      }

        protected void equip(Head Heller, Foot BootsOfSpeed) {
          Helmet = Heller;
          Boots = BootsOfSpeed;
          if (Helmet != null) {
              HP += Helmet.HPi;
          }
          if (Boots != null) {
              HP += Boots.HPi;
          }
      }
          protected void attack() {
            this.loss();
            this.fury -= 100;
          }   
          // восстановит ярость
          protected int refill(int new_fury) {
              if (new_fury > fury) {
                return fury;
              }
                return this.fury += new_fury;
          } 
    }

    class Dwarf extends Person {
        private int mana;
        private Foot Boots;

      Dwarf (int h, int a, int s, double d, int m, String n, String w) {
        super(h, a, s, d, n, w);
        this.mana = m;
        this.Boots = null;
      }

      protected void equip(Foot BootsOfSpeed) {
          Boots = BootsOfSpeed;
          if (Boots != null) {
              HP += Boots.HPi;
          }
      }
        protected void attack() {
          this.loss();
          this.mana -= 100;
        }

        // эликсир восстановит ману
        protected int refill(int new_mana) {
            if (new_mana > mana) {
                return mana;
            }
            return this.mana += new_mana;
        }
    }

    class Items {
        protected String name; // Название
        protected int armor; // Кол-во брони баллы

        Items (String n, int a) {
            this.name = n;
            this.armor = a;
        }

        protected void getInfo() {
          System.out.println("Предмет: " + this.name);
          System.out.println("Броня: " + this.armor);
          System.out.println();
        }

        protected void foo() {
          System.out.println("Items");
        }
    }

        class Head extends Items {
            protected int HPi;
            protected int mag_Armor;
            Head (String n, int a, int hi, int mA) {
                super(n, a);
                this.HPi = hi;
                this.mag_Armor = mA;
            }

            // метод foo() выводит название Предмета
            protected void foo() {
              System.out.println(this.name);
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HPi);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }
        
        class Hands extends Items {
            protected int HPi;
            protected int mag_Armor;
            Hands (String n, int a, int hi, int mA) {
                super(n, a);
                this.HPi = hi;
                this.mag_Armor = mA;
            }

            protected void foo() {
              System.out.println(this.name);
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HPi);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }

        class Body extends Items {
            protected int HPi;
            protected int mag_Armor;
            Body (String n, int a, int hi, int mA) {
                super(n, a);
                this.HPi = hi;
                this.mag_Armor = mA;
            }

            protected void foo() {
              System.out.println(this.name);
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HPi);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }

        class Foot extends Items {
            protected int HPi;
            protected int mag_Armor;
            Foot (String n, int a, int hi, int mA) {
                super(n, a);
                this.HPi = hi;
                this.mag_Armor = mA;
            }

            protected void foo() {
              System.out.println(this.name);
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HPi);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }

  public class exerciseSix {
    public static void main(String[] args) {
        
        Dwarf myDwarf = new Dwarf(500, 20, 15, 120, 350, "Грумер", "Посох");
        Hunter myHunter = new Hunter(600, 25, 20, 150, 150, "Хантер", "Лук");
        Warrior myWarrior = new Warrior(800, 30, 10, 200, 100, "Дуэйн", "Меч");

        myDwarf.healing(); // увеличение здоровья эликсиром
        myDwarf.refill(100);  // пополнение маны
        myDwarf.attack(); // атака на персонажа

        myHunter.refill(200); // восполнение выносливости
        myHunter.attack();

        myWarrior.attack();
        myWarrior.refill(350); // восполнение ярости

        // Предметы для композиции с персонажем
        Hands BigHands = new Hands("Большие руки", 100, 100, 25);
        Head Heller = new Head("Хеллер", 125, 100, 50);
        Foot BootsOfSpeed = new Foot("Боты скорости", 150, 150, 40);

        myDwarf.equip(BootsOfSpeed); // одеть предмет
        myHunter.equip(BigHands, Heller);
        myWarrior.equip(Heller, BootsOfSpeed);

        myHunter.equip(null,null); // убрать предмет

        myDwarf.getInfo(); // вывод на экран хар-ки персонажа
        myHunter.getInfo();
        myWarrior.getInfo();

        // Объекты для массива
        Hands g1 = new Hands("Наручи", 1, 10, 1);
        Head h1 = new Head("Шляпа", 1, 10, 1);
        Foot f1 = new Foot("Ботинки", 0, 10, 1);
        Body b1 = new Body("Тело", 0, 10, 1);

        // массив из 500 объектов, где случайно перемешаны 500 объектов четырех дочерних классов
        Items [] its = new Items [500];
        Random rand = new Random();
        for (int i = 0; i < its.length; i++) {
          int x = rand.nextInt(4);
          if (x == 0) {
            its[i] = g1;
          } else if (x == 1) {
            its[i] = h1;
          } else if (x == 2) {
            its[i] = f1;
          } else 
            its[i] = b1;

            its[i].foo(); // вызов foo() в цилке
            // Получается что метод понимает автоматически к какому классу относится определенный предмет в массиве и выводит его название
        }

        // Вызов методов ad-hoc полиморфизма
          System.out.println(myHunter.adHoc("10","10"));
          System.out.println(myHunter.adHoc(10, 10));            
    } 
}