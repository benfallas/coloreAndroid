package colore.com.colore.levelScreen;

import android.support.annotation.NonNull;

import colore.com.colore.modules.LevelSequence;

/**
 * Created by benitosanchez on 5/31/17.
 */
public class LevelController {

    private LevelActivity mLevelActivity;
    private LevelLayout mLevelLayout;
    private LevelSequence mLevelSequence;

    public LevelController(@NonNull LevelActivity levelActivity) {
        mLevelActivity = levelActivity;
        mLevelLayout = new LevelLayout(mLevelActivity);
        mLevelSequence = LevelSequence.initLevelSequence();
        mLevelLayout.initListButtons(mLevelSequence.getSequenceColors(), mLevelSequence.getLevel());
    }


}
