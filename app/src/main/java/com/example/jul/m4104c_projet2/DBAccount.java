package com.example.jul.m4104c_projet2;

import com.orm.SugarRecord;

/**
 * Created by sangj on 09/03/18.
 */

public class DBAccount extends SugarRecord {
    public static final int AVATAR_LOUTRE_IND = 0;
    public static final int AVATAR_ORNI_IND = 1;
    public static final int AVATAR_CAFARD_IND = 2;


    public enum AVATARS{
        LOUTRE,
        ORNITHORYNQUE,
        VACHE
    }
    public static DBAccount currentAccount = null;
    private String name;
    private String firstName;
    private int avatar;
    private int score;


    public DBAccount() {
        name = "";
        firstName = "";
        avatar = AVATARS.LOUTRE.ordinal();
        score = 0;
    }

    public DBAccount(String name, String firstName, AVATARS avatar) {
        this.name = name;
        this.firstName = firstName;
        this.avatar = avatar.ordinal();
        score = 0;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public AVATARS getAvatar() {
        return AVATARS.values()[avatar];
    }

    public void setAvatar(AVATARS avatar) {
        this.avatar = avatar.ordinal();
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
