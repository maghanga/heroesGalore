package models;
import java.util.*;

public class Hero {
    private String name;
    private int age;
    private String power;
    private String weakness;
    private int id;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        instances.add(this);
        this.id = instances.size();
    }

    public String getName(){
        return name;
    }

    public Integer getAge(){
        return age;
    }

    public String getPower(){
        return power;
    }

    public String getWeakness(){
        return weakness;
    }

    public static ArrayList<Hero> getAllHeroes(){
        return instances;
    }
}
