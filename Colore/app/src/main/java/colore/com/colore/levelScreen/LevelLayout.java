package colore.com.colore.levelScreen;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import colore.com.colore.R;

/**
 * Created by benitosanchez on 5/31/17.
 */
public class LevelLayout {

    private LevelActivity mLevelActivity;

    @BindView(R.id.list_buttons) LinearLayout mListButtons;
    @BindView(R.id.id__level) TextView mLevelTitle;

    public LevelLayout(@NonNull LevelActivity levelActivity) {
        mLevelActivity = levelActivity;
        mLevelActivity.setContentView(R.layout.activity_level);
        ButterKnife.bind(this, mLevelActivity);
    }

    public void initListButtons(ArrayList<String> buttonColors, int level) {
        mLevelTitle.setText("Level: " + (level + 1));

        for (int i = 0; i < buttonColors.size(); i++) {
            Button button = new Button(mLevelActivity);
            button.setBackgroundColor(Color.parseColor(buttonColors.get(i)));
            mListButtons.addView(button);
        }
    }
}
