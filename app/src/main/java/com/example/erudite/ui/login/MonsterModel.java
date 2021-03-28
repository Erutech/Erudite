package com.example.erudite.ui.login;

public class MonsterModel {
    private int id;
    private String specie;
    private String nickname;
    private int XP;
    private int Lvl;
    private String eruID;

    // constructor

    public MonsterModel(int id, String specie, String nickname, int XP, int lvl, String eruID) {
        this.id = id;
        this.specie = specie;
        this.nickname = nickname;
        this.XP = XP;
        Lvl = lvl;
        this.eruID = eruID;
    }

    public MonsterModel(){}

    // toString is necessary for printing the contents of a class object


    @Override
    public String toString() {
        return "MonsterModel{" +
                "id=" + id +
                ", specie='" + specie + '\'' +
                ", nickname='" + nickname + '\'' +
                ", XP=" + XP +
                ", Lvl=" + Lvl +
                ", eruID='" + eruID + '\'' +
                '}';
    }

    // getters
    public int getId() { return id; }
    public String getSpecie() { return specie; }
    public String getNickname() { return nickname; }
    public int getXP() { return XP; }
    public int getLvl() { return Lvl; }
    public String getEruID() { return eruID; }

    // setters
    public void setId(int id) { this.id = id; }
    public void setSpecie(String specie) { this.specie = specie; }
    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setXP(int XP) { this.XP = XP; }
    public void setLvl(int lvl) { Lvl = lvl; }
    public void setEruID(String eruID) { this.eruID = eruID; }
}
