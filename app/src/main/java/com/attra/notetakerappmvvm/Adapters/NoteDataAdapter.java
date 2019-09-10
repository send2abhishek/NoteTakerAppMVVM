package com.attra.notetakerappmvvm.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.attra.notetakerappmvvm.Models.NoteEntity;
import com.attra.notetakerappmvvm.R;

import java.util.List;

public class NoteDataAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    private List<NoteEntity> entityList;
    private Context context;
    private LayoutInflater layoutInflater;
    private ListOnClick listOnClick;

    public NoteDataAdapter(Context context,List<NoteEntity> entityList,ListOnClick listOnClick) {
        this.entityList = entityList;
        this.context = context;
        layoutInflater=layoutInflater.from(context);
        this.listOnClick=listOnClick;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View layoutView=layoutInflater.inflate(R.layout.note_view_layout,viewGroup,false);
        return new NoteViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder noteViewHolder, int pos) {

        NoteEntity entity=entityList.get(pos);

        noteViewHolder.populate(entity,listOnClick);
    }

    @Override
    public int getItemCount() {
        return entityList.size();
    }

    public interface ListOnClick{

        void onItemClick(NoteEntity noteEntity);
    }
}
