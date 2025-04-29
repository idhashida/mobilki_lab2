package org.hse.android;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        Button buttonStudent = findViewById(R.id.tableStudents);
        Button buttonTeacher = findViewById(R.id.tableTeacher);

        buttonStudent.setOnClickListener(v -> showStudent());

        buttonTeacher.setOnClickListener(v -> showTeacher());
    }

    private void showStudent() {
        Intent intent = new Intent(BaseActivity.this, StudentActivity.class);
        startActivity(intent);
    }

    private void showTeacher() {
        Intent intent = new Intent(BaseActivity.this, TeacherActivity.class);
        startActivity(intent);
    }
}
