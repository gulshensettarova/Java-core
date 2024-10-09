package OCA;

import OCA.Practice.Base;
import OCA.Practice.Base2;

import java.util.ArrayList;

public class MockExam_1 {

    public static void main(String[] args) throws Exception {
        String[] sa = {"a", "b", "c"};
        for(String s :  sa){
            if("b".equals(s)) continue;
            System.out.println(s);
            if("b".equals(s)) break;
            System.out.println(s+" again");
            ArrayList<String> list=new ArrayList<>();
        }
    }

}
