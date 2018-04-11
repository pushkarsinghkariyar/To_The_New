class Q5 {
    static void main(String[] args){
        List list=[0,1,2,3,4,5,6,7,8,9,10,11,12]

        Integer i,size=list.size()
        for(i=1;i<size;){
            list.remove(i)
            size--;
            i++;
        }
        println list
    }
}
