import java.util.ArrayList;
import java.util.List;

public class Addition {

    int sum(int a, int b) {
        return a + b;
    }

    String sum(String fname, String lname) {
        return fname + lname;
    }

    List sum(List lista, List listb) {
        List list = new ArrayList();
        list.addAll(lista);
        list.addAll(listb);
        return list;
    }

    Float sum(Float a, Float b){
        return a + b;
    }


}
