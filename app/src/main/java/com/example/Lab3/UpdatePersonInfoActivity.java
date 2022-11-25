package com.example.Lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.Lab3.db.Cat;
import com.example.Lab3.db.DatabaseClient;
import com.example.Lab3.db.Dog;
import com.example.Lab3.db.Person;
import com.example.Lab3.db.PersonDao;

import java.util.Random;

public class UpdatePersonInfoActivity extends AppCompatActivity {
    EditText personEditText;
    EditText catEditText;
    EditText dogEditText;
    private boolean isEdited;
    private Person person;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_person_info);
        InitAddPersonButton();
    }

    void LoadData(long uid) {
        class GetPerson extends AsyncTask<Void, Void, Person> {
            @Override
            protected Person doInBackground(Void... voids) {
                Person person = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .personDao()
                        .getPerson(uid);
                return person;
            }

            @Override
            protected void onPostExecute(Person person) {
                super.onPostExecute(person);
                UpdatePersonInfoActivity.this.person = person;
                personEditText.setText(person.getName());
                catEditText.setText(person.cat.getName());
                dogEditText.setText(person.dog.getName());
            }
        }

        GetPerson getPerson = new GetPerson();
        getPerson.execute();
    }

    @Override
    protected void onResume() {
        super.onResume();
        long uid = getIntent().getLongExtra(MainActivity.INTENT_KEY, -1);
        if (uid != -1) {
            isEdited = true;
            LoadData(uid);
        }
    }


    void InitAddPersonButton() {
        personEditText = (EditText) findViewById(R.id.person_name_edit_text);
        catEditText = (EditText) findViewById(R.id.cat_edit_text);
        dogEditText = (EditText) findViewById(R.id.dog_edit_text);
        Button addPersonButton = (Button) findViewById(R.id.save_button);

        addPersonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!personEditText.getText().toString().isEmpty()
                        && !catEditText.getText().toString().isEmpty() && !dogEditText.getText().toString().isEmpty()) {
                    if (isEdited){
                        OnEditSaveToDatabase();
                    } else {
                        LoadDataToDatabase();
                    }
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    void LoadDataToDatabase() {
        class GetPerson extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                Random random = new Random();
                long ownerUid = random.nextLong();

                PersonDao personDao = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .personDao();
                personDao.insert(new Person(personEditText.getText().toString(), ownerUid));
                personDao.insertCat(new Cat(random.nextLong(), catEditText.getText().toString()
                                    ,ownerUid));
                personDao.insertDog(new Dog(random.nextLong(), dogEditText.getText().toString()
                                    ,ownerUid));
                return null;
            }
        }
        GetPerson getPerson = new GetPerson();
        getPerson.execute();
    }

    void OnEditSaveToDatabase() {
        class EditPerson extends AsyncTask<Void, Void, Void> {
            @Override
            protected Void doInBackground(Void... voids) {
                Random random = new Random();
                long ownerUid = random.nextLong();

                PersonDao personDao = DatabaseClient
                        .getInstance(getApplicationContext())
                        .getAppDatabase()
                        .personDao();
                Person editPerson = UpdatePersonInfoActivity.this.person;
                editPerson.setName(personEditText.getText().toString());
                editPerson.cat.setName(catEditText.getText().toString());
                editPerson.dog.setName(dogEditText.getText().toString());
                personDao.insert(editPerson);
                return null;
            }
        }
        EditPerson ep = new EditPerson();
        ep.execute();
    }
}
