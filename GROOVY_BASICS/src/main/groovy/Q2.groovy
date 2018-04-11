class Employee extends Person {
    def empId;
    def company;
    def salary;

    def getEmpId() {
        return empId
    }

    void setEmpId(empId) {
        this.empId = empId
    }

    def getCompany() {
        return company
    }

    void setCompany(company) {
        this.company = company
    }

    def getSalary() {
        return salary
    }

    void setSalary(salary) {
        this.salary = salary
    }
}

class Q2 {
    static void main(def args) {

        Employee employee = new Employee();
        employee.name = "Pushkar";
        employee.address = "Sector-137";
        employee.gender = "Male";
        employee.age = 23;
        employee.empId = "pushkar.singh@tothenew.com";
        employee.company = "TO_THE_NEW";
        employee.salary = 15100;

        String paragraph = """
sdfasfsad $employee
sadfasdfa
asdfasf
sadf



"""
        println(employee.getName() + " " + employee.getAddress() + " " + employee.getGender() + " " + employee.getAge() + " " + employee.getEmpId() + " " + employee.getCompany() + " " + employee.getSalary());

        println(employee.name + " " + employee.address + " " + employee.gender + " " + employee.age + " " + employee.empId + " " + employee.company + " " + employee.salary);

        println(employee.name + " " + employee.address + " " + employee.gender + " " + employee.age + " " + employee.@empId + " " + employee.@company + " " + employee.@salary);
    }
}
