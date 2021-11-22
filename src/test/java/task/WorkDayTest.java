package task;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkDayTest {

    DY: @Andrey,
    1. You repeat test logic for both test cases and there is only one difference in test input data. Why do not you use @DataProvider from junit?
    2. Why do not you test cases with different times:
       2.1 What will be the result if all users come to the shop every 30 seconds?
       2.2 How can I specify a test case when 1st user comes at second number 1, 2nd at second number 10, 3rd user at second number 13 adn so on?
       2.3 In the task it was said that "Queue to each cashbox can't exceed 20 people" - how it's processed in your code right now?
    @Test
    public void playWorkDayExample1() {
        String actual = new WorkDay().playWorkDay("AA4AA",0);
        Assert.assertEquals("4342", actual);
    }

    @Test
    public void playWorkDayExample2() {
        String actual = new WorkDay().playWorkDay("AAAAA",0);
        Assert.assertEquals("43214", actual);
    }
}