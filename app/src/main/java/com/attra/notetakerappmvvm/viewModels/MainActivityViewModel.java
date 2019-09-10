package com.attra.notetakerappmvvm.viewModels;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.Repository.AppRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {
    private AppRepository appRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        appRepository=AppRepository.getInstance();
    }

    public List<NoteEntity> getActiveNotes(){

        return appRepository.getNotes();
    }
}
