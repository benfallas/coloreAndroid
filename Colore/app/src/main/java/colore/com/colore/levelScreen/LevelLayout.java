package colore.com.colore.levelScreen;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import colore.com.colore.R;

public class LevelLayout {

    private LevelActivity mLevelActivity;
    private LevelLayoutListener mLevelLayoutListener;
    private CountDownTimer mCountDownTimer;

    @BindView(R.id.list_buttons) LinearLayout mListButtons;
    @BindView(R.id.id__level) TextView mLevelTitle;
    @BindView(R.id.id__play_button) Button mPlayButton;
    @BindView(R.id.id__time_display) TextView mTimeDisplay;

    public LevelLayout(
            @NonNull LevelActivity levelActivity,
            @NonNull LevelLayoutListener listener) {
        mLevelActivity = levelActivity;
        mLevelLayoutListener = listener;

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

    @OnClick(R.id.id__play_button)
    void onPlayButtonClicked() {
        mCountDownTimer.cancel();
        mLevelLayoutListener.onPlayButtonClicked();
    }

    public void showTime(int mSecondsCountDownForLevel) {
        mCountDownTimer = new CountDownTimer(mSecondsCountDownForLevel * 1000, 1000) {

            @Override
            public void onTick(long l) {
                mTimeDisplay.setText((l / 1000) + "");
            }

            @Override
            public void onFinish() {
                mLevelLayoutListener.onPlayButtonClicked();
            }
        };

        mCountDownTimer.start();
    }

    interface LevelLayoutListener {
        void onPlayButtonClicked();
    }
}
