package colore.com.colore.boardGame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import colore.com.colore.gameOver.GameOverActivity;
import colore.com.colore.levelScreen.LevelActivity;
import colore.com.colore.modules.BoardGameManager;
import colore.com.colore.modules.LevelSequence;

public class BoardController
        implements BoardLayout.BoardLayoutListener,
        BoardGameManager.BoardGameManagerListener {

    private BoardActivity mBoardActivity;
    private BoardLayout mBoardLayout;

    private BoardGameManager mBoardGameManager;
    private LevelSequence mLevelSequence;

    public BoardController(BoardActivity boardActivity) {
        mBoardActivity = boardActivity;
        mBoardLayout = new BoardLayout(mBoardActivity, this);
        mBoardGameManager = BoardGameManager.getBoardGameManager();
        mLevelSequence = LevelSequence.initLevelSequence();

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
        if (backgroundColor != "#FFFFFF") {
            button.setBackgroundColor(Color.parseColor("#FFFFFF"));
            button.setTag("#FFFFFF");
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
        mBoardGameManager.reset();
        Intent intent = new Intent(mBoardActivity, GameOverActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("gameOver", value);
        intent.putExtras(bundle);
        mBoardActivity.startActivity(intent);
        mBoardActivity.finish();
    }
}
