package com.example.recepinanc.geoquiz;

import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends ActionBarActivity {

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;
    private TextView mQuestionTextView;
    /**
     * Created an array that consists of the newly created objects/instances of TrueFalse Class.
     */
    private TrueFalse[] mQuestionBank = new TrueFalse[]
            {
                    new TrueFalse(R.string.question_oceans, true), //R.string.question_blabla is used in order to be able to pass questions from the string.xml file as in id format.
                    new TrueFalse(R.string.question_mideast, false),
                    new TrueFalse(R.string.question_africa, false),
                    new TrueFalse(R.string.question_americas, true),
                    new TrueFalse(R.string.question_asia, true),
            };

    private int mCurrentIndex = 0;

    private void updateQuestion()
    {
        int question = mQuestionBank[mCurrentIndex].getQuestion(); //found the current question's string id
        mQuestionTextView.setText(question); //passed the id as a parameter to set its text to TextView
    }

    private void checkAnswer(boolean userPressedTrue) {
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isTrueQuestion(); //gets the real answer
        int messageResId = 0; //result message id
        if (userPressedTrue == answerIsTrue) {
            messageResId = R.string.correct_toast;
        } else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        updateQuestion();

        mQuestionTextView = (TextView)findViewById(R.id.question_text_view); //get a reference for textView from its id

        mTrueButton = (Button)findViewById(R.id.true_button);
        mFalseButton = (Button)findViewById(R.id.false_button);
        mNextButton = (Button)findViewById(R.id.next_button);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                checkAnswer(true); //assign user's answer as True
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)%mQuestionBank.length; //increment the current index by one and prevent it from boundException
            }
        });


        updateQuestion();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
