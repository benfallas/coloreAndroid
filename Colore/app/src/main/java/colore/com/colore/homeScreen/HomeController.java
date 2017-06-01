package colore.com.colore.homeScreen;

import android.support.annotation.NonNull;

public class HomeController
        implements HomeLayout.HomeLayoutListener,
        HelpDialog.HelpDialogListener {

    private HomeActivity mHomeActivity;
    private HomeLayout mHomeLayout;
    private HelpDialog mHelpDialog;

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
    public void onOkayButtonClicked() {
        if (mHelpDialog != null && mHelpDialog.isShowing()) {
            mHelpDialog.hide();
        }
    }
}
