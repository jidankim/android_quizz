package com.example.android.quizzicle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showq2(View view) {
        LinearLayout q2Question = (LinearLayout) findViewById(R.id.q2_question);
        RadioGroup q2Choices = (RadioGroup) findViewById(R.id.q2_choices);
        q2Question.setVisibility(View.VISIBLE);
        q2Choices.setVisibility(View.VISIBLE);
    }

    public void showq3(View view) {
        LinearLayout q3Question = (LinearLayout) findViewById(R.id.q3_question);
        LinearLayout q3Choices = (LinearLayout) findViewById(R.id.q3_choices);
        q3Question.setVisibility(View.VISIBLE);
        q3Choices.setVisibility(View.VISIBLE);
    }

    public void showq4(View view) {
        LinearLayout q4Question = (LinearLayout) findViewById(R.id.q4_question);
        RadioGroup q4Choices = (RadioGroup) findViewById(R.id.q4_choices);
        q4Question.setVisibility(View.VISIBLE);
        q4Choices.setVisibility(View.VISIBLE);
    }

    public void showq5(View view) {
        LinearLayout q5Question = (LinearLayout) findViewById(R.id.q5_question);
        EditText q5Choices = (EditText) findViewById(R.id.q5_entry);
        q5Question.setVisibility(View.VISIBLE);
        q5Choices.setVisibility(View.VISIBLE);
    }

    public void checkAnswer(View view) {
        int numCorrect = 0;

        RadioGroup q1Choices = (RadioGroup) findViewById(R.id.q1_choices);
        if (q1Choices.getCheckedRadioButtonId() == R.id.q1_answer) {
            numCorrect += 1;
        }

        RadioGroup q2Choices = (RadioGroup) findViewById(R.id.q2_choices);
        if (q2Choices.getCheckedRadioButtonId() == R.id.q2_answer) {
            numCorrect += 1;
        }

        CheckBox q3Answer1 = (CheckBox) findViewById(R.id.q3_answer1);
        CheckBox q3Answer2 = (CheckBox) findViewById(R.id.q3_answer2);
        CheckBox q3Choice1 = (CheckBox) findViewById(R.id.q3_choice1);
        CheckBox q3Choice2 = (CheckBox) findViewById(R.id.q3_choice2);
        CheckBox q3Choice3 = (CheckBox) findViewById(R.id.q3_choice3);
        CheckBox q3Choice4 = (CheckBox) findViewById(R.id.q3_choice4);
        if (q3Answer1.isChecked() && q3Answer2.isChecked() && !q3Choice1.isChecked()
                && !q3Choice2.isChecked() && !q3Choice3.isChecked() && !q3Choice4.isChecked()) {
            numCorrect += 1;
        }

        RadioGroup q4Choices = (RadioGroup) findViewById(R.id.q4_choices);
        if (q4Choices.getCheckedRadioButtonId() == R.id.q4_answer) {
            numCorrect += 1;
        }

        EditText q5Entry = (EditText) findViewById(R.id.q5_entry);
        String input = q5Entry.getText().toString().trim().toLowerCase();
        if (input.equals("mach") || input.equals("mach number")) {
            numCorrect += 1;
        }

        Log.v("MainActivity", "I got this much " + numCorrect);

        if (numCorrect == 5) {
            Toast.makeText(this, "You got all " + numCorrect + " questions right!", Toast.LENGTH_SHORT).show();
        } else if (numCorrect >= 3) {
            Toast.makeText(this, "You passed! You got " + numCorrect + " questions right.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Study more physics please! You got " + numCorrect + " questions right.", Toast.LENGTH_SHORT).show();
        }
    }
}
