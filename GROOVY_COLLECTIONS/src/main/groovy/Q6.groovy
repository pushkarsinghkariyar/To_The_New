class Q6 {
    static void main(String[] args){
        List list = [1, 2, 3, "element1", 0.3, [2, 4, 6], 0..10 ]
        println list.get(0).getClass()
        println list.get(1).getClass()
        println list.get(2).getClass()
        println list.get(3).getClass()
        println list.get(4).getClass()
        println list.get(5).getClass()
        println list.get(6).getClass()

        println list.get(6).get(9).getClass()

    }
}
