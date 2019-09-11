package com.attra.notetakerappmvvm.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.attra.notetakerappmvvm.Database.Notes;
import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.Repository.AppRepository;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AppRepository appRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        appRepository=AppRepository.getInstance(application.getApplicationContext());

    }

    public LiveData<List<Notes>> getActiveNotes(){


        //return appRepository.getNotes();



        return appRepository.getNotesFromDatabase();
    }

    public void AddSampleDataToDatabase(){

        appRepository.AddSampleData();

    }


}
