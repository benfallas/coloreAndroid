package colore.com.colore.boardGame;

import android.graphics.Color;
import android.widget.Button;
import android.widget.GridView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import colore.com.colore.R;

public class BoardLayout {

    private BoardActivity mBoardActivity;

    @BindView(R.id.top_left) Button mTopLeft;
    @BindView(R.id.top_center) Button mTopCenter;
    @BindView(R.id.top_right) Button mTopRight;
    @BindView(R.id.center_left) Button mCenterLeft;
    @BindView(R.id.center_center) Button mCenterCenter;
    @BindView(R.id.center_right) Button mCenterRight;
    @BindView(R.id.bottom_left) Button mBottomLeft;
    @BindView(R.id.bottom_center) Button mBottomCenter;
    @BindView(R.id.bottom_right) Button mBottomRight;

    public BoardLayout(BoardActivity boardActivity) {
        mBoardActivity = boardActivity;
        mBoardActivity.setContentView(R.layout.activity_board);
        ButterKnife.bind(this, mBoardActivity);
    }

    public void setButtonColors(ArrayList<String> buttonColors) {
        mTopLeft.setBackgroundColor(Color.parseColor(buttonColors.get(0)));
        mTopCenter.setBackgroundColor(Color.parseColor(buttonColors.get(1)));
        mTopRight.setBackgroundColor(Color.parseColor(buttonColors.get(2)));

        mCenterLeft.setBackgroundColor(Color.parseColor(buttonColors.get(3)));
        mCenterCenter.setBackgroundColor(Color.parseColor(buttonColors.get(4)));
        mCenterRight.setBackgroundColor(Color.parseColor(buttonColors.get(5)));

        mBottomLeft.setBackgroundColor(Color.parseColor(buttonColors.get(6)));
        mBottomCenter.setBackgroundColor(Color.parseColor(buttonColors.get(7)));
        mBottomRight.setBackgroundColor(Color.parseColor(buttonColors.get(8)));
    }
}
