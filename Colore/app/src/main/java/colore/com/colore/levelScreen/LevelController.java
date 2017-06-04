package colore.com.colore.levelScreen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import colore.com.colore.boardGame.BoardActivity;
import colore.com.colore.homeScreen.HomeActivity;
import colore.com.colore.modules.LevelSequence;

public class LevelController implements LevelLayout.LevelLayoutListener {

    private LevelActivity mLevelActivity;
    private LevelLayout mLevelLayout;
    private LevelSequence mLevelSequence;

    private final int BASE_TIME = 5;
    private int mSecondsCountDownForLevel;


    public LevelController(@NonNull LevelActivity levelActivity) {
        mLevelActivity = levelActivity;
        mLevelLayout = new LevelLayout(mLevelActivity, this);
        mLevelSequence = LevelSequence.initLevelSequence();
        mLevelLayout.initListButtons(mLevelSequence.getSequenceColors(), mLevelSequence.getLevel());
        initTimer();
    }

    private void initTimer() {
        if (mLevelSequence.getLevel() <= 2) {
            mSecondsCountDownForLevel = BASE_TIME + (mLevelSequence.getLevel() - 1);
        } else {
            mSecondsCountDownForLevel = BASE_TIME + (mLevelSequence.getLevel() - 1) + log2((double)mLevelSequence.getLevel() - 1) + log2((double) mLevelSequence.getLevel() - 2);
        }
        Log.d("LOG: ", mSecondsCountDownForLevel+ "");
        mLevelLayout.showTime(mSecondsCountDownForLevel);
    }

    private int log2(double num) {
        return (int)(Math.log(num) / Math.log(2));
    }

    @Override
    public void onPlayButtonClicked() {
        Intent intent = new Intent(mLevelActivity, BoardActivity.class);
        mLevelActivity.startActivity(intent);
        mLevelActivity.finish();
    }

    public void onBackPressed() {
        mLevelSequence.reset();
        mLevelActivity.finish();
    }
}
