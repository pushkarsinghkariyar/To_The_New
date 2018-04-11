class Employees {
    String name
    Integer age
    String department
    Integer employeenumber
    Integer salary

    Employees(String name, Integer age, String department, Integer employeenumber, Integer salary) {
        this.name = name
        this.age = age
        this.department = department
        this.employeenumber = employeenumber
        this.salary = salary
    }

    @Override
    public String toString() {
        return "Employeess{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

class Q22 {
    static void main(String[] args) {
        List<Employees> employeeList = new ArrayList<Employees>()
        Employees employee1 = new Employees("AB", 23, "Spring", 1, 15100)
        employeeList.add(employee1)

        Employees employee2 = new Employees("AB", 22, "Spring", 2, 15200)
        employeeList.add(employee2)

        Employees employee3 = new Employees("EF", 24, "Spring", 3, 15300)
        employeeList.add(employee3)

        Employees employee4 = new Employees("GH", 21, "Grails", 4, 15100)
        employeeList.add(employee4)

        Employees employee5 = new Employees("IJ", 22, "Grails", 5, 15355)
        employeeList.add(employee5)

        Employees employee6 = new Employees("KL", 25, "Grails", 6, 16500)
        employeeList.add(employee6)

        Employees employee7 = new Employees("MN", 20, "Front End", 7, 14500)
        employeeList.add(employee7)

        Employees employee8 = new Employees("OP", 21, "Front End", 8, 15100)
        employeeList.add(employee8)

        Employees employee9 = new Employees("QR", 25, "DevOps", 9, 14999)
        employeeList.add(employee9)

        Employees employee10 = new Employees("ST", 23, "Testing", 10, 12500)
        employeeList.add(employee10)

        //println employeeList

        println("Emp by salary range :" + employeeList.groupBy { it -> it.salary > 10000 && it.salary <= 15000 })

        println("Emp groupied by multiple  :" + employeeList.groupBy({ it.name[0] }))
        println("Emp groupied by multiple  :" + employeeList.groupBy({ it.name[0] }).collectEntries { k, v -> [k, v.size()] })

        println("Emp count per dept: " + employeeList.countBy { it -> it.department })
//

        def result = employeeList.groupBy { it -> it.age >= 18 && it.age <= 35 }.get(true)

        println("Emp between 18 to 35 age: " + result)
        println("Emp between 18 to 35 age: " + employeeList.groupBy { it -> it.age >= 18 && it.age <= 35 }.collectEntries { k, v -> [k, v] })

    }

}