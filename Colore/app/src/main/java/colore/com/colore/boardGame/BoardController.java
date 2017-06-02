package colore.com.colore.boardGame;

import colore.com.colore.modules.BoardGameManager;

public class BoardController {

    private BoardActivity mBoardActivity;
    private BoardLayout mBoardLayout;

    private BoardGameManager mBoardGameManager;

    public BoardController(BoardActivity boardActivity) {
        mBoardActivity = boardActivity;
        mBoardLayout = new BoardLayout(mBoardActivity);
        mBoardGameManager = BoardGameManager.getBoardGameManager();
        mBoardGameManager.initBoardGame();

        mBoardLayout.setButtonColors(mBoardGameManager.getBoardColors());
    }

    public void onBackPressed() {
        mBoardGameManager.reset();
    }
}
