package br.com.roadmaps.livedataexample;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private ScoreViewModel myViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        final Observer<Integer> scoreAObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                TextView textView = (TextView) findViewById(R.id.scoreTeamATextView);
                textView.setText("" + integer);
            }
        };

        final Observer<Integer> scoreBObserver = new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                TextView textView = (TextView) findViewById(R.id.scoreTeamBTextView);
                textView.setText("" + integer);
            }
        };

        myViewModel.scoreTeamA.observe(this, scoreAObserver);
        myViewModel.scoreTeamB.observe(this, scoreBObserver);



        Button button3 = (Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity.this, Main2Activity.class );
//                startActivity(intent);

                myViewModel.scoreTeamB.setValue(0);
                myViewModel.scoreTeamA.setValue(0);
            }

        });


    }


    public void addOneForTeamB(View view) {
        myViewModel.scoreTeamB.setValue(myViewModel.scoreTeamB.getValue() + 1);
    }


    public void addOneForTeam(View view) {
        myViewModel.scoreTeamA.setValue(myViewModel.scoreTeamA.getValue() + 1);
    }
}
