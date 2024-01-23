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

        myDwarf.getInfo(); // вывод на экран хар-ки персонажа
        myHunter.getInfo();
        myWarrior.getInfo();
    } 
}