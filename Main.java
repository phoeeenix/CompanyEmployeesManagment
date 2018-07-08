package JanKozakZal;

import com.sun.xml.internal.ws.util.StringUtils;

import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        List list1 = new List("list1");
        employee A = new employee("aa", "fb", 'F', 1, 2100);
        employee B = new employee("cc", "dd", 'M', 1,2900);
        employee C = new employee("ee", "zf", 'F', 2,2500);
        employee D = new employee("gg", "hh", 'M', 2,1900);
        list1.addEmployee(A);
        list1.addEmployee(B);
        list1.addEmployee(C);
        list1.addEmployee(D);
       // list1.editEmployee();
        //list1.listShortInformation();
       // list1.employeesWithSalary(2000);
        //list1.averageSalaryinDept(1);
        //list1.highestSalaryFM();
        //list1.sexFtoMDominancePercentage();
        //list1.averageSalaryRatioFtoM();
        //list1.payRiseAll(10);
        //list1.listShortInformation();
        list1.sortBySurname();
        list1.listShortInformation();
    }
}
