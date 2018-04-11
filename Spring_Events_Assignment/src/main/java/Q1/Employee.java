package Q1;

public class Employee {



    private int id;
    private String name;
    private String mailId;
    private int salary;

    public Employee(int id, String name, String mailId, int salary) {
        this.id = id;
        this.name = name;
        this.mailId = mailId;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailId() {
        return mailId;
    }

    public void setMailId(String mailId) {
        this.mailId = mailId;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
