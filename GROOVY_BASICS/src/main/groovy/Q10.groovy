class Q10 {
    static void main(String[] args){
        File newfile1= new File("/home/pushkar/Desktop/Sample/newfile1.txt")
        new File("/home/pushkar/Desktop/Sample/file.txt").eachLine{
            line ->
            newfile1 << line.split(" ").join().trim()

        }
        println(newfile1.text)
    }
}
