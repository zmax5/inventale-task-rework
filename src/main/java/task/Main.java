package task;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("input string: ");
        String inputString = in.nextLine();
        System.out.println("users visit every .. minutes(give negative number if random): ");
        double periodTime = in.nextDouble();
        StringBuilder outputString = new StringBuilder();
        char current = 'A';
        int[] cashBoxesQueue = new int[4];
        int choose = 3;
        double[] productivity = {10, 13, 15, 17};
        double[] storedTime = new double[4];

        while (!inputString.equals("")) {

            current = inputString.charAt(0);

            if (current == 'A') {

                for (int i = 0; i < 4; i++) {
                    if (cashBoxesQueue[i] > 0) {
                        if (periodTime < 0) {
                            storedTime[i] += Math.random() * 60;
                        } else {
                            storedTime[i] += periodTime;
                        }
                    }
                    double amount = Math.floor((productivity[i] / 60) * storedTime[i]);
                    if (cashBoxesQueue[i] > 0 && amount > 0) {
                        cashBoxesQueue[i] = (int) (cashBoxesQueue[i] - amount);
                        storedTime[i] = 0;
                    }
                    if (cashBoxesQueue[i] < 0)
                        cashBoxesQueue[i] = 0;
                }

                for (int i = 3; i >= 0; i--) {
                    if (cashBoxesQueue[i] <= cashBoxesQueue[choose]) {
                        choose = i;
                        for (int j = 3; j >= 0; j--) {
                            if (cashBoxesQueue[j] <= cashBoxesQueue[choose] && productivity[j] > productivity[choose])
                                choose = j;
                        }
                    }
                }
                cashBoxesQueue[choose]++;
                outputString.append(choose + 1);
            } else if (current == ' ') {

            } else {
                int ind = Character.getNumericValue(current) - 1;
                if (cashBoxesQueue[ind] > 0)
                    cashBoxesQueue[ind]--;
            }

            if (inputString.length() > 1)
                inputString = inputString.substring(1);
            else
                inputString = "";
        }
        System.out.println(outputString);
    }
}
