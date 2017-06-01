package colore.com.colore.homeScreen;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import colore.com.colore.R;

/**
 * Created by benitosanchez on 5/31/17.
 */

public class HelpDialog extends Dialog {

    private static HelpDialog mHelpDialog;
    private static HelpDialogListener mHelpDialogListener;

    @BindView(R.id.id__okay_button) Button mOkayButton;

    private HelpDialog(HomeActivity activity) {
        super(activity);
        setContentView(R.layout.help_dialog);
        setCanceledOnTouchOutside(false);
        ButterKnife.bind(this);
    }

    public static HelpDialog getHelpDialog(
            @NonNull HomeActivity homeActivity,
            @NonNull HelpDialogListener listener) {
        if (mHelpDialog == null) {
            mHelpDialogListener = listener;
            mHelpDialog = new HelpDialog(homeActivity);
        }
        return mHelpDialog;
    }

    @OnClick(R.id.id__okay_button)
    void onOkayButtonClicked() {
        mHelpDialogListener.onOkayButtonClicked();
    }

    interface HelpDialogListener {
        void onOkayButtonClicked();
    }
}
