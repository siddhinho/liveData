package br.com.roadmaps.livedataexample;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    private ScoreViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        myViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText("" + myViewModel.scoreTeamA.getValue());
    }
}
