package colore.com.colore.boardGame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import colore.com.colore.gameOver.GameOverActivity;
import colore.com.colore.levelScreen.LevelActivity;
import colore.com.colore.modules.BoardGameManager;
import colore.com.colore.modules.LevelSequence;
import colore.com.colore.modules.MasterModule;

public class BoardController
        implements BoardLayout.BoardLayoutListener,
        BoardGameManager.BoardGameManagerListener {

    private BoardActivity mBoardActivity;
    private BoardLayout mBoardLayout;

    private BoardGameManager mBoardGameManager;
    private LevelSequence mLevelSequence;
    private MasterModule mMasterModule;

    public BoardController(BoardActivity boardActivity) {
        mBoardActivity = boardActivity;
        mBoardLayout = new BoardLayout(mBoardActivity, this);
        mBoardGameManager = BoardGameManager.getBoardGameManager();
        mLevelSequence = LevelSequence.initLevelSequence();
        mMasterModule = MasterModule.getMasterModule(mBoardActivity);

        mBoardGameManager.initBoardGame(this);

        mBoardLayout.setButtonColors(mBoardGameManager.getBoardColors());
    }

    public void onBackPressed() {
        mBoardGameManager.reset();
        mBoardActivity.finish();
    }

    @Override
    public void onButtonClicked(Button button) {
        String backgroundColor = (String) button.getTag();
        if (backgroundColor != "#303030") {
            button.setBackgroundColor(Color.parseColor("#303030"));
            button.setTag("#303030");
            if (!mBoardGameManager.isTop(backgroundColor)) {
                gameOver("0");
            }
        }
    }

    @Override
    public void onLevelCompleted() {
        mBoardGameManager.increaseLevel();
        if (mLevelSequence.getLevel() < 7) {
            Intent intent = new Intent(mBoardActivity, LevelActivity.class);
            mBoardActivity.startActivity(intent);
            mBoardActivity.finish();
        } else {
            gameOver("1");
        }
    }

    private void gameOver(String value) {
        if (mMasterModule.getScore() < mBoardGameManager.getPoints()) {
            mMasterModule.updateScore(mBoardGameManager.getPoints());
        }

        mBoardGameManager.reset();
        Intent intent = new Intent(mBoardActivity, GameOverActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("gameOver", value);
        bundle.putInt("points", mBoardGameManager.getPoints());
        intent.putExtras(bundle);
        mBoardActivity.startActivity(intent);
        mBoardActivity.finish();
    }
}
