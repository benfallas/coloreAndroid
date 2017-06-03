package colore.com.colore.modules;

import android.util.Log;

import java.util.ArrayList;
import java.util.Random;

public class LevelSequence {

    private static LevelSequence mLevelSequence;
    private ArrayList<String> mColors;
    private static ArrayList<String> mSequenceColors;
    private static int mLevel;

    private LevelSequence() {
        mColors = new ArrayList<>();
        mSequenceColors = new ArrayList<>();

        mColors.add("#ffff00");
        mColors.add("#ff8c00");
        mColors.add("#ff0000");
        mColors.add("#00ff0c");
        mColors.add("#000000");
        mColors.add("#8300ff");
        mColors.add("#00FFFF");
        mColors.add("#800080");
        mColors.add("#0000FF");

        mLevel = 0;
    }

    public static LevelSequence initLevelSequence() {
        if (mLevelSequence == null) {
            mLevelSequence = new LevelSequence();
        }
        return mLevelSequence;
    }

    public int getLevel() {
        return mLevel;
    }

    public ArrayList<String> getSequenceColors() {
        if (mSequenceColors.isEmpty()) {
            int numColors = mLevel + 2;
            Random randomGenerator = new Random();

            while(numColors >= 0) {
                int rand = randomGenerator.nextInt(mColors.size());
                if (!mSequenceColors.contains(mColors.get(rand))) {
                    mSequenceColors.add(mColors.get(rand));
                    numColors--;
                }
            }
        }
        return mSequenceColors;
    }

    public void reset() {
        mLevelSequence = null;
    }

    public void increaseLevel() {
        mLevel++;
        mSequenceColors = new ArrayList<>();
        Log.d("LEVELSEQUENCE: " , mLevel + "");
    }
}
