package colore.com.colore.levelScreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import colore.com.colore.R;

public class LevelActivity extends AppCompatActivity {

    private LevelController mLevelController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLevelController = new LevelController(this);
    }
}
