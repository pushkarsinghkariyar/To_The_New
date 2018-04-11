class Q14 {
    static void main(String[] args){
        100.times {
            if((it+1)%3==0 && (it+1)%5==0) print "FizzBuzz, "
            else if((it+1)%3==0) print "Fizz, "
            else if((it+1)%5==0) print "Buzz, "
            else print ((it+1)+", ")
        }
    }
}
