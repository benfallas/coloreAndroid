package colore.com.colore.boardGame;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import colore.com.colore.gameOver.GameOverActivity;
import colore.com.colore.homeScreen.HomeActivity;
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
        mBoardGameManager = BoardGameManager.getBoardGameManager(this);
        mLevelSequence = LevelSequence.initLevelSequence();

        mBoardGameManager.initBoardGame();

        mBoardLayout.setButtonColors(mBoardGameManager.getBoardColors());
    }

    public void onBackPressed() {
        mBoardGameManager.reset();
        Intent intent = new Intent(mBoardActivity, HomeActivity.class);
        mBoardActivity.startActivity(intent);
    }

    @Override
    public void onButtonClicked(Button button) {
        String backgroundColor = (String) button.getTag();
        if (backgroundColor != "#FFFFFF") {
            button.setBackgroundColor(Color.parseColor("#FFFFFF"));
            button.setTag("#FFFFFF");
            if (!mBoardGameManager.isTop(backgroundColor)) {
                mBoardGameManager.reset();
                Intent intent = new Intent(mBoardActivity, GameOverActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("gameOver", "0");
                intent.putExtras(bundle);
                mBoardActivity.startActivity(intent);
                mBoardActivity.finish();
            }
        }
    }

    @Override
    public void onLevelCompleted() {
        mBoardGameManager.increaseLevel();
        Intent intent = new Intent(mBoardActivity, LevelActivity.class);
        mBoardActivity.startActivity(intent);
        mBoardActivity.finish();
    }
}
