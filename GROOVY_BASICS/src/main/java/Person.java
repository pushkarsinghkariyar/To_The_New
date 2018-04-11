public class Person {
    String name;
    String address;
    String gender;
    Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static void main(String[] args) {
        Person person= new Person();
        person.setName("Pushkar");
        person.setAddress("Sector-137");
        person.setGender("Male");
        person.setAge(23);



        System.out.println(person.getName()+" "+ person.getAddress()+" "+person.getGender()+" "+person.getAge());

        System.out.println(person.name+" "+ person.address+" "+person.gender+" "+person.age);

    }
}
