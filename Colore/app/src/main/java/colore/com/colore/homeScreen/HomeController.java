package colore.com.colore.homeScreen;

import android.content.Intent;
import android.support.annotation.NonNull;

import colore.com.colore.levelScreen.LevelActivity;
import colore.com.colore.modules.LevelSequence;

public class HomeController
        implements HomeLayout.HomeLayoutListener,
        HelpDialog.HelpDialogListener {

    private HomeActivity mHomeActivity;
    private HomeLayout mHomeLayout;
    private HelpDialog mHelpDialog;
    private LevelSequence mLevelSequence;

    public HomeController(
            @NonNull HomeActivity homeActivity) {
        mHomeActivity = homeActivity;
        mHomeLayout = new HomeLayout(mHomeActivity, this);

    }

    @Override
    public void onHelpButtonClicked() {
        mHelpDialog = HelpDialog.getHelpDialog(mHomeActivity, this);
        mHelpDialog.show();
    }

    @Override
    public void onPlayButtonClicked() {
        Intent intent = new Intent(mHomeActivity, LevelActivity.class);
        mHomeActivity.startActivity(intent);
    }

    @Override
    public void onOkayButtonClicked() {
        if (mHelpDialog != null && mHelpDialog.isShowing()) {
            mHelpDialog.hide();
        }
    }
}
