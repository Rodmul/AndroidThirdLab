package com.example.Lab3;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.Lab3.db.Person;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.TasksViewHolder> {

    private Context mCtx;
    private List<Person> personList;
    private RecyclerClickListener clickListener;

    public PersonAdapter(Context mCtx, List<Person> personList, RecyclerClickListener clickListener) {
        this.mCtx = mCtx;
        this.personList = personList;
        this.clickListener = clickListener;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.person_info_item, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Person t = personList.get(position);
        holder.textViewPerson.setText(t.getName());
        holder.textViewCat.setText(t.cat.getName());
        holder.textViewDog.setText(t.dog.getName());

        long uid = personList.get(position).uid;
        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                personList.remove(position);
                notifyItemChanged(position);
                clickListener.onDeleteClick(uid);
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickListener.onEditClick(uid);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    class TasksViewHolder extends RecyclerView.ViewHolder{

        ImageView deleteBtn;
        TextView textViewPerson, textViewCat, textViewDog;

        public TasksViewHolder(View itemView) {
            super(itemView);

            textViewPerson = (TextView) itemView.findViewById(R.id.person_name_textview);
            textViewCat = (TextView) itemView.findViewById(R.id.cat_name_textview);
            textViewDog = (TextView) itemView.findViewById(R.id.dog_name_textview);
            deleteBtn = (ImageView) itemView.findViewById(R.id.delete_person_button);
        }
    }
}
