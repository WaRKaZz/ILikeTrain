import kz.trains.danilov.Train;

import java.lang.Math;

public class Main {

    public static void main(String[] args) {
        Train Train1 = new Train();
        Train Train2 = new Train();
        Train Train3 = new Train();

        System.out.println("*********************************");
        System.out.println("Train 1 Random");
        Train1.trainGenerate();
        Train1.runTrain(1000);

        System.out.println("*********************************");
        System.out.println("Train 2 Coach");
        Train2.trainGenerate("Coach");
        Train2.runTrain(1000);

        System.out.println("*********************************");
        System.out.println("Train 2 Coach");
        Train3.setNumberOfCars(64);
        Train3.trainGenerate("Cargo");
        Train3.runTrain(2000);


    }
}
