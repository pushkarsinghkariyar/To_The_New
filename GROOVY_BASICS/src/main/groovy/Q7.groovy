class Q7 {
    static void main(String[] args){
        def list = [1,2,3,4]

        Closure closure = {
            List mylist,param->
                if(mylist.contains(param)){
                    println(param+" is contained in the list")
                }
                else
                    println(param+" is not in the list")

        }
        closure(list,4)
    }
}
