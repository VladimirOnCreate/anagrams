package hwr.com.hwreverse;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;


import com.squareup.spoon.SpoonRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Rule
    public final SpoonRule spoon = new SpoonRule();

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void onCreate() {
    }

    @Test
    public void onTextChanged() {
        insertText("qwerty");
        spoon.screenshot(mActivityRule.getActivity(), "state_changed");
        isMatches("ytrewq");
        spoon.screenshot(mActivityRule.getActivity(), "state_isMatches");
        clear();
        spoon.screenshot(mActivityRule.getActivity(), "state_changed");
        insertText("qwerty two");
        spoon.screenshot(mActivityRule.getActivity(), "state_insertText");
        isMatches("ytrewq owt");
        clear();
        spoon.screenshot(mActivityRule.getActivity(), "state_clear");
        insertText("per$fect");
        spoon.screenshot(mActivityRule.getActivity(), "state_insertText");
        isMatches("tce$frep");
        clear();
        spoon.screenshot(mActivityRule.getActivity(), "state_clear");
        insertText("very n&ice");
        spoon.screenshot(mActivityRule.getActivity(), "state_insertText");
        isMatches("yrev e&cin");
        clear();
    }

    private void insertText(String text) {
        Espresso.onView(ViewMatchers.withId(R.id.etInput))
                .perform(ViewActions.typeText(text));
    }

    private void isMatches(String text) {
        Espresso.onView(ViewMatchers.withId(R.id.tvResult))
                .check(ViewAssertions.matches(ViewMatchers.withText(text)));
    }

    private void clear() {
        Espresso.onView(ViewMatchers.withId(R.id.etInput))
                .perform(ViewActions.clearText());
    }
}