class Q8 {
    static void main(String[] args){
        File newfile = new File("/home/pushkar/Desktop/Newfile.txt")
        File file = new File("/home/pushkar/Desktop/Sample").eachFile {file1->
            newfile << file1.getText()
        }
        println(newfile.text)
    }
}
