package org.hse.android;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Button tableStudentsButton = findViewById(R.id.tableStudents);
        Button tableTeacherButton = findViewById(R.id.tableTeacher);

        tableStudentsButton.setOnClickListener(v -> getStudentsTimetable());

        tableTeacherButton.setOnClickListener(v -> getTeacherTimetable());
    }

    private void getStudentsTimetable() {
        Toast.makeText(BaseActivity.this, R.string.get_table_stud, Toast.LENGTH_SHORT).show();
    }

    private void getTeacherTimetable() {
        Toast.makeText(BaseActivity.this, R.string.get_table_teach, Toast.LENGTH_SHORT).show();
    }
}
