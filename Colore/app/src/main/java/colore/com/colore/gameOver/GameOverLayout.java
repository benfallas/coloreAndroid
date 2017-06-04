package colore.com.colore.gameOver;

import android.os.Build;
import android.support.annotation.NonNull;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import colore.com.colore.R;

public class GameOverLayout {

    private GameOverActivity mGameOverActivity;
    private GameOverLayoutListener mGameOverLayoutListener;

    @BindView(R.id.thinkingEmoji) ImageView emoji;
    @BindView(R.id.id__home_icon) ImageView mHomeIcon;
    @BindView(R.id.id__level_description) TextView mLevelDescription;
    @BindView(R.id.id__score) TextView mScore;
    @BindView(R.id.id__highest_score) TextView mHighestScore;

    public GameOverLayout(
            @NonNull GameOverActivity gameOverActivity,
            @NonNull GameOverLayoutListener gameOverLayoutListener) {
        mGameOverActivity = gameOverActivity;
        mGameOverLayoutListener = gameOverLayoutListener;

        mGameOverActivity.setContentView(R.layout.activity_game_over);
        ButterKnife.bind(this, mGameOverActivity);
    }

    public void setEmoji(String gaveOver) {
        final int sdk = Build.VERSION.SDK_INT;
        if (sdk < Build.VERSION_CODES.JELLY_BEAN) {
            if (gaveOver.equals("0")) {
                emoji.setBackgroundDrawable(mGameOverActivity.getResources().getDrawable(R.drawable.thinkingemoji));
            } else if (gaveOver.equals("1")) {
                emoji.setBackgroundDrawable(mGameOverActivity.getResources().getDrawable(R.drawable.coolemoji));
            }
        } else {
            if (gaveOver.equals("0")) {
                emoji.setBackground(mGameOverActivity.getResources().getDrawable(R.drawable.thinkingemoji));
            } else if (gaveOver.equals("1")) {
                emoji.setBackground(mGameOverActivity.getResources().getDrawable(R.drawable.coolemoji));
            }
        }
    }

    @OnClick(R.id.id__home_icon)
    public void onHomeIconClicked() {
        mGameOverLayoutListener.onHomeIconClicked();
    }

    public void setLayout(String gaveOver, int level, int points, int highestPoint) {
        setEmoji(gaveOver);
        mScore.setText("Game Score: " + points);
        mLevelDescription.setText("Last Level Reached: " + (level + 1));
        mHighestScore.setText("Highest Score: " + highestPoint);
    }

    interface GameOverLayoutListener {
        void onHomeIconClicked();
    }
}
