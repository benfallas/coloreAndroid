package colore.com.colore.boardGame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import colore.com.colore.R;

public class BoardActivity extends AppCompatActivity {

    private BoardController mBoardController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBoardController = new BoardController(this);
    }

    @Override
    public void onBackPressed() {
        mBoardController.onBackPressed();
        super.onBackPressed();
    }
}
