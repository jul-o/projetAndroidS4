package com.example.jul.m4104c_projet2;

import android.widget.Toast;

import com.orm.SugarRecord;

/**
 * Created by jul on 17/03/18.
 */

public class DBQuestionFr extends SugarRecord<DBQuestionFr>{
    String part1;
    String part2;
    String rep;
    String repF1;
    String repF2;

    public static void init(){
        if(listAll(DBQuestionFr.class).size() != 0){
            return;
        }

        DBQuestionFr q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();
        q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();q = new DBQuestionFr("le loup", "le mouton", "mange", "manger", "mangé");
        q.save();
        q = new DBQuestionFr("le lievre", "plus vite que la tortue", "court", "cours", "cour");
        q.save();
    }

    public DBQuestionFr() {
        super();
    }

    public DBQuestionFr(String part1, String part2, String rep, String repF1, String repF2) {
        this.part1 = part1;
        this.part2 = part2;
        this.rep = rep;
        this.repF1 = repF1;
        this.repF2 = repF2;
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
}
