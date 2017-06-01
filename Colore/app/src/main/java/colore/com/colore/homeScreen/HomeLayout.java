package colore.com.colore.homeScreen;

import android.app.Dialog;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import colore.com.colore.R;

public class HomeLayout {

    private final String TAG = "HomeLayout: ";

    private HomeActivity mHomeActivity;
    private HomeLayoutListener mHomeLayoutListener;
    private Dialog mHelpDialog;

    @BindView(R.id.id__play_button) Button mPlayerButton;
    @BindView(R.id.id__help_button) Button mHelpButton;
    @BindView(R.id.id_title) TextView mTitle;

    public HomeLayout(
        @NonNull HomeActivity homeActivity,
        @NonNull HomeLayoutListener listener) {
        mHomeActivity = homeActivity;
        mHomeLayoutListener = listener;

        mHomeActivity.setContentView(R.layout.activity_home);
        ButterKnife.bind(this, mHomeActivity);

        mTitle.startAnimation(AnimationUtils.loadAnimation(mHomeActivity, R.anim.drop_down_in));
    }

    @OnClick(R.id.id__play_button)
    void onPlayButtonClicked() {
        Log.d(TAG, "PlayButtonClicked");
    }

    @OnClick(R.id.id__help_button)
    void onHelpButtonClicked() {
        mHomeLayoutListener.onHelpButtonClicked();
    }

    interface HomeLayoutListener {
        void onHelpButtonClicked();
    }
}
