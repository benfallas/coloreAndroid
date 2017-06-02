package colore.com.colore.modules;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.Random;

public class BoardGameManager {

    private static BoardGameManager mBoardGameManager;
    private static BoardGameManagerListener mBoardGameManagerListener;

    private LevelSequence mLevelSequence;
    private ArrayList<String> mSequenceColors;
    private ArrayList<String> mBoardColors;
    private ArrayList<Integer> mSequenceCounter;

    int topColor;

    private BoardGameManager() {
        mLevelSequence = LevelSequence.initLevelSequence();
        mSequenceColors = mLevelSequence.getSequenceColors();
        mBoardColors = new ArrayList<>();
        mSequenceCounter = new ArrayList<>();
        topColor = 0;
    }

    public static BoardGameManager getBoardGameManager(
            @NonNull BoardGameManagerListener boardGameManagerListener) {
        if (mBoardGameManager == null) {
            mBoardGameManager = new BoardGameManager();
            mBoardGameManagerListener = boardGameManagerListener;
        }

        return mBoardGameManager;
    }

    public void initBoardGame() {
        initArrays();

        getAllColors();
    }

    public ArrayList<String> getBoardColors() {
        return mBoardColors;
    }

    public boolean isTop(String color) {
        boolean isTop;

        if (mSequenceColors.get(topColor) == color) {
            mSequenceCounter.set(topColor, mSequenceCounter.get(topColor) - 1);
            if (mSequenceCounter.get(topColor) == 0) {
                topColor++;
                if (mSequenceCounter.size() == topColor) {
                    mBoardGameManagerListener.onGameCompleted();
                }
            }
            isTop = true;
        } else {
            isTop = false;
        }

        return isTop;
    }

    private void getRemainingColors() {

        Random random = new Random();

        int i = 0;
        int buttonTurn = 3;
        int range = mBoardColors.size() - mSequenceColors.size();
        while(i < range) {
            int index = random.nextInt(mSequenceColors.size());
            mBoardColors.set(buttonTurn, mSequenceColors.get(index));
            mSequenceCounter.set(index, mSequenceCounter.get(index) + 1);
            i++;
            buttonTurn++;
        }
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

        getRemainingColors();
    }

    private void initArrays() {
        for (int i = 0; i < mLevelSequence.getSequenceColors().size(); i++) {
            mSequenceCounter.add(0);
        }

        for (int i = 0; i < 9; i++) {
            mBoardColors.add("");
        }
    }

    public void reset() {
        mBoardGameManager = null;

    }

    public interface BoardGameManagerListener {
        void onGameCompleted();
    }
}
