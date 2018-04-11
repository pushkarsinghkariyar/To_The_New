class Q13 {
    static void main(String[] args){
        String str= "a b c a b h j k c c b a s s d a b a"
        List list= str.split(" ")
        Integer count=0
        list.findAll {if(it=='a') count++}
        println count
    }
}
