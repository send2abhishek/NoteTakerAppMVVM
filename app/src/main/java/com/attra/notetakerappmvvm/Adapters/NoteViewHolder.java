package com.attra.notetakerappmvvm.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.R;

public class NoteViewHolder extends RecyclerView.ViewHolder {

    private TextView noteText;
    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);

        noteText=itemView.findViewById(R.id.note_view_textview);
    }

    public void populate(final NoteEntity noteEntity, final NoteDataAdapter.ListOnClick click){

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click.onItemClick(noteEntity);
            }
        });

        noteText.setText(noteEntity.getText());
    }
}
