package colore.com.colore.boardGame;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.DrawerLayout;
import android.widget.Button;
import android.widget.Toast;

import colore.com.colore.modules.BoardGameManager;

public class BoardController
        implements BoardLayout.BoardLayoutListener,
        BoardGameManager.BoardGameManagerListener {

    private BoardActivity mBoardActivity;
    private BoardLayout mBoardLayout;

    private BoardGameManager mBoardGameManager;

    public BoardController(BoardActivity boardActivity) {
        mBoardActivity = boardActivity;
        mBoardLayout = new BoardLayout(mBoardActivity, this);
        mBoardGameManager = BoardGameManager.getBoardGameManager(this);
        mBoardGameManager.initBoardGame();

        mBoardLayout.setButtonColors(mBoardGameManager.getBoardColors());
    }

    public void onBackPressed() {
        mBoardGameManager.reset();
    }

    @Override
    public void onButtonClicked(Button button) {
        String backgroundColor = (String) button.getTag();
        if (backgroundColor != "#FFFFFF") {
            button.setBackgroundColor(Color.parseColor("#FFFFFF"));
            if (!mBoardGameManager.isTop(backgroundColor)) {
                Toast.makeText(mBoardActivity, "OVER", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onGameCompleted() {
        Toast.makeText(mBoardActivity, "Completed", Toast.LENGTH_SHORT).show();
    }
}
