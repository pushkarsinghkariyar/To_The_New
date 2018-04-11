class Employee {
    String name
    Integer age
    Integer salary

    Employee(String name, Integer age, Integer salary) {
        this.name = name
        this.age = age
        this.salary = salary
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
class Q8 {
    static void main(String[] args){
        List<Employee> employeeList = new ArrayList<Employee>()
        Employee employee1= new Employee("AB",23,15100)
        employeeList.add(employee1)

        Employee employee2= new Employee("CD",22,15200)
        employeeList.add(employee2)

        Employee employee3= new Employee("EF",24,15300)
        employeeList.add(employee3)

        Employee employee4= new Employee("GH",21,15100)
        employeeList.add(employee4)

        Employee employee5= new Employee("IJ",22,15355)
        employeeList.add(employee5)

        Employee employee6= new Employee("KL",25,16500)
        employeeList.add(employee6)

        Employee employee7= new Employee("MN",20,14500)
        employeeList.add(employee7)

        Employee employee8= new Employee("OP",21,15100)
        employeeList.add(employee8)

        Employee employee9= new Employee("QR",25,14999)
        employeeList.add(employee9)

        Employee employee10= new Employee("ST",23,12500)
        employeeList.add(employee10)

        println employeeList

        println "EMPLOYEES HAVING SALARY LESS THAN 15000"
        println(employeeList.findAll {it.salary<=15000})


        List<String> minname= new ArrayList<>()
        List<String> maxname= new ArrayList<>()
        Integer minage=0, maxage=0
        for (Employee e: employeeList){
            if(minage==0 && maxage==0){
                minname.add(e.name)
                minage=e.age
                maxage=e.age
                maxname.add(e.name)
            }
            if(minage>e.age){
                minage=e.age
                minname=[]
            }
            if(maxage<e.age){
                maxage=e.age
                maxname=[]
            }
            if(minage==e.age)
                minname.add(e.name)
            if(maxage==e.age)
                maxname.add(e.name)
        }

        println("YOUNGEST PERSON " + minname)
        println("ELDEST PERSON "+ maxname)


        Integer maxsalary=0
        String ename
        for (Employee e: employeeList){
            if(maxsalary==0){
                maxsalary=e.salary
                ename=e.name
            }
            if(maxsalary<e.salary) {
                maxsalary = e.salary
                ename = e.name
            }
        }

        println("PERSON WITH MAX SALARY "+ ename + " WITH SALARY= "+maxsalary)


        println("LIST OF EMPLOYEES")
        employeeList.each {println(it.name)}

    }

}

