package kz.trains.danilov;

public class Locomotive extends RailwayCarriage {
    private int power;
    private String type;
    private int maxSpeed = 100;

    public Locomotive(){
        power = 4000;
        type = "Cargo";
    }

    public Locomotive(String newType, int weight){
        if (newType.equals("Cargo")){
            this.power = weight;
            type = newType;
        } else if(newType.equals("Coach")){
            this.power = weight;
            this.type = newType;
        }else if(newType.equals("Post Car")){
            this.power = weight;
            this.type = newType;
        }else {
            System.out.println("Wrong type of railway carriage");
            System.out.println("Set default");
            this.power = 4000;
            type = "Cargo";
        }
    }
    public Locomotive(String newType){
        if (newType.equals("Cargo")){
            power = 960;
            type = "Cargo";
            System.out.println("Set default");
        } else if(newType.equals("Coach")){
            power = 160;
            type = "Coach";
            System.out.println("Set default");

        }else {
            System.out.println("Wrong type of railway carriage");
            System.out.println("Setting default settings");
        }

    }

    public void setType(String tag){
        this.type = tag;
    }

    public String getType(){
        return type;
    }

    public void setPower( int weight){
        this.power = weight;
    }

    public int getPower(){
        return this.power;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
