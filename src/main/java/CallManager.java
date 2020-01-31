import java.util.List;
import java.util.ArrayList;
import java.util.Optional;


public class CallManager {
    List<Clerk> clerks;
    Supervisor supervisor;
    Manager manager;

    CallManager() {
        this.clerks = new ArrayList<>();
    }

    public Optional<Employee> findEmployee() {
        for (Clerk c: clerks) {
            if (c.isFree()) return Optional.of(c);
        }
        if (supervisor != null && supervisor.isFree()) return Optional.of(supervisor);
        if (manager != null && manager.isFree()) return Optional.of(manager);
        return Optional.empty();
    }

    public void addClerk(Clerk c) {
        clerks.add(c);
    }

    public void addSupervisor(Supervisor s) {
        this.supervisor = s;
    }

    public void addManager(Manager m) {
        this.manager = m;
    }

    public void findCallHandler(Call call) {
        Optional<Employee> emp = findEmployee();
        if (!emp.isPresent()) {
            System.out.println("All of our employees are currently busy, please call back later");
            return;
        }
        Employee employee = emp.get();
        call.setEmployee(employee);
        employee.getCall(call);
    }
}