package com.attra.notetakerappmvvm.Database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface NotesDAO {


    // Define the actions

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNote(Notes notes);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Notes> notesList);

    @Delete
    void deleteNote(Notes notes);

    @Query("SELECT * FROM notes WHERE id= :id")
    Notes getNoteById(int id);


    @Query("SELECT * FROM notes ORDER by date DESC")
    LiveData<List<Notes>> getNoteAll();

    @Query("SELECT COUNT(*) FROM notes")
    int getNotesCount();

}
