package com.example.Lab3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.Lab3.db.DatabaseClient;
import com.example.Lab3.db.Person;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerClickListener {
    private Button buttonAddTask;
    private RecyclerView recyclerView;
    public static final String INTENT_KEY = "INTENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.person_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        buttonAddTask = (Button) findViewById(R.id.add_person_button);
        buttonAddTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UpdatePersonInfoActivity.class);
                startActivity(intent);
            }
        });

        getPersonList();
    }


    private void getPersonList() {
        class GetPersons extends AsyncTask<Void, Void, List<Person>> {

            @Override
            protected List<Person> doInBackground(Void... voids) {
                List<Person> personList = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .personDao()
                        .getAll();
                return personList;
            }

            @Override
            protected void onPostExecute(List<Person> persons) {
                super.onPostExecute(persons);
                PersonAdapter adapter = new PersonAdapter(MainActivity.this, persons, MainActivity.this);
                recyclerView.setAdapter(adapter);
                for (int i = 0; i < persons.size(); i++) {
                    updatePerson(persons.get(i));
                }
            }
        }
        GetPersons gt = new GetPersons();
        gt.execute();
    }

    private void updatePerson(Person person) {
        class UpdatePerson extends AsyncTask<Void, Void, Void> {

            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(getApplicationContext())
                        .getAppDatabase()
                        .personDao()
                        .insert(person);
                return null;
            }
        }
        UpdatePerson upd = new UpdatePerson();
        upd.execute();
    }

    @Override
    public void onDeleteClick(long uid) {
        class DeletePerson extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                DatabaseClient.getInstance(getApplicationContext())
                        .getAppDatabase()
                        .personDao()
                        .delete(uid);
                return null;
            }
        }

        DeletePerson deletePerson = new DeletePerson();
        deletePerson.execute();
    }

    @Override
    public void onEditClick(long uid) {
        Intent intent = new Intent(this, UpdatePersonInfoActivity.class);
        intent.putExtra(MainActivity.INTENT_KEY, uid);

        startActivity(intent);
    }
}