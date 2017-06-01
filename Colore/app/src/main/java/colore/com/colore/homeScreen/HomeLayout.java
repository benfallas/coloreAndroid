package colore.com.colore.homeScreen;

import android.util.Log;
import android.view.WindowManager;
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

    @BindView(R.id.id__play_button) Button mPlayerButton;
    @BindView(R.id.id__help_button) Button mHelpButton;
    @BindView(R.id.id_title) TextView mTitle;

    public HomeLayout(HomeActivity homeActivity) {
        mHomeActivity = homeActivity;
        mHomeActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
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
        Log.d(TAG, "HelpButtonClicked");
    }
}
