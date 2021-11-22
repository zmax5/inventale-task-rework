package task;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class WorkDayTest {
    /*
    DY: @Andrey,
    1. You repeat test logic for both test cases and there is only one difference in test input data. Why do not you use @DataProvider from junit?
    2. Why do not you test cases with different times:
       2.1 What will be the result if all users come to the shop every 30 seconds?
       2.2 How can I specify a test case when 1st user comes at second number 1, 2nd at second number 10, 3rd user at second number 13 and so on?
       2.3 In the task it was said that "Queue to each cashbox can't exceed 20 people" - how it's processed in your code right now?
    Response:
    1. I just never did it, so I grabbed the first I found and put it here. :)
        1.1 Made it with parameters, but can't make it with @DataProvider (sorry)
    2. If we imagine that visitors will come with a gap of 0 seconds, which is hard to believe,
    then there is need at least 81 to overcome the queue limit, which is also insane.
    If we imagine something close to reality, then I assume it will be the gap of 15 seconds,
    and if using my code input exact 100 people in queue. then there will be no overflow.
    As I'm assume there is no sense in solving the problem, because its cases is unnatural. But if you'd like
    I can just let customer wait until a place in queue or just let the customer go.
        2.2 I can make it, but as I imagine it now it will be kinda array with just exact seconds/minutes of visiting, which is looking hard to input by hands.
    */

    private final String inputString;
    private final double inputTime;
    private final String expectedResult;
    private WorkDay workDay;

    @Before
    public void initialize() {
        workDay = new WorkDay();
    }

    public WorkDayTest(String inputString, double inputTime, String expectedResult) {
        this.inputString = inputString;
        this.inputTime = inputTime;
        this.expectedResult = expectedResult;
    }

    @Parameterized.Parameters
    public static Collection inputData() {
        return Arrays.asList(new Object[][] {{"AA4AA",0,"4342"},{"AAAAA",0,"43214"},{"AAAAA",5,"44444"}});
    }

    @Test
    public void playWorkDayExample() {
        String actual = new WorkDay().playWorkDay("AA4AA",0);
        Assert.assertEquals(expectedResult, workDay.playWorkDay(inputString,inputTime));
    }
}