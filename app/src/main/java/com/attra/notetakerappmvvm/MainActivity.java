package com.attra.notetakerappmvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.attra.notetakerappmvvm.Activities.EditorActivity;
import com.attra.notetakerappmvvm.Adapters.NoteDataAdapter;
import com.attra.notetakerappmvvm.Database.Notes;
import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.viewModels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NoteDataAdapter.ListOnClick, View.OnClickListener {

    private RecyclerView recyclerView;
    private List<NoteEntity> noteEntities;
    private NoteDataAdapter adapter;
    private FloatingActionButton actionButton;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteEntities=new ArrayList<>();

        initViewModel();



        actionButton=findViewById(R.id.add_new_note_fab);
        actionButton.setOnClickListener(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));

    }

    private void initViewModel() {
        recyclerView=findViewById(R.id.activity_main_recylerView);

        Observer<List<Notes>> notesObserver=new Observer<List<Notes>>() {
            @Override
            public void onChanged(@Nullable List<Notes> noteEntities) {
                noteEntities.clear();
                noteEntities.addAll(noteEntities);



                if(adapter==null){
                    adapter=new NoteDataAdapter(MainActivity.this,noteEntities,MainActivity.this);
                    recyclerView.setAdapter(adapter);
                }
                else {
                    adapter.notifyDataSetChanged();
                }

            }
        };



        mainActivityViewModel= ViewModelProviders.of(this)
                .get(MainActivityViewModel.class);

        mainActivityViewModel.getActiveNotes().observe(MainActivity.this,notesObserver);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId=item.getItemId();

        if(itemId==R.id.menu_sample){


            inserSampleData();
            return true;
        }

        else if(itemId==R.id.menu_del){
            noteEntities.clear();
            adapter.notifyDataSetChanged();

            return true;
        }

        return false;
    }

    private void inserSampleData() {

        //noteEntities.addAll(mainActivityViewModel.getActiveNotes());
       // adapter.notifyDataSetChanged();

        mainActivityViewModel.AddSampleDataToDatabase();
    }

    @Override
    public void onItemClick(Notes noteEntity) {

        Toast.makeText(this,""+noteEntity.getText(),Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, EditorActivity.class);

        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        inserSampleData();

       Toast.makeText(this,"Sample Data Inserted",Toast.LENGTH_SHORT).show();
    }
}
