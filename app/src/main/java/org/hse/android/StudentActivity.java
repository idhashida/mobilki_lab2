package org.hse.android;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class StudentActivity extends AppCompatActivity {
    static class Group {
        private Integer id;
        private String name;

        public Group(Integer id, String name) {
            this.id = id;
            this.name = name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        final Spinner spinner = findViewById(R.id.groupList);

        List<Group> groups = new ArrayList<>();
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

    private void initGroupList(List<Group> groups) {
        String[][] hseData = {
                {"ПИ", "22", "1"},
                {"ПИ", "22", "2"},
                {"ПИ", "22", "3"},
                {"ПИ", "22", "4"}
        };

        for (int i = 0; i < hseData.length; i++) {
            String program = hseData[i][0];
            String year = hseData[i][1];
            String groupNumber = hseData[i][2];
            String groupName = String.format("%s-%s-%s", program, year, groupNumber);
            groups.add(new Group(i + 1, groupName));
        }
    }

    private void initTime(TextView time) {
        Date currentTime = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm, E", new Locale("ru", "RU"));
        time.setText(simpleDateFormat.format(currentTime));
    }

    private void initData(TextView status, TextView subject, TextView cabinet, TextView corp, TextView teacher) {
        status.setText("Идет пара");
        subject.setText("Разработка и анализ требований");
        cabinet.setText("504");
        corp.setText("3");
        teacher.setText("Викентьева О.Л.");
    }
}
