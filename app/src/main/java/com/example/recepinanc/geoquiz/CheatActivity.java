package com.example.recepinanc.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Recepinanc on 23.07.2015.
 */
public class CheatActivity extends Activity {


    private static final String TAG = "CheatActivity"; //For log screen categorisation
    public static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true"; //setting your package name as a prefix will distinguish this Key from the others
    public static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";
    public static final String EXTRA_ANSWER_IS_SHOWN = "com.bignerdranch.android.geoquiz.answer_is_shown";


    private boolean mAnswerIsTrue;
    private boolean mShowIsClicked;
    private TextView mAnswerTextView;
    private Button mShowAnswer;


    private void setAnswerShownResult(boolean isAnswerShown)
    {
        Intent data = new Intent(); //created new Intent
        data.putExtra(EXTRA_ANSWER_SHOWN,isAnswerShown); //put the information of answer being shown
        setResult(RESULT_OK,data); //set Result_OK's value to this data intent
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate() called!");
        setContentView(R.layout.activity_cheat);

        if (savedInstanceState == null) {
            // first startup, so the answer must not
            // be shown yet
            Log.i(TAG,"OMG savedInstance is null!");
            setAnswerShownResult(false);
        }else
        {
            Log.i(TAG,"O yes ! savedInstance is not null!");
            setAnswerShownResult(savedInstanceState.getBoolean(EXTRA_ANSWER_IS_SHOWN));
        }

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mShowIsClicked = true;
                setAnswerShownResult(mShowIsClicked);

                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                }

            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putBoolean(EXTRA_ANSWER_SHOWN, mAnswerIsTrue);
        Log.i(TAG,"cheat's answer saved");
        savedInstanceState.putBoolean(EXTRA_ANSWER_IS_SHOWN,mShowIsClicked);
        Log.i(TAG, "isShown state saved");
    }

}
