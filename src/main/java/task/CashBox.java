package task;

public class CashBox {
    private int peopleInQueue = 0;
    private double productivity = 0;
    private double storedTime = 0;

    public CashBox() {

    }

    public CashBox(int ppl, int prod, double sTime) {
        peopleInQueue = ppl;
        productivity = prod;
        storedTime = sTime;
    }

    public int getPeopleInQueue() {
        return peopleInQueue;
    }

    public void setPeopleInQueue(int peopleInQueue) {
        this.peopleInQueue = peopleInQueue;
    }

    public void addPeopleInQueue(int amount) {
        this.peopleInQueue += amount;
    }

    public double getProductivity() {
        return productivity;
    }

    public void setProductivity(double productivity) {
        this.productivity = productivity;
    }

    public double getStoredTime() {
        return storedTime;
    }

    public void setStoredTime(double time) {
        this.storedTime = time;
    }

    public void addStoredTime(double addTime) {
        this.storedTime += addTime;
    }

    public double calcAmount() {
        return Math.floor((productivity / 60) * storedTime);
    }

    public void leftQueue( int num) {
        peopleInQueue -= num;
    }

}
