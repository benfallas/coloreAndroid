package colore.com.colore.levelScreen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.util.Log;

import colore.com.colore.boardGame.BoardActivity;
import colore.com.colore.homeScreen.HomeActivity;
import colore.com.colore.modules.LevelSequence;

public class LevelController implements LevelLayout.LevelLayoutListener {

    private LevelActivity mLevelActivity;
    private LevelLayout mLevelLayout;
    private LevelSequence mLevelSequence;

    public LevelController(@NonNull LevelActivity levelActivity) {
        mLevelActivity = levelActivity;
        mLevelLayout = new LevelLayout(mLevelActivity, this);
        mLevelSequence = LevelSequence.initLevelSequence();
        mLevelLayout.initListButtons(mLevelSequence.getSequenceColors(), mLevelSequence.getLevel());
    }


    @Override
    public void onPlayButtonClicked() {
        Intent intent = new Intent(mLevelActivity, BoardActivity.class);
        mLevelActivity.startActivity(intent);
        mLevelActivity.finish();
    }

    public void onBackPressed() {
        mLevelSequence.reset();
    }
}
