class Q17{
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

        Map<String,Integer> map1= new HashMap<>()
        map.put("Shrishti",23)
        map.put("Shefali",22)

        Map<String,Integer> map2= new HashMap<>()
        map2=map1+map
        println map2
    }
}