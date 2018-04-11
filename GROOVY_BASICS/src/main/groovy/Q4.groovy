class Q4 {
    String name;
    String address;
    String gender;
    Integer age;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }


    @Override
    public String toString() {
        return "Q4{" +
                "name='" + ${name} + '\'' +
                ", address='" + ${address} + '\'' +
                ", gender='" + ${gender} + '\'' +
                ", age=" + ${age} +
                '}';
    }
    static  void main(String[] args){
        Q4 person= new Q4();
        person.name="Pushkar";
        person.address="Sector-137";
        person.gender="Male";
        person.age=23;

        println(person.toString());
    }
}