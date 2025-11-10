import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Call {
    int customerID;
    int callTime; // in minutes

    Call(int customerID, int callTime) {
        this.customerID = customerID;
        this.callTime = callTime;
    }

    public String toString() {
        return "CustomerID: " + customerID + ", CallTime: " + callTime + " min";
    }
}

public class CallCenterQueue {
    Queue<Call> callQueue = new LinkedList<>();

    // Add a call to the queue
    void addCall(int customerID, int callTime) {
        callQueue.add(new Call(customerID, callTime));
        System.out.println("Call added → " + customerID);
    }

    // Answer the first call in the queue
    void answerCall() {
        if (callQueue.isEmpty())
            System.out.println("No calls to answer.");
        else
            System.out.println("Answering call → " + callQueue.poll());
    }

    // View all calls in queue
    void viewQueue() {
        if (callQueue.isEmpty())
            System.out.println("Queue is empty.");
        else {
            System.out.println("Current Call Queue:");
            for (Call c : callQueue)
                System.out.println("→ " + c);
        }
    }

    // Check if queue is empty
    void isQueueEmpty() {
        System.out.println("Is queue empty? " + callQueue.isEmpty());
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CallCenterQueue ccq = new CallCenterQueue();

        ccq.addCall(101, 5);
        ccq.addCall(102, 3);
        ccq.addCall(103, 4);

        ccq.viewQueue();

        ccq.answerCall();
        ccq.viewQueue();

        ccq.isQueueEmpty();

        ccq.answerCall();
        ccq.answerCall();
        ccq.answerCall(); // extra call to show empty state
        ccq.isQueueEmpty();

        sc.close();
    }
}
