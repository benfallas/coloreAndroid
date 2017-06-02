package colore.com.colore.modules;

import java.util.ArrayList;
import java.util.Random;

public class LevelSequence {

    private static LevelSequence mLevelSequence;
    private ArrayList<String> mColors;
    private static ArrayList<String> mSequenceColors;
    private int mLevel;

    private LevelSequence() {
        mColors = new ArrayList<>();
        mSequenceColors = new ArrayList<>();

        mColors.add("#EE7AE9");
        mColors.add("#BEBEBE");
        mColors.add("#8B4789");
        mColors.add("#BF3EFF");
        mColors.add("#F5F5F5");
        mColors.add("#FFD700");
        mColors.add("#8B6914");
        mColors.add("#EE0000");
        mColors.add("#00EEEE");

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
}
