package models;

import java.util.*;

public class Squad {
    private int maxSize;
    private String squadName;
    private String cause;
    private int squadId;
    private ArrayList<Hero> squadMembers;
    private static ArrayList<Squad> instances = new ArrayList<>();

    public Squad(int size, String squadName, String cause){
        this.maxSize = size;
        this.squadName = squadName;
        this.cause = cause;
        instances.add(this);
        this.squadMembers = new ArrayList<>();
        this.squadId = instances.size();

    }

    public int getMaxSize(){
        return maxSize;
    }

    public String getSquadName(){
        return squadName;
    }

    public String getCause(){
        return cause;
    }


}
