package com.example.erudite;

public class Erugon extends Eruditechi {
    // constructor
    Erugon(String nickname) {
        setSpecieName("Erugon");
        setNickname(nickname);
        setXp(0);
        setXpMax(5);
        setCurrEvo("Egg");
        setImage("egg.png");
    }

    Erugon(String nickname, int xp, int xpMax, int lvl, String currEvo) {
        setSpecieName("Erugon");
        setNickname(nickname);
        setXp(xp);
        setXpMax(xpMax);
        setLvl(lvl);
        setCurrEvo(currEvo);
        updateImage();
    }

    @Override
    public void evolve() {
        // TODO: change curr evo and image
        // if Egg, change to Baby Erugon
        if (getCurrEvo().equals("Egg")) {
            setCurrEvo("Baby Erugon");
            updateImage();
        }
        // if Baby Erugon, change to Erugon
        else if (getCurrEvo().equals("Baby Erugon")) {
            setCurrEvo("Erugon");
            updateImage();
        }
    }

    @Override
    public void updateImage() {
        // if Egg, change to Egg
        if (getCurrEvo().equals("Egg")) {
            setImage("egg.png");
        }
        // if Baby Erugon, change to Baby Erugon
        else if (getCurrEvo().equals("Baby Erudon")) {
            setImage("baby_erugon.png");
        }
        // if Erugon, change to Erugon
        else if (getCurrEvo().equals("Erugon")) {
            setImage("erugon.png");
        }

    }
}
