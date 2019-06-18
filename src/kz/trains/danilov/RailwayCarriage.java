package kz.trains.danilov;

import java.security.PublicKey;

public class RailwayCarriage {
    private int weight;
    private String type;

    public RailwayCarriage(){
        weight = 4000;
        type = "Cargo";
    }

    public RailwayCarriage(String newType, int weight){
        if (newType.equals("Cargo")){
            this.weight = weight;
            type = newType;
        } else if(newType.equals("Coach")){
            this.weight = weight;
            this.type = newType;
        }else if(newType.equals("Post Car")){
            this.weight = weight;
            this.type = newType;
        }else {
            System.out.println("Wrong type of railway carriage");
            System.out.println("Set default");
            this.weight = 4000;
            type = "Cargo";
        }
    }
    public RailwayCarriage(String newType){
        if (newType.equals("Cargo")){
            weight = 4000;
            type = "Cargo";
            System.out.println("Set default");
        } else if(newType.equals("Coach")){
            weight = 2000;
            type = "Coach";
            System.out.println("Set default");

        }else if(newType.equals("Post Car")){
            weight = 3000;
            type = "Post Car";
            System.out.println("Set default");
        }else {
            System.out.println("Wrong type of railway carriage");
            System.out.println("Setting default settings");
        }

    }

    public void setType(String type){
        this.type = type;
     }

    public String getType(){
        return type;
    }

    public void setWeight( int weight){
        this.weight = weight;
    }

    public int getWeight(){
        return this.weight;
    }
}
