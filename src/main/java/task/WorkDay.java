package task;

import java.util.Objects;
import java.util.Scanner;

public class WorkDay {

    public WorkDay() {

    }

    public String playWorkDay(String inputLine, double time) {
        //DY, @Andrey why do we need Scanner if it's never used?'
        //Response: My bad. When I moved this part of code I forgot to delete it
        //Scanner in = new Scanner(System.in); --just let it be commented
        String inputString = inputLine;
        inputString = inputString.replaceAll("\\s+","");
        StringBuilder outputString = new StringBuilder();
        char current = 'A';
        int choose = 3;

        CashBox[] cashBoxes = new CashBox[4];
        for (int i=0; i < 4; i++) {
            cashBoxes[i] = new CashBox();
        }
        cashBoxes[0].setProductivity(10);
        cashBoxes[1].setProductivity(13);
        cashBoxes[2].setProductivity(15);
        cashBoxes[3].setProductivity(17);

        //DY, @Andrey a lot of internal cycles are used below, maybe we can move some of them into separate methods and simplity method's complexity?
        //Response: I've made some logical changes, so look through and give me more advice or questions.
        while (!inputString.equals("")) {
            current = inputString.charAt(0);
            choose = 3;

            if (current == 'A') {

                for (int i = 0; i < 4; i++) {

                    if (cashBoxes[i].getPeopleInQueue() > 0) {
                        if (time < 0) {
                            cashBoxes[i].addStoredTime(Math.random() * 60);
                        } else {
                            cashBoxes[i].addStoredTime(time);
                        }
                    }

                    double amount = cashBoxes[i].calcAmount();
                    if (cashBoxes[i].getPeopleInQueue() > 0 && amount > 0) {
                        cashBoxes[i].leftQueue((int) amount);
                        cashBoxes[i].setStoredTime(0);
                    }

                    if (cashBoxes[i].getPeopleInQueue() < 0)
                        cashBoxes[i].setPeopleInQueue(0);

                    if (cashBoxes[i].getPeopleInQueue() <= cashBoxes[choose].getPeopleInQueue())
                        if (cashBoxes[i].getProductivity() > cashBoxes[choose].getProductivity() ||
                                cashBoxes[i].getPeopleInQueue() < cashBoxes[choose].getPeopleInQueue())
                            choose = i;
                }
                /*
                for (int i = 3; i >= 0; i--) {
                    if (cashBoxes[i].getPeopleInQueue() <= cashBoxes[choose].getPeopleInQueue()) {
                        choose = i;
                        for (int j = 3; j >= 0; j--) {
                            if (cashBoxes[j].getPeopleInQueue() <= cashBoxes[choose].getPeopleInQueue() &&
                                    cashBoxes[j].getProductivity() > cashBoxes[choose].getProductivity())
                                choose = j;
                        }
                    }
                }*/
                cashBoxes[choose].addPeopleInQueue(1);
                if (cashBoxes[choose].getPeopleInQueue() > 20) {
                    System.out.println("Ouch there is overflow");
                }
                outputString.append(choose + 1);
            } else if (current == ' ') {
                //DY, why do we need this empty if statement?
                //Response: To exclude spaces in input data. Now this "if" case can be removed due to excluding them higher.
            } else {
                int ind = Character.getNumericValue(current) - 1;
                if (cashBoxes[ind].getPeopleInQueue() > 0)
                    cashBoxes[ind].addPeopleInQueue(-1);
            }

            if (inputString.length() > 1)
                inputString = inputString.substring(1);
            else
                inputString = "";
        }
        return outputString.toString();
    }
}
