class Q23 {
    static void main(String[] args){
        String str= "http://www.google.com?name=johny&age=20&hobby=cricket"
        List list1= str.tokenize("?")
        println list1
        List list2= list1.get(1).tokenize("&")
        println list2
        String str1= list2.toString()
        println(str1)
        str1=str1.replace('[','')
        str1= str1.replace(']','')
        str1= str1.replace('=',',')
        str1= str1.replace(' ','')
        println(str1)

        List list3 = str1.tokenize(",")
        println(list3)

        Map<String,String> map= new HashMap<>();
        map.put(list3.get(0),list3.get(1))
        map.put(list3.get(2),list3.get(3))
        map.put(list3.get(4),list3.get(5))
        println(map)

    }
}
