package com.example.brett.chefapplication;

import com.robotium.solo.Solo;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Test;
import org.junit.Rule;
import org.junit.Before;
import org.junit.runner.RunWith;



/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
// Name is ambiguous, tests are designed by Brett Lechner
public class ExampleInstrumentedTest {

    @Rule
    // Start on the WelcomePage
    public ActivityTestRule<WelcomePage> mActivityRule =
            new ActivityTestRule<>(WelcomePage.class);

    private Solo solo;

    @Before
    public void setUp() throws Exception{
        // Create the solo object
        solo = new Solo(InstrumentationRegistry.getInstrumentation(),
                mActivityRule.getActivity());
    }

    @After
    public void tearDown() throws Exception {
        //tearDown() is run after a test case has finished.
        //finishOpenedActivities() will finish all the activities that have been opened during the test execution.
        solo.finishOpenedActivities();
    }

    @Test
    // This will test the functionality of all the buttons in the application
    public void btnTest() throws Exception {

        // Click 'VIEW ORDERS' and check program goes to DisplayMessageActivity
        solo.clickOnView(solo.getView(R.id.button));
        solo.assertCurrentActivity("Expected DisplayMessageActivity Activity", DisplayMessageActivity.class);

        //Click 'OUT OF INGREDIENTS'
        solo.clickOnView(solo.getView(R.id.button3));
        solo.assertCurrentActivity("Expected ListItemDetail Activity", ListItemDetail.class);

        // Go back to previous activity and click 'PROBLEM'
        solo.goBack();
        solo.clickOnView(solo.getView(R.id.button4));
        solo.assertCurrentActivity("Expected Problem Activity", Problem.class);

        solo.goBack();
    }

    @Test
    // Test functionality of order queue
    public void orderTest() throws Exception{
        // Go to DisplayMessageActivity
        solo.clickOnView(solo.getView(R.id.button));

        // Click the create button to generate items
        solo.clickOnView(solo.getView(R.id.button2));

        // Delete the entries created
        solo.clickInList(0);
        solo.clickOnText("Ok");
        solo.clickInList(0);
        solo.clickOnText("Ok");
        solo.clickInList(0);
        solo.clickOnText("Ok");
        solo.clickInList(0);
        solo.clickOnText("Ok");
    }

    @Test
    // Test case for ingredients page
    public void outOf() throws Exception{
        // Go to DisplayMessageActivity
        solo.clickOnView(solo.getView(R.id.button));

        // Click the create button to generate items
        solo.clickOnView(solo.getView(R.id.button2));

        //Click 'OUT OF INGREDIENTS'
        solo.clickOnView(solo.getView(R.id.button3));
        solo.assertCurrentActivity("Expected ListItemDetail Activity", ListItemDetail.class);

        // Select BACON to be removed
        solo.clickInList(2);
        solo.clickOnText("Ok");

        solo.goBack();

        // Delete the other entries created
        solo.clickInList(0);
        solo.clickOnText("Ok");
        solo.clickInList(0);
        solo.clickOnText("Ok");
        solo.clickInList(0);
        solo.clickOnText("Ok");
    }

    @Test
    public void notifyTest() throws Exception{
        // Go to DisplayMessageActivity
        solo.clickOnView(solo.getView(R.id.button));

        // Click on PROBLEM
        solo.clickOnView(solo.getView(R.id.button4));
        solo.assertCurrentActivity("Expected Problem Activity", Problem.class);

        // Type a message, click NOTIFY, and be brought back to the previous page
        //solo.typeText(R.id.editText, "This is a message that will be sent"); // causes error, not sure why
        solo.clickOnView(solo.getView(R.id.button5));
        solo.clickOnText("Ok");

        solo.assertCurrentActivity("Expected DisplayMessageActivity Activity", DisplayMessageActivity.class);

    }
}// end class

