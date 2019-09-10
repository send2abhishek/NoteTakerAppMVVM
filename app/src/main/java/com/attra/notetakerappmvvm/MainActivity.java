package com.attra.notetakerappmvvm;

import android.content.Intent;
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
import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.Utils.SampleDataProvider;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NoteDataAdapter.ListOnClick, View.OnClickListener {

    private RecyclerView recyclerView;
    private List<NoteEntity> noteEntities;
    private NoteDataAdapter adapter;
    private FloatingActionButton actionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        noteEntities=new ArrayList<>();
        recyclerView=findViewById(R.id.activity_main_recylerView);
        actionButton=findViewById(R.id.add_new_note_fab);
        actionButton.setOnClickListener(this);
        adapter=new NoteDataAdapter(this,noteEntities,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
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

        noteEntities.addAll(SampleDataProvider.getSampleData());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onItemClick(NoteEntity noteEntity) {

        Toast.makeText(this,""+noteEntity.getText(),Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this, EditorActivity.class);
        intent.putExtra("data",noteEntity);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

        inserSampleData();

       Toast.makeText(this,"Sample Data Inserted",Toast.LENGTH_SHORT).show();
    }
}
