package com.example.hozoor;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class class_adaptor extends RecyclerView.Adapter<class_adaptor.classViewHolder>{

    private  Context mcontext;

    private  Cursor mcusror;

    public class_adaptor(Context mcontext, Cursor mcusror) {
        this.mcontext = mcontext;
        this.mcusror = mcusror;
    }
  public class classViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
      public classViewHolder(@NonNull View itemView) {
          super(itemView);
          name=itemView.findViewById(R.id.txt_name);
      }


  }
    @NonNull
    @Override
    public classViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mcontext);
        View view=inflater.inflate(R.layout.items,parent,false);

        return new classViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull class_adaptor.classViewHolder holder, int position) {
    if (!mcusror.moveToPosition(position)){
        return;
    }
        String name=mcusror.getString(mcusror.getColumnIndex(Database.COLUMN_NAME));

        holder.name.setText(String.valueOf(name));

    }

    @Override
    public int getItemCount() {

        return mcusror.getCount();
    }
    public void swapcursor(Cursor newCursor){
        if (mcusror !=null){
            mcusror.close();
        }
        mcusror=newCursor;
        if (newCursor !=null){
            notifyDataSetChanged();
        }
    }

}
