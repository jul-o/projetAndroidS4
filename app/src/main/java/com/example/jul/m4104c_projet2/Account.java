package com.example.jul.m4104c_projet2;

import com.orm.SugarRecord;

/**
 * Created by sangj on 09/03/18.
 */

public class Account extends SugarRecord {
    public static final int AVATAR_LOUTRE_IND = 0;
    public static final int AVATAR_ORNI_IND = 1;
    public static final int AVATAR_CAFARD_IND = 2;

    public static final String AVATARS[] = {"Loutre", "Ornithorynque", "Cafard"};

    private String name;
    private String firstName;
    private String avatar;

    public Account(){

    }

    public Account(String name, String firstName, int avatar){
        this.name = name;
        this.firstName = firstName;
        this.avatar = AVATARS[avatar];
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

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
