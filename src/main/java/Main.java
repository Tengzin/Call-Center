public class Main {
    public static void main(String[] args) {
        CallManager manager = new CallManager();

        manager.addClerk(new Clerk("Clerk1", manager));
        manager.addClerk(new Clerk("Clerk2", manager));
        manager.addClerk(new Clerk("Clerk3", manager));
        manager.addClerk(new Clerk("Clerk4", manager));
        manager.addClerk(new Clerk("Clerk5", manager));

        manager.addSupervisor(new Supervisor("Super", manager));

        manager.addManager(new Manager("Manager", manager));

        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());

        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
        manager.findCallHandler(new Call());
    }
}
