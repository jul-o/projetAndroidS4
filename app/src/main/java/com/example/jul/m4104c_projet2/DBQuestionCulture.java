package com.example.jul.m4104c_projet2;

import com.orm.SugarRecord;

/**
 * Created by jul on 17/03/18.
 */

public class DBQuestionCulture extends SugarRecord<DBQuestionCulture>{
    public enum TAGS{
        HIST,
        FR
    }

    String part1;
    String part2;
    String rep;
    String repF1;
    String repF2;
    TAGS tag;

    //todo : json
    public static void init(){
        if(listAll(DBQuestionCulture.class).size() != 0){
            return;
        }

        DBQuestionCulture q = new DBQuestionCulture("le loup", "le mouton", "mange", "manger", "mangé", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("le lievre", "plus vite que la tortue", "court", "cours", "cour", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("hiémal", " : ", "hivernal", "j'ai mal", "figure de style", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("hyalin", " : ", "transparent", "style de musique ancien", "la réponse D", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("", "t'es papaoutai", "où", "ou", "houx", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("je vais au", " : ", "Mekke Deunold's", "Macdo", "Mac Donald's", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("j' ", "pas d'idées de question", "ai", "ais", "ait", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("Jarno est", " : ", "isotherme", "gentil", "serviable", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("il faudrait que tu ne", "pas malade", "tombes", "tombe", "tombasse", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("Panzani", " : ", "aussi", "au ski", "est une marque de pâtes", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("le loup", "le mouton", "mange", "manger", "mangé", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("le lievre", "plus vite que la tortue", "court", "cours", "cour", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("hiémal", " : ", "hivernal", "j'ai mal", "figure de style", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("hyalin", " : ", "transparent", "style de musique ancien", "la réponse D", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("", "t'es papaoutai", "où", "ou", "houx", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("je vais au", " : ", "Mekke Deunold's", "Macdo", "Mac Donald's", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("j' ", "pas d'idées de question", "ai", "ais", "ait", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("Jarno est", " : ", "isotherme", "gentil", "serviable", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("il faudrait que tu ne", "pas malade", "tombes", "tombe", "tombasse", TAGS.FR);
        q.save();
        q = new DBQuestionCulture("Panzani", " : ", "aussi", "au ski", "est une marque de pâtes", TAGS.FR);
        q.save();




        q = new DBQuestionCulture("Napoléon est :", " ", "Français", "Allemand", "Américano-Moldave", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Prise de la Bastille :", " ", "événement de la révolution", "prise de 220 volts", "prise de Kung-Fu", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Date de la découverte de l'amérique :", " ", "1492", "2015", "-529", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Leader allemand de la\n" +
                "seconde guerre mondiale :", " ", "Hitler", "Staline", "Sarkozy", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jules-", "", "César", "Le-SANG", "L'OVNI", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jeanne d'Arc :", " ", "Guerre de cent ans", "révolution", "chanteuse de métal médiéval", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Napoléon est :", " ", "Français", "Allemand", "Américano-Moldave", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Prise de la Bastille :", " ", "événement de la révolution", "prise de 220 volts", "prise de Kung-Fu", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Date de la découverte de l'amérique :", " ", "1492", "2015", "-529", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Leader allemand de la\n" +
                "seconde guerre mondiale :", " ", "Hitler", "Staline", "Sarkozy", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jules-", "", "César", "Le-SANG", "L'OVNI", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jeanne d'Arc :", " ", "Guerre de cent ans", "révolution", "chanteuse de métal médiéval", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Napoléon est :", " ", "Français", "Allemand", "Américano-Moldave", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Prise de la Bastille :", " ", "événement de la révolution", "prise de 220 volts", "prise de Kung-Fu", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Date de la découverte de l'amérique :", " ", "1492", "2015", "-529", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Leader allemand de la\n" +
                "seconde guerre mondiale :", " ", "Hitler", "Staline", "Sarkozy", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jules-", "", "César", "Le-SANG", "L'OVNI", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jeanne d'Arc :", " ", "Guerre de cent ans", "révolution", "chanteuse de métal médiéval", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Napoléon est :", " ", "Français", "Allemand", "Américano-Moldave", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Prise de la Bastille :", " ", "événement de la révolution", "prise de 220 volts", "prise de Kung-Fu", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Date de la découverte de l'amérique :", " ", "1492", "2015", "-529", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Leader allemand de la\n" +
                "seconde guerre mondiale :", " ", "Hitler", "Staline", "Sarkozy", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jules-", "", "César", "Le-SANG", "L'OVNI", TAGS.HIST);
        q.save();
        q = new DBQuestionCulture("Jeanne d'Arc :", " ", "Guerre de cent ans", "révolution", "chanteuse de métal médiéval", TAGS.HIST);
        q.save();

    }

    public DBQuestionCulture() {
        super();
    }

    public DBQuestionCulture(String part1, String part2, String rep, String repF1, String repF2, TAGS tag) {
        this.part1 = part1;
        this.part2 = part2;
        this.rep = rep;
        this.repF1 = repF1;
        this.repF2 = repF2;
        this.tag = tag;
    }

    public String getPart1() {
        return part1;
    }

    public void setPart1(String part1) {
        this.part1 = part1;
    }

    public String getPart2() {
        return part2;
    }

    public void setPart2(String part2) {
        this.part2 = part2;
    }

    public String getRep() {
        return rep;
    }

    public void setRep(String rep) {
        this.rep = rep;
    }

    public String getRepF1() {
        return repF1;
    }

    public void setRepF1(String repF1) {
        this.repF1 = repF1;
    }

    public String getRepF2() {
        return repF2;
    }

    public void setRepF2(String repF2) {
        this.repF2 = repF2;
    }

    public TAGS getTag() {
        return tag;
    }

    public void setTag(TAGS tag) {
        this.tag = tag;
    }
}
