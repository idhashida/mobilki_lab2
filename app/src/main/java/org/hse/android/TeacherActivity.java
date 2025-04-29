package org.hse.android;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class TeacherActivity extends AppCompatActivity  {

    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        final Spinner spinner = findViewById(R.id.groupList);

        List<StudentActivity.Group> groups = new ArrayList<>();
        initGroupList(groups);

        ArrayAdapter<?> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, groups);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View itemSelected, int selectedItemPosition, long selectedId) {
                Object item = adapter.getItem(selectedItemPosition);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        TextView time = findViewById(R.id.time);
        initTime(time);

        TextView status = findViewById(R.id.status);
        TextView subject = findViewById(R.id.subject);
        TextView cabinet = findViewById(R.id.cabinet);
        TextView corp = findViewById(R.id.corp);
        TextView teacher = findViewById(R.id.teacher);

        initData(status, subject, cabinet, corp, teacher);
    }

    private void initGroupList(List<StudentActivity.Group> groups) {
        groups.add(new StudentActivity.Group(1, "Преподаватель 1"));
        groups.add(new StudentActivity.Group(2, "Преподаватель 2"));
        groups.add(new StudentActivity.Group(3, "Преподаватель 3"));
        groups.add(new StudentActivity.Group(4, "Преподаватель 4"));
        groups.add(new StudentActivity.Group(5, "Преподаватель 5"));
    }

    private void initTime(TextView time) {
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        time.setText(simpleDateFormat.format(currentTime));
    }

    private void initData(TextView status, TextView subject, TextView cabinet, TextView corp, TextView teacher) {
        status.setText("Нет пар");
        subject.setText("Дисциплина");
        cabinet.setText("Кабинет");
        corp.setText("Корпус");
        teacher.setText("Преподаватель");
    }
}
