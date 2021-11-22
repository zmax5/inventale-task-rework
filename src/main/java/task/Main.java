package task;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] arg) {
        WorkDay workDay = new WorkDay();

        Scanner in = new Scanner(System.in);
        System.out.println("Input line: ");
        String inputLine = in.nextLine();
        System.out.println("Visitors came every (minutes): ");
        String inputTime = in.nextLine();

        //DY: Andrey, have you used Logger instead of System.out / System.err? E.g. Slf4j, Java Util Logger?
        //RESPONSE: My goal was to just print out result.
        System.out.println(workDay.playWorkDay(inputLine,Double.parseDouble(inputTime)));
    }
}
