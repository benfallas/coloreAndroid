package colore.com.colore.modules;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class BoardGameManager {

    private final static String TAG = "BoardGameManager";

    private static BoardGameManager mBoardGameManager;
    private BoardGameManagerListener mBoardGameManagerListener;
    private static int mPoints;

    private LevelSequence mLevelSequence;
    private ArrayList<String> mSequenceColors;
    private ArrayList<String> mBoardColors;
    private ArrayList<Integer> mSequenceCounter;

    int topColor;

    private BoardGameManager() { }

    public static BoardGameManager getBoardGameManager() {
        if (mBoardGameManager == null) {
            mBoardGameManager = new BoardGameManager();
            mPoints = 0;
        }

        return mBoardGameManager;
    }

    public void initBoardGame(@NonNull BoardGameManagerListener boardGameManagerListener) {
        if (mBoardGameManager == null) {

        }
        mBoardGameManagerListener = boardGameManagerListener;
        mLevelSequence = LevelSequence.initLevelSequence();
        mSequenceColors = mLevelSequence.getSequenceColors();
        topColor = 0;
        initArrays();

        getAllColors();
    }

    public ArrayList<String> getBoardColors() {
        Log.d(TAG, mBoardColors.toString());
        return mBoardColors;
    }

    public boolean isTop(String color) {
        boolean isTop;

        if (mSequenceColors.get(topColor) == color) {
            mSequenceCounter.set(topColor, mSequenceCounter.get(topColor) - 1);
            if (mSequenceCounter.get(topColor) == 0) {
                topColor++;
                if (mSequenceCounter.size() == topColor) {
                    mBoardGameManagerListener.onLevelCompleted();
                }
            }
            isTop = true;
            mPoints++;
            Log.d("TEST", mPoints + "");
        } else {
            isTop = false;
        }

        return isTop;
    }

    public int getPoints() { return mPoints; }

    private void getRemainingColors() {

        Random random = new Random();

        int i = 0;
        int buttonTurn = mLevelSequence.getLevel() + 3;
        Log.d(TAG, buttonTurn + "");
        int range = mBoardColors.size() - mSequenceColors.size();
        while(i < range) {
            int index = random.nextInt(mSequenceColors.size());
            mBoardColors.set(buttonTurn, mSequenceColors.get(index));
            mSequenceCounter.set(index, mSequenceCounter.get(index) + 1);
            i++;
            buttonTurn++;
            Log.d(TAG, mBoardColors.toString());
        }

        Log.d(TAG, mBoardColors.toString());
    }

    private void getAllColors() {
        Random random = new Random();

        int i = 0;
        while (i < mSequenceColors.size()) {
            int index = random.nextInt(mSequenceColors.size());
            if (!mBoardColors.contains(mSequenceColors.get(index))) {
                mBoardColors.set(i, mSequenceColors.get(index));
                mSequenceCounter.set(index, mSequenceCounter.get(index) + 1);
                i++;
            }
        }
        Log.d(TAG, mBoardColors.toString());

        getRemainingColors();
    }

    private void initArrays() {
        mBoardColors = new ArrayList<>();
        mSequenceCounter = new ArrayList<>();

        for (int i = 0; i < mSequenceColors.size(); i++) {
            mSequenceCounter.add(0);
        }

        for (int i = 0; i < 9; i++) {
            mBoardColors.add("");
        }
    }

    public void reset() {
        mBoardGameManager = null;
    }

    public void increaseLevel() {
        mLevelSequence.increaseLevel();
        topColor = 0;
    }

    public interface BoardGameManagerListener {
        void onLevelCompleted();
    }
}
