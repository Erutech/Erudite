package com.example.erudite;

public class Erugon extends Eruditechi {
    // constructor
    Erugon(String nickname) {
        setSpecieName("Erugon");
        setNickname(nickname);
        setXp(0);
        setXpMax(5);
        setEvoStages(new String[]{"Egg", "Baby Erugon", "Erugon"});
        setCurrEvo("Egg");
        setImage("egg.png");
    }
    Erugon(String nickname, int xp, int xpMax, int lvl, String currEvo) {
        setSpecieName("Erugon");
        setNickname(nickname);
        // TODO: setXp
        // TODO: setXpMax for initial max xp at level
        // TODO:
        setEvoStages(new String[]{"Egg", "Baby Erugon", "Erugon"});
        setCurrEvo("");
        setImage("");
    }
}
