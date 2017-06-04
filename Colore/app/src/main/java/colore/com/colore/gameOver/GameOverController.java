package colore.com.colore.gameOver;

import android.os.Bundle;
import android.support.annotation.NonNull;

import colore.com.colore.modules.BoardGameManager;
import colore.com.colore.modules.LevelSequence;
import colore.com.colore.modules.MasterModule;

public class GameOverController implements GameOverLayout.GameOverLayoutListener {

    private GameOverActivity mGameOverActivity;
    private GameOverLayout mGameOverLayout;
    private LevelSequence mLevelSequence;
    private BoardGameManager mBoardManager;
    private MasterModule mMasterModule;

    public GameOverController(@NonNull GameOverActivity gameOverActivity) {
        mGameOverActivity = gameOverActivity;
        mGameOverLayout = new GameOverLayout(mGameOverActivity, this);

        mLevelSequence = LevelSequence.initLevelSequence();

        Bundle bundle = mGameOverActivity.getIntent().getExtras();
        String gaveOver = bundle.getString("gameOver");
        int mLevelPoints = bundle.getInt("points");

        mBoardManager = BoardGameManager.getBoardGameManager();
        mMasterModule = MasterModule.getMasterModule(mGameOverActivity);

        mGameOverLayout.setLayout(
                gaveOver,
                mLevelSequence.getLevel(),
                mLevelPoints,
                mMasterModule.getScore());
        mLevelSequence.reset();

    }

    public void onBackPressed() { goHome(); }

    private void goHome() { mGameOverActivity.finish(); }

    @Override
    public void onHomeIconClicked() { goHome(); }
}
