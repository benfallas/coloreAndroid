package colore.com.colore.boardGame;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.widget.Button;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import colore.com.colore.R;

public class BoardLayout {

    private BoardActivity mBoardActivity;
    private BoardLayoutListener mBoardLayoutListener;

    @BindView(R.id.top_left) Button mTopLeft;
    @BindView(R.id.top_center) Button mTopCenter;
    @BindView(R.id.top_right) Button mTopRight;
    @BindView(R.id.center_left) Button mCenterLeft;
    @BindView(R.id.center_center) Button mCenterCenter;
    @BindView(R.id.center_right) Button mCenterRight;
    @BindView(R.id.bottom_left) Button mBottomLeft;
    @BindView(R.id.bottom_center) Button mBottomCenter;
    @BindView(R.id.bottom_right) Button mBottomRight;

    public BoardLayout(
            @NonNull BoardActivity boardActivity,
            @NonNull BoardLayoutListener listener) {

        mBoardActivity = boardActivity;
        mBoardLayoutListener = listener;

        mBoardActivity.setContentView(R.layout.activity_board);
        ButterKnife.bind(this, mBoardActivity);
    }

    public void setButtonColors(ArrayList<String> buttonColors) {
        mTopLeft.setBackgroundColor(Color.parseColor(buttonColors.get(0)));
        mTopLeft.setTag(buttonColors.get(0));
        mTopCenter.setBackgroundColor(Color.parseColor(buttonColors.get(1)));
        mTopCenter.setTag(buttonColors.get(1));
        mTopRight.setBackgroundColor(Color.parseColor(buttonColors.get(2)));
        mTopRight.setTag(buttonColors.get(2));

        mCenterLeft.setBackgroundColor(Color.parseColor(buttonColors.get(3)));
        mCenterLeft.setTag(buttonColors.get(3));
        mCenterCenter.setBackgroundColor(Color.parseColor(buttonColors.get(4)));
        mCenterCenter.setTag(buttonColors.get(4));
        mCenterRight.setBackgroundColor(Color.parseColor(buttonColors.get(5)));
        mCenterRight.setTag(buttonColors.get(5));

        mBottomLeft.setBackgroundColor(Color.parseColor(buttonColors.get(6)));
        mBottomLeft.setTag(buttonColors.get(6));
        mBottomCenter.setBackgroundColor(Color.parseColor(buttonColors.get(7)));
        mBottomCenter.setTag(buttonColors.get(7));
        mBottomRight.setBackgroundColor(Color.parseColor(buttonColors.get(8)));
        mBottomRight.setTag(buttonColors.get(8));
    }

    @OnClick({R.id.top_left, R.id.top_center, R.id.top_right,
        R.id.center_left, R.id.center_center, R.id.center_right,
        R.id.bottom_left, R.id.bottom_center, R.id.bottom_right})
    public void onButtonClicked(Button button) {
           mBoardLayoutListener.onButtonClicked(button);
    }

    interface BoardLayoutListener {
        void onButtonClicked(Button button);
    }
}
