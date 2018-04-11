class Q6 {

    static void main(String[] args){
        println("Method 1- USING FOR LOOP")
        for(Integer i=1;i<=10;i++)
            println(i*3)

        println("Method 2- USING WHILE LOOP")
        Integer i=1;
        while(i<=10){
            println(i*3)
            i++
        }
        println("Method 3- USING TIMES LOOP")
        i=1
        10.times {
            println(i*3)
            i++;
        }
    }
}
