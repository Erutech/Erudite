package com.example.erudite;
import java.lang.Math;

public abstract class Eruditechi {

    int[] evolveLvls = {5, 10};
    String specieName, nickname;
    int xp, xpMax, lvl;
    String currEvo, image;

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

    public int getLvl() {
        return lvl;
    }

    public int getXpMax() {
        return xpMax;
    }

    public String getCurrEvo() {
        return currEvo;
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

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public void setCurrEvo(String currEvo) {
        this.currEvo = currEvo;
    }

    public void setImage(String image) {
        this.image = image;
    }

    /** extra functions **/
    public void gainxp(int score) {
        int gainedxp;
        gainedxp = (int) Math.ceil(score/10);
        for(int i = 0; i < gainedxp; i++) {
            xp++;
            if(xpMax == xp) {
                lvlup();
            }
            
        }

    }

    public void lvlup() {
        if(getLvl() <= 11) {
            setLvl(getLvl() + 1);
        }
        setXpMax(getLvl()*5);
        setXp(0);
        for(int i = 0; i < evolveLvls.length; i++) {
            if(evolveLvls[i] == lvl) {
                evolve();
            }
        }
    }

    public abstract void evolve();
    public abstract void updateImage();

}
