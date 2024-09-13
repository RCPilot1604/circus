package circus;

import circus.animal.*;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly"),
            new Tiger("Tai Lung")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateAssetValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    private static void printAllAnimals(ArrayList<Animal> animalArrayList) {
        for (Animal a : animalArrayList) {
            System.out.println(a);
        }
    }

    public static void main(String[] args) {
        System.out.println("Number of animals in the array are: " + animals.length);
        ArrayList<Animal> animalArrayList = new ArrayList<Animal>(Arrays.asList(animals));

        Elephant strongOne = new Elephant("Strong One");
        animalArrayList.add(strongOne);
        animalArrayList.add(new Duck("Andy"));
        animalArrayList.add(new Parrot("John"));

        System.out.println("Size of animal array: " + animalArrayList.size());

        System.out.println("Strong one is in the position: " + animalArrayList.indexOf(strongOne));

        animalArrayList.sort(Animal.AnimalNameComparator);
        System.out.println("Sorted the animals!");
//        makeAnimalsTalk();
//        System.out.println("Total value of animals " + calculateAssetValue(animals));
//        System.out.println("Total value of equipments " + calculateAssetValue(equipments));
        animalArrayList.add(new Tiger("Sherkhan"));

        Duck louie = new Duck("Louie");
        animalArrayList.add(louie);
        animalArrayList.add(strongOne);

        printAllAnimals(animalArrayList);

        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Jerry");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("Papago");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
