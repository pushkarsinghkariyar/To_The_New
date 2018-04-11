class Q7 {
    static void main(String[] args) {
        List list = [14, 12, 11, 10, 16, 15, 12, 10, 99, 90, 14, 16, 35]
        list.sort { a, b -> b <=> a }
        println list
    }
}
