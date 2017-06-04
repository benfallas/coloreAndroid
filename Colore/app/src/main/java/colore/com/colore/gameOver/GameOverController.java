package colore.com.colore.gameOver;

import android.os.Bundle;
import android.support.annotation.NonNull;

import colore.com.colore.modules.LevelSequence;

public class GameOverController implements GameOverLayout.GameOverLayoutListener {

    private GameOverActivity mGameOverActivity;
    private GameOverLayout mGameOverLayout;
    private LevelSequence mLevelSequence;

    public GameOverController(@NonNull GameOverActivity gameOverActivity) {
        mGameOverActivity = gameOverActivity;
        mGameOverLayout = new GameOverLayout(mGameOverActivity, this);

        mLevelSequence = LevelSequence.initLevelSequence();

        Bundle bundle = mGameOverActivity.getIntent().getExtras();
        String gaveOver = bundle.getString("gameOver");
        mGameOverLayout.setLayout(gaveOver, mLevelSequence.getLevel());

        mLevelSequence.reset();
    }

    public void onBackPressed() { goHome(); }

    private void goHome() { mGameOverActivity.finish(); }

    @Override
    public void onHomeIconClicked() { goHome(); }
}
