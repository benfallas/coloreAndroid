package colore.com.colore.gameOver;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import colore.com.colore.R;

public class GameOverActivity extends AppCompatActivity {

    private GameOverController mGameOverController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGameOverController = new GameOverController(this);
    }

    @Override
    public void onBackPressed() {
        mGameOverController.onBackPressed();
    }
}
