class Q12 {
    static void main(String[] args){
        String str="a b c d e f g h i j k l m n o p q r s t u v w x y z"
        List list= str.split(" ")
        list.findAll{if(it>='j') print it + ", "}
    }
}
