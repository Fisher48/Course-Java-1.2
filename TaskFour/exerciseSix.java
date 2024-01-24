/* Задания
4.1. Реализуйте композицию для двух иерархий классов из предыдущего занятия. Напишите код для работы с объектами соответствующих классов, из которого наглядно понятна идея композиции.

4.2. Выберите любую иерархию, в родительском классе сделайте метод, условно, foo(), а в обоих дочерних классах переопределите его. В каждой из трёх реализаций foo() выводите в консоль что-то оригинальное (например, название класса), чтобы можно было различить, для какого класса foo() вызывается.
Создайте массив из 500 объектов, где будут случайно перемешаны 500 объектов двух дочерних классов, и в цикле, не зная где какой объект, вызывайте foo().
Не забывайте, что объекты обычным присваиванием не копируются.
Почему получился такой вывод?

4.3. Придумайте наглядный пример, который демонстрирует, как работает ad hoc полиморфизм. */

package TaskFour;
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
}
    class Hunter extends Person {
        private int endurance;

      Hunter (int h, int a, int s, double d, int e, String n, String w) {
        super(h, a, s, d, n, w);
        this.endurance = e;
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

      Warrior (int h, int a, int s, double d, int f, String n, String w) {
        super(h, a, s, d, n, w);
        this.fury = f;
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

      Dwarf (int h, int a, int s, double d, int m, String n, String w) {
        super(h, a, s, d, n, w);
        this.mana = m;
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
        protected int kind; // 1 - одето, 0 - снято

        Items (String n, int a, int k) {
        this.name = n;
        this.armor = a;
        this.kind = k;
        }

        public void equip(int knd) {
            kind = 0;
        }

        protected void getInfo() {
          System.out.println("Предмет: " + this.name);
          System.out.println("Броня: " + this.armor);
          System.out.println();
        }
    }

        class Head extends Items {
            protected int HP;
            protected int mag_Armor;
            Head (String n, int a, int k, int h, int mA) {
                super(n, a, k);
                this.HP = h;
                this.mag_Armor = mA;
            }

            public void equip(int knd) {
                kind = knd;
                if (kind == 0) {
                  HP = 0;
                  armor = 0;
                  mag_Armor = 0;
                } 
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HP);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }
        
        class Hands extends Items {
            protected int HP;
            protected int mag_Armor;
            Hands (String n, int a, int k, int h, int mA) {
                super(n, a, k);
                this.HP = h;
                this.mag_Armor = mA;
            }

            public void equip(int knd) {
                kind = knd;
                if (kind == 0) {
                  HP = 0;
                  armor = 0;
                  mag_Armor = 0;
                } 
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HP);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }

        class Body extends Items {
            protected int HP;
            protected int mag_Armor;
            Body (String n, int a, int k, int h, int mA) {
                super(n, a, k);
                this.HP = h;
                this.mag_Armor = mA;
            }

            public void equip(int knd) {
                kind = knd;
                if (kind == 0) {
                  HP = 0;
                  armor = 0;
                  mag_Armor = 0;
                } 
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HP);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }

        class Foot extends Items {
            protected int HP;
            protected int mag_Armor;
            Foot (String n, int a, int k, int h, int mA) {
                super(n, a, k);
                this.HP = h;
                this.mag_Armor = mA;
            }

            public void equip(int knd) {
                kind = knd;
                if (kind == 0) {
                  HP = 0;
                  armor = 0;
                  mag_Armor = 0;
                } 
            }

            protected void getInfo() {
              System.out.println("Предмет: " + this.name);
              System.out.println("Броня: " + this.armor);
              System.out.println("Здоровье: " + this.HP);
              System.out.println("Магическая защита: " + this.mag_Armor);
              System.out.println();
            }
        }

  public class exerciseSix {
    public static void main(String[] args) {
        
        Dwarf myDwarf = new Dwarf(500, 20, 15, 120, 350, "Грумер", "Посох");
        Hunter myHunter = new Hunter(600, 25, 20, 150, 150, "Хантер", "Лук");
        Warrior myWarrior = new Warrior(800, 30, 10, 200, 100, "Дуэйн", "Меч");

        Head Helmet = new Head("Шлем", 125, 0, 100, 50);
        Body newBody = new Body("Нагрудник", 100, 0, 50, 30);
        Hands Glooves = new Hands("Перчатки", 120, 0, 90, 70);
        Foot Boots = new Foot("Сапоги", 150, 1, 150, 40);

        Helmet.equip(1);
        newBody.equip(1);
        Glooves.equip(1);
        Boots.equip(1);

        Helmet.getInfo();
        newBody.getInfo();
        Glooves.getInfo();
        Boots.getInfo();


        myDwarf.healing(); // увеличение здоровья эликсиром
        myDwarf.refill(100);  // пополнение маны
        myDwarf.attack(); // атака на персонажа

        myHunter.refill(200); // восполнение выносливости
        myHunter.attack();

        myWarrior.attack();
        myWarrior.refill(350); // восполнение ярости

        myDwarf.getInfo(); // вывод на экран хар-ки персонажа
        myHunter.getInfo();
        myWarrior.getInfo();
    } 
}