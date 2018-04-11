class HourMinute{
    Integer hours;
    Integer minute;

    HourMinute(Integer hours, Integer minute) {
        this.hours = hours
        this.minute = minute
    }

    HourMinute plus(HourMinute a){
        this.minute+=a.minute;
        this.hours+=a.hours;
        if(this.minute>=60){
            this.minute=this.minute%60;
            this.hours=(this.hours+1)%24;
        }
        return this;
    }

    HourMinute minus(HourMinute a){
        this.minute-=a.minute;
        this.hours-=a.hours;
        if(this.minute<0){
            this.minute=60+this.minute;
            this.hours--;
            if(this.hours<0){
                this.hours=23;
            }
        }
        return this;
    }


    @Override
    public String toString() {
        return "HourMinute{" +
                "hours=" + hours +
                ", minute=" + minute +
                '}';
    }
}

class Q5 {
    static void main(String[] args) {
//        if('test'){
//            println "test evaluated to true inside if"
//        }
//        if('null'){
//            println "test evaluated to true inside if"
//        }
//        if(null){
//            println "test evaluated to true inside if"
//        }
//        if(100){
//            println "test evaluated to true inside if"
//        }
//        if(0){
//            println "test evaluated to true inside if"
//        }
//       List list=[]
//        if(list){
//            println "test evaluated to true inside if"
//        }
//        List list= new ArrayList()
//        if(list){
//            println "
// test evaluated to true inside if"
//        }

        HourMinute obj1= new HourMinute(9,58);
        HourMinute obj2= new HourMinute(1,20);

        HourMinute obj3= obj1-obj2;
        println(obj3);

        HourMinute obj4= obj1-obj2;
        println(obj4);


    }
}
