class Stack{
    List<Integer> list = new ArrayList<>()

    void push(Integer num){
        this.list.add(num)
    }

    void pop(){
        this.list.remove(this.list.size()-1)
    }

    Integer top(){
        return this.list.last()

    }

}
class Q15 {
    static void main(String[] args){

        Stack stack = new Stack()
        stack.push(1)
        stack.push(2)
        println stack.top()
        stack.push(3)
        stack.push(4)
        stack.pop()
        println stack.top()

    }
}
