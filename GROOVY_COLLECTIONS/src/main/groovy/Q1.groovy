class Q1 {
    static void main(String[] args) {
        List list = []
        list[11] = "myelement"
        println list[11]
        println list.get(5)
        println list
        list = 0..10
        list.each { if (it % 2 == 0) print it + ", " }
    }
}
