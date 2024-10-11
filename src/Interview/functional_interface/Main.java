package Interview.functional_interface;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Test t1=(x,y)->x+y;
        Test t2=(x,y)->x-y;
        Test t3=(x,y)->x*y;
        Test t4=(x,y)->x/y;

        System.out.println("t1 obyekti üçün implementasiya: "+t1.execute(10,5));
        System.out.println("t2 obyekti üçün implementasiya: "+t2.execute(10,5));
        System.out.println("t3 obyekti üçün implementasiya: "+t3.execute(10,5));
        System.out.println("t4 obyekti üçün implementasiya: "+t4.execute(10,5));

        //Gorunduyu kimi execute metodunun implementasiyasini her bir obyekt ucun muxtelif formada ede bilirik
    }
}
