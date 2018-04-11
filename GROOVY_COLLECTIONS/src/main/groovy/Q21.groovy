class Q21 {
    static void main(String[] args){
        Map m = ['Computing' : ['Computing' : 600, 'Information Systems' : 300],
                 'Engineering' : ['Civil' : 200, 'Mechanical' : 100],
                 'Management' : ['Management' : 800] ]

        //there are three university departments computing,engineering, management
        println(m.keySet())

        //computing department has two programs computing and information systems
        println(m.Computing)

        //civil engineering department has 200 students
        println(m.Engineering.Civil)
    }
}
