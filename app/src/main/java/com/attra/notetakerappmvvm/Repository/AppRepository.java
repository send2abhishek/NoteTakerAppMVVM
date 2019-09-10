package com.attra.notetakerappmvvm.Repository;

import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.Utils.SampleDataProvider;

import java.util.List;

public class AppRepository {
    private static final AppRepository ourInstance = new AppRepository();
    private List<NoteEntity> noteEntities;

    public static AppRepository getInstance() {
        return ourInstance;
    }

    private AppRepository() {

        noteEntities=SampleDataProvider.getSampleData();
    }

    public List<NoteEntity> getNotes(){

        return noteEntities;
    }
}
