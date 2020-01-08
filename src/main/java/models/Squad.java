package models;

import java.util.*;

public class Squad {
    private int maxSize;
    private String squadName;
    private String cause;
    private int squadId;
    private ArrayList<Hero> squadMembers;
    private static ArrayList<Squad> instances = new ArrayList<>();
    private int currentSize;

    public Squad(Integer maxSize, String squadName, String cause) {
        this.maxSize = maxSize;
        this.squadName = squadName;
        this.cause = cause;
        instances.add(this);
        this.squadMembers = new ArrayList<>();
        this.squadId = instances.size();
        this.currentSize = 0;

    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getSquadName() {
        return squadName;
    }

    public String getCause() {
        return cause;
    }

    public static Squad getBySquadId(int squadId) {
        return instances.get(squadId - 1);
    }

    public int getSquadId() {
        return squadId;
    }

    public static ArrayList<Squad> getInstances() {
        return instances;
    }


    public ArrayList<Hero> getSquadMembers() {
        return squadMembers;
    }

    public void addSquadMembers(Hero newMember){
        squadMembers.add(newMember);
        currentSize++;
    }

    public void clearAllSquadMembers(){
            getSquadMembers().clear();
        }

    public static void setUpNewSquad(){
        new Squad(3, "Yellow", "Positivity");
    }

    public static void setUpNewSquad1(){
        new Squad(5, "Red", "Danger");
    }


}
