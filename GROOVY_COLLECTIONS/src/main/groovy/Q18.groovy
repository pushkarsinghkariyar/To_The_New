class Q18 {
    static void main(String[] args){
        Map<String,Integer> map= new HashMap<>()
        map.put("Pushkar",23)
        map.put("Swapnil",22)
        map.put("Archit",22)
        map.put("Payal",22)
        map.put("Neelesh",21)
        map.put("Shreyansh",22)
        map.put("Ankit",25)
        map.put("Sanakalp",24)
        map.put("Ajay",23)
        map.put("Prachi",25)

        println map.class
        println map.getClass()

        //if we type map.class it searches inside the map for a key named "class"
        //if we type map.getClass() it returns the java class to which map belongs to
    }
}