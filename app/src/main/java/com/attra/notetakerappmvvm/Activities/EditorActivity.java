package com.attra.notetakerappmvvm.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.R;

public class EditorActivity extends AppCompatActivity {

    private TextView content;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editor_activity);
        content=findViewById(R.id.activity_editor_textview);
        NoteEntity entity=getIntent().getParcelableExtra("data");
        Log.d("Aryan", "onCreate: "+ entity.getText());

        content.setText(entity.getText());
    }
}
