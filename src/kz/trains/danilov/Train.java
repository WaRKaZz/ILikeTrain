package kz.trains.danilov;
import java.lang.Math;

import java.util.ArrayList;

public class Train {
    private int totalWeight = 0;
    private int numberOfCars = 8;
    private boolean trainGenerated = false;
    private ArrayList <RailwayCarriage> RailwayCarriages = new ArrayList<>();
    private Locomotive Locomotive = new Locomotive();
    private double acceleration;

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(int numberOfCars) {
        this.numberOfCars = numberOfCars;
    }

    public void trainGenerate() {
        if (trainGenerated){
            System.out.println("Train is already generated");
        } else {
            railwayLocomotiveGenerate("Random");
            railwayCarriageGenerate("Random");
            trainGenerated = true;
            for (int i = 0; i<numberOfCars; i++){
                totalWeight += RailwayCarriages.get(i).getWeight();
            }
            acceleration = (Locomotive.getPower()*1000)/
                    (this.totalWeight);
            System.out.println("Total Number Case: " + numberOfCars);
            System.out.println("Total Weight: " + totalWeight/1000 + " ton's");
            System.out.println("Power of Locomotive: " + Locomotive.getPower() +  " kw");
            System.out.println("Acceleration: " + acceleration + " meter per second");
        }
    }

    public void trainGenerate(String TypeOfTrain) {
        if (trainGenerated){
            System.out.println("Train is already generated");
        } else {
            if(TypeOfTrain.equals("Coach")||TypeOfTrain.equals("Cargo")) {
                railwayLocomotiveGenerate(TypeOfTrain);
                railwayCarriageGenerate(TypeOfTrain);
                trainGenerated = true;
                for (int i = 0; i<numberOfCars; i++){
                    totalWeight += RailwayCarriages.get(i).getWeight();
                }
                acceleration = (Locomotive.getPower()*1000)/
                                 (this.totalWeight);
                System.out.println("Total Number Case: " + numberOfCars);
                System.out.println("Total Weight: " + totalWeight/1000 + " ton's");
                System.out.println("Power of Locomotive: " + Locomotive.getPower() +  " kw");
                System.out.println("Acceleration: " + acceleration + " meter per second");
            }
            else {
                System.out.println("Wrong Type of Train");
            }
        }
    }

    public boolean isReady(){
        boolean returningMessage = trainGenerated;
        if (trainGenerated){
            double speedTimeToMaximum = Locomotive.getMaxSpeed()*3.6/acceleration;
            System.out.println("Speed Time to maximum = " + speedTimeToMaximum);
            if (speedTimeToMaximum<180){                System.out.println("Train is ready");
                returningMessage = true;
            } else {
                System.out.println("Train Overloaded");
                returningMessage = false;
            }
        } else {
            System.out.println("Train Not Configurated");
        }
        return returningMessage;
    }

    public boolean isTypeNormal(){
        boolean returnedIsNormal = true;
        for (int i = 0; i < numberOfCars; i++){
            if (Locomotive.getType().equals("Cargo")){ // Для Грузовых
                if (RailwayCarriages.get(i).getType().equals("Coach")||RailwayCarriages.get(i).getType().equals("Post Car")){
                    returnedIsNormal = false;
                    System.out.println("Worng Type!");
                    break;
                }
            }
            if (Locomotive.getType().equals("Coach")){ // Для пассажирских
                if (RailwayCarriages.get(i).getType().equals("Cargo")){
                    returnedIsNormal = false;
                    System.out.println("Worng Type! " + (i+1) + RailwayCarriages.get(i).getType());
                    break;
                }
            }
        }
        return returnedIsNormal;
    }

    public void runTrain(int distance){  //Запустить поезд
        if (isReady()&&isTypeNormal()){
            System.out.println("Arrival time about: " + distance/Locomotive.getMaxSpeed()*0.8 + " hours");
            System.out.println("Average speed :" + Locomotive.getMaxSpeed()*0.8);
            System.out.println("Cho-Choooo!");
        }
    }

    private void railwayCarriageGenerate(String typeOfCarriages){                               // Generator Carriage
        for (int i = 0; i<numberOfCars; i++){
            int generatedType = 1;
            String generatedStringType = "";
            int generatedWeight = 0;

            switch (typeOfCarriages){            //Какие вагоны генерируются?
                case ("Random"):
                    generatedType = (int) (Math.random()*(4-1)+1);
                    generatedWeight = (int) (Math.random()*(100_000-20_000)+20_000);
                    break;
                case ("Coach"):
                    generatedType = (int) (Math.random()*(4-2)+2);
                    generatedWeight = (int) (Math.random()*(40_000-20_000)+20_000);
                    break;
                case ("Cargo"):
                    generatedType = 1;
                    generatedWeight = (int) (Math.random()*(100_000-40_000)+40_000);
                    break;
            }

            switch (generatedType){             //Как вагоны генерировать?
                case (1):
                    generatedStringType += "Cargo";
                    break;
                case (2):
                    generatedStringType += "Coach";
                    break;
                case (3):
                    generatedStringType += "Post Car";
            }

            RailwayCarriages.add(new RailwayCarriage(generatedStringType, generatedWeight));
            System.out.println("Train Carrage "+ (i+1) + " Type: " + RailwayCarriages.get(i).getType());
        }
    }

    private void railwayLocomotiveGenerate(String typeOfLocomotive){    // Locomotive Generator
        String generatedStringType = "";
        int generatedPower = 0;

        switch (typeOfLocomotive) {            //Which is?
            case ("Random"):
                if (((int) (Math.random() * 2)) == 1) {
                    generatedStringType = "Coach";
                } else {
                    generatedStringType = "Cargo";
                }
                generatedPower = (int) (Math.random() * (20_000 - 1000) + 10000);
                break;
            case ("Coach"):
                generatedStringType = typeOfLocomotive;
                generatedPower = (int) (Math.random() * (5000 - 1000) + 1000);
                break;
            case ("Cargo"):
                generatedStringType = typeOfLocomotive;
                generatedPower = (int) (Math.random() * (20_000 - 5000) + 5000);
                break;
        }
        Locomotive.setPower(generatedPower);
        Locomotive.setType(generatedStringType);
        System.out.println("Locomotive Type: " + Locomotive.getType());
    }
}
