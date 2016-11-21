package com.example.android.quizapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    //variable to store the no of correct answers
    int totalCorrect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**method to calculate and display the final result
     *
     * @param view
     */
    public void showResult(View view) {

        totalCorrect = 0;
        if (isQ1Correct())
            totalCorrect++;
        if (isQ2Correct())
            totalCorrect++;
        if (isQ3Correct())
            totalCorrect++;
        if (isQ4Correct())
            totalCorrect++;
        if (isQ5Correct())
            totalCorrect++;
        String result   =   getString(R.string.result,totalCorrect);
        Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();

    }


    /**to calculate the output of q1
     *
     * @return
     */
    private boolean isQ1Correct() {

        CheckBox op1 = (CheckBox) findViewById(R.id.option_red);
        CheckBox op2 = (CheckBox) findViewById(R.id.option_blue);
        CheckBox op3 = (CheckBox) findViewById(R.id.option_green);
        CheckBox op4 = (CheckBox) findViewById(R.id.option_yellow);
        if (op1.isChecked() && op2.isChecked() && op3.isChecked() && !op4.isChecked()) {
            return true;
        }

        return false;
    }

    /**to calculate the output of q2
     *
     * @return
     */
    private boolean isQ2Correct() {

        RadioGroup rdoGrp = (RadioGroup) findViewById(R.id.q2);
        int selectedId = rdoGrp.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.option_false_q2:
                return true;
            case R.id.option_true_q2:
                return false;
            default:
                return false;

        }

    }

    /**to calculate the output of q3
     *
     * @return
     */
    private boolean isQ3Correct() {

        EditText editText = (EditText) findViewById(R.id.answer_q3);
        String answer = editText.getEditableText().toString().trim();
        if (answer.equalsIgnoreCase("9")) {
            return true;
        }
        return false;
    }


    /**to calculate the output of q4
     *
     * @return
     */
    private boolean isQ4Correct() {
        RadioGroup rdoGrp = (RadioGroup) findViewById(R.id.q4);
        int selectedId = rdoGrp.getCheckedRadioButtonId();
        switch (selectedId) {
            case R.id.option_false_q4:
                return true;
            case R.id.option_true_q4:
                return false;
            default:
                return false;

        }
    }


    /**to calculate the output of q5
     *
     * @return
     */
    private boolean isQ5Correct() {
        EditText editText = (EditText) findViewById(R.id.answer_q5);
        String answer   = editText.getEditableText().toString().trim();
        if (answer.equalsIgnoreCase("9"))
            return true;
        return false;
    }


}
