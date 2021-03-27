package com.example.erudite;

public abstract class Eruditechi {
    int[] evolveLvls = {5, 10};
    String specieName, nickname;
    int xp, xpMax;
    String currEvo, evoStages, image;

    /**
     * getters
     **/
    public String getSpecieName() {
        return specieName;
    }

    public String getNickname() {
        return nickname;
    }

    public int getXp() {
        return xp;
    }

    public int getXpMax() {
        return xpMax;
    }

    public String getCurrEvo() {
        return currEvo;
    }

    public String getEvoStages() {
        return evoStages;
    }

    public String getImage() {
        return image;
    }

    /**
     * setters
     **/
    public void setSpecieName(String specieName) {
        this.specieName = specieName;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setXpMax(int xpMax) {
        this.xpMax = xpMax;
    }

    public void setCurrEvo(String currEvo) {
        this.currEvo = currEvo;
    }

    public void setEvoStages(String evoStages) {
        this.evoStages = evoStages;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /** extra functions **/
    public void gainxp(int score) {
        //TODO: set xp and if reach max, lvlup
    }

    public void lvlup() {
        //TODO: set lvl and if reach evo level, evolve
    }

    public void evolve() {
        //TODO: change curr evo and image
    }

}
