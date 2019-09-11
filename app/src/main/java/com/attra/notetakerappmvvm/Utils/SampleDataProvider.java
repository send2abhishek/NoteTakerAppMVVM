package com.attra.notetakerappmvvm.Utils;

import com.attra.notetakerappmvvm.Database.Notes;
import com.attra.notetakerappmvvm.Models.NoteEntity;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SampleDataProvider {

    private static final String SAMPLE_TEXT1="Smaple Data 1";
    private static final String SAMPLE_TEXT2="Smaple Data 2";
    private static final String SAMPLE_TEXT3="This is the big data";


    private static Date getDate(int diff){

        GregorianCalendar calendar=new GregorianCalendar();
        calendar.add(Calendar.MILLISECOND,diff);
        return calendar.getTime();
    }



    public static List<NoteEntity> getSampleData(){

        List<NoteEntity> noteEntities=new ArrayList<>();

        noteEntities.add(new NoteEntity(1,getDate(0),SAMPLE_TEXT1));
        noteEntities.add(new NoteEntity(1,getDate(-1),SAMPLE_TEXT2));
        noteEntities.add(new NoteEntity(1,getDate(-2),SAMPLE_TEXT3));

        return noteEntities;
    }

    public static List<Notes> getSampleDataForDatabase(){

        List<Notes> noteEntities=new ArrayList<>();

        noteEntities.add(new Notes(getDate(0),SAMPLE_TEXT1));
        noteEntities.add(new Notes(getDate(-1),SAMPLE_TEXT2));
        noteEntities.add(new Notes(getDate(-2),SAMPLE_TEXT3));

        return noteEntities;
    }

}
