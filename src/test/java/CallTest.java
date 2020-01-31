import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CallTest {
    @Test
    public void firstCallTest() {
        CallManager manager = new CallManager();
        Clerk c1 = new Clerk("Clerk1", manager);
        Call call = new Call();
        manager.addClerk(c1);
        manager.findCallHandler(call);
        assertEquals(c1, call.getEmployee());
    }
    @Test
    public void noEmployeesTest() {
        CallManager manager = new CallManager();
        Call call = new Call();
        manager.findCallHandler(call);
        assertEquals(null, call.getEmployee());
    }
    @Test
    public void SupervisorTest() {
        CallManager manager = new CallManager();
        Clerk c1 = new Clerk("Clerk1", manager);
        Clerk c2 = new Clerk("Clerk2", manager);
        Supervisor s = new Supervisor("S1", manager);
        manager.addClerk(c1);
        manager.addClerk(c2);
        manager.addSupervisor(s);
        Call call = new Call();
        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
        // this one should be the supervisor
        manager.findCallHandler(call);
        assertEquals(s, call.getEmployee());
    }
    @Test
    public void ManagerTest() {
        CallManager manager = new CallManager();
        Clerk c1 = new Clerk("Clerk1", manager);
        Clerk c2 = new Clerk("Clerk2", manager);
        Supervisor s = new Supervisor("S1", manager);
        Manager m = new Manager("M1", manager);
        manager.addClerk(c1);
        manager.addClerk(c2);
        manager.addSupervisor(s);
        manager.addManager(m);
        Call call = new Call();
        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
        // this one should be the manager
        manager.findCallHandler(call);
        assertEquals(m, call.getEmployee());
    }
}