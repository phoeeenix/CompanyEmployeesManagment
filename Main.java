package JanKozakZal;

public class Main {

    public static void main(String[] args) {

        List list1 = new List("list1");
        employee A = new employee("aa", "bb", 'F', 1, 2100);
        employee B = new employee("cc", "dd", 'M', 1,2900);
        employee C = new employee("ee", "ff", 'F', 2,2500);
        employee D = new employee("gg", "hh", 'M', 2,1900);
        list1.addEmployee(A);
        list1.addEmployee(B);
        list1.addEmployee(C);
        list1.addEmployee(D);
       // list1.editEmployee();
        //list1.listShortInformation();
        list1.employeesWithSalary(2000);
        list1.meanSalaryinDept(1);
        list1.highestSalaryFM();
        list1.sexFtoMDominancePercentage();
    }
}
