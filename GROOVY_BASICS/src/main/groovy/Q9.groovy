class Q9 {
    static void main(String[] args){
        def flag=1
        File newfile= new File("/home/pushkar/Desktop/Sample/newfile.txt")
       new File("/home/pushkar/Desktop/Sample/file.txt").eachLine{
            line -> if(flag%2!=0){newfile<<line + "\n"
            }
            flag++
        }
        println(newfile.text)
    }
}
