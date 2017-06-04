package colore.com.colore.modules;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;

public class MasterModule {

    private static final String SCORE = "score";

    private static MasterModule mMasterModule;
    private static SharedPreferences mSharedPreferences;
    private SharedPreferences.Editor mEditor;

    private MasterModule() { }

    public static MasterModule getMasterModule(AppCompatActivity activity) {
        if (mMasterModule == null) {
            mMasterModule = new MasterModule();
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity.getBaseContext());
        }
        return mMasterModule;
    }

    public int getScore() { return mSharedPreferences.getInt(SCORE, 0); }

    public void updateScore(int score) {
        mEditor = mSharedPreferences.edit();
        mEditor.putInt("score", score);
        mEditor.apply();
    }
}
