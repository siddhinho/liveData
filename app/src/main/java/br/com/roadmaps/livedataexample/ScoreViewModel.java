package br.com.roadmaps.livedataexample;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

/**
 * Created by sidd on 06/04/18.
 */

public class ScoreViewModel extends ViewModel {
    // Tracks the score for Team B
    public MutableLiveData<Integer> scoreTeamA;
    public MutableLiveData<Integer> scoreTeamB;

    public ScoreViewModel() {
        this.scoreTeamA =  new MutableLiveData<Integer>();
        this.scoreTeamB = new MutableLiveData<Integer>();
        this.scoreTeamA.setValue(0);
        this.scoreTeamB.setValue(0);
    }
}
