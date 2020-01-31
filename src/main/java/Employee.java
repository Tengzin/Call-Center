public class Employee {
    private String name;
    private Call currentCall;
    private CallManager callManager;

    Employee(String name, CallManager callManager) {
        this.name = name;
        this.callManager = callManager;
    }

    public boolean isFree() {
        return this.currentCall == null;
    }

    public void getCall(Call call) {
        currentCall = call;
        System.out.println(name + " got a call");
    }
}

class Clerk extends Employee {
    Clerk(String name, CallManager callManager) {
        super(name, callManager);
    }
}

class Supervisor extends Employee {
    Supervisor(String name, CallManager callManager) {
        super(name, callManager);
    }
}

class Manager extends Employee {
    Manager(String name, CallManager callManager) {
        super(name, callManager);
    }
}
