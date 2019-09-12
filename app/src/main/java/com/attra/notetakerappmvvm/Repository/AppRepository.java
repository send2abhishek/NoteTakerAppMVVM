package com.attra.notetakerappmvvm.Repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;
import android.util.Log;

import com.attra.notetakerappmvvm.Database.Notes;
import com.attra.notetakerappmvvm.Database.NotesDatabase;
import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.Utils.SampleDataProvider;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppRepository {
    private static  AppRepository ourInstance;
    private List<NoteEntity> noteEntities;
    private Executor executor= Executors.newSingleThreadExecutor();
    private NotesDatabase notesDatabase;

    public static AppRepository getInstance(Context context) {

        return ourInstance=new AppRepository(context);
    }

    private AppRepository(Context context) {

        noteEntities=SampleDataProvider.getSampleData();
        notesDatabase=NotesDatabase.getInstance(context);
    }

    public List<NoteEntity> getNotes(){

        return noteEntities;
    }

    public LiveData<List<Notes>> getNotesFromDatabase(){

        return notesDatabase.notesDAO().getNoteAll();
    }

    public void AddSampleData(){
        executor.execute(new Runnable() {
            @Override
            public void run() {
                notesDatabase.notesDAO().insertAll(SampleDataProvider.getSampleDataForDatabase());
                Log.d("Aryan", "run: data inserted");
            }
        });
    }

    public void deleteAllNotes(final Notes note){

        executor.execute(new Runnable() {
            @Override
            public void run() {
                notesDatabase.notesDAO().deleteNote(note);
            }
        });
    }
}
