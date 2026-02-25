// Inheritance in Java

// constructor definition //

/* constructor is used to initialize data members of the class */

public class Inheritance {
    public static void main(String[] args) {
        Dog mark = new Dog("Mark");
        mark.bark();
        mark.eat();

        Puppy tommy = new Puppy("Tommy");
        tommy.weep();
        tommy.bark();
        tommy.eat();

        Cat kitty = new Cat("milk");
        kitty.meows();
        kitty.eat();
    }
}

class Animal {
    String FoodType;

    Animal(String FoodType) {
        System.out.println("Animal constructor called");
        this.FoodType = FoodType;
    }

    void eat() {
        System.out.println("This animal eats " + FoodType);
    }
}

class Dog extends Animal {
    String name;

    Dog(String name) {
        super("omnivores");
        this.name = name;
        System.out.println("Dog constructor called for " + name);
    }

    void bark() {
        System.out.println(name + " barks");
    }
}

class Puppy extends Dog {
    Puppy(String name) {
        super(name);
        System.out.println("Puppy constructor called for " + name);
    }

    void weep() {
        System.out.println(name + " (puppy) weeps");
    }
}

class Cat extends Animal {
    Cat(String foodType) {
        super(foodType);
        System.out.println("Cat constructor called");
    }

    void meows() {
        System.out.println("Cat meows");
    }
}

// public class Inheritance {
//     public static void main(String[] args) {
//         Dog mark=new Dog();
//         mark.bark();
//         mark.eat();
//     }
// }
// // class Animal{

// // }
// class Animal{
//     String FoodType;
//     Animal(String FoodType)
//     {
//         System.out.println("base class constructor");
//         this.FoodType=FoodType;
//     }
// //     Animal(){
// //         System.out.println("base class construvtor");
// //     }
// //         void eat()
// //     {
// //         System.out.println("this animal eats");
// //     }
// }
// class Dog extends Animal{
//     String name;
//     // void bark()
//     // {
//     //     System.out.println("dog barks");
//     // }

//       Dog(String name)
//        {
//         super("omnivores");
//        this.name=name;
//        System.out.println("derived class constructor");
//         }
// }
// class Puppy extends Dog{
//     void weep()
//     {
//         System.out.println("puppy weeps");
//     }
// }
// class Cat extends Animal{
//     void meows()
//     {
//         System.out.println("cat meows");
//     }
// }