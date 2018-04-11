class Q19 {
    static void main(String[] args){
        Map m = ['1' : 2, '2' : 3, '3' : 4, '2':5]

        println m.getClass()
        println(m)

        //there will not be any error but its not a good practice to insert a key twice in a map
        //although the second value corresponding to that key overwrites the previous value
    }
}
