package JanKozakZal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashSet;
import java.util.Scanner;

public class List {

    private ArrayList<employee> employeesList = new ArrayList<employee>();
    private ArrayList<ArrayList<employee>> listOfLists = new ArrayList<ArrayList<employee>>();
    private HashSet<Integer> listOfDept = new HashSet<Integer>();
    private String tempS;
    private employee tempE = new employee();

    public List(String nameOfList) {
        tempS = nameOfList;
        ArrayList<employee> tempS = new ArrayList<employee>();
        listOfLists.add(tempS);
    }

    public void listShortInformation() {
        //ArrayList<String> lseArray = new ArrayList<String>();
        System.out.println("List short information:");
        for (employee e : employeesList) {
            /*String lsi = */e.shortInformation();
            //lseArray.add(lsi);
            //System.out.println(lsi);
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            }
    }

    public employee addEmployee(){
        System.out.println("Enter a name and surname of new employee");
        Scanner scan1 = new Scanner(System.in);
        employee e = new employee();
        e.setName(scan1.next());
        e.setSurname(scan1.next());
        employeesList.add(e);
        System.out.println("New employee have just been added: \n" + e.SpecialInformation());
        System.out.println("-------------------------------------------------------------------------------------");
        return e;
    }

    public employee addEmployee(employee e){
        employeesList.add(e);
        listOfDept.add(e.getDeptNo());
        System.out.println("New employee have just been added: \n" + e.SpecialInformation());
        System.out.println("-------------------------------------------------------------------------------------");
        return e;
    }

    public void exportToFile(String fileName, int id) {
        try {
            FileWriter writerf1 = new FileWriter(fileName);
            writerf1.write(employeesList.get(id).Information());
            writerf1.close();
            System.out.println("The file " + fileName + " has been created");
        }
            catch (IOException ioex) {
                ioex.printStackTrace();
            }
        }

        public void deleteEmployee() {
            listShortInformation();
            System.out.println("Enter a name and surname of employee you want to delete from a list");
            Scanner scan1 = new Scanner(System.in);
            for (int i = 0; i < employeesList.size(); i++) {
                if (scan1.next().equalsIgnoreCase(employeesList.get(i).getName()) && scan1.next().equalsIgnoreCase(employeesList.get(i).getSurname())) {
                    System.out.println("An employee " + employeesList.get(i).getName() + " " + employeesList.get(i).getSurname() + " has been removed");
                    employeesList.remove(i);
                }
            }
            listShortInformation();
        }

        public void editEmployee(){
            System.out.println("-------------------------------------------------------------------------------------");
            System.out.println("-------------------------------------------------------------------------------------");
            listShortInformation();
            System.out.println("Enter a name and surname of employee you want to edit from a list");
            Scanner scan1 = new Scanner(System.in);
            String c = scan1.next();
            String b = scan1.next();
            for (int i = 0; i < employeesList.size(); i++) {
                if (c.equalsIgnoreCase(employeesList.get(i).getName()) && b.equalsIgnoreCase(employeesList.get(i).getSurname())) {
                    System.out.println("Which position you want to edit? Enter a number\n1. Surname\n2. Department number\n3. Salary\n4. Children number\n5. Marital status");
                    int a = scan1.nextInt();
                    if (a == 1) {
                        System.out.println("Enter a new surname");
                        employeesList.get(i).setSurname(scan1.next());
                        System.out.println("A surname has been edited");
                    }
                    if (a == 2) {
                        System.out.println("Enter a new department number");
                        employeesList.get(i).setDeptNo(scan1.nextInt());
                        System.out.println("A department number has been edited");
                    }
                    if (a == 3) {
                        System.out.println("Enter a new salary");
                        employeesList.get(i).setSalary(scan1.nextFloat());
                        System.out.println("A salary has been edited");
                    }
                    if (a == 4) {
                        System.out.println("Enter a new children number");
                        employeesList.get(i).setChildrenNo(scan1.nextInt());
                        System.out.println("A number of children has been edited");
                    }
                    if (a == 5) {
                        System.out.println("Enter \"true\" or \"false\" as a new marital status");
                        employeesList.get(i).setMarried(scan1.nextBoolean());
                        System.out.println("A marital status has been edited");
                    }
                    else if (a > 5 || a < 1)
                        System.out.println("Wrong name was entered. Try again");
                    employeesList.get(i).Information();
                }
        }

    }

    public String employeesWithSalary(float salaryToCompare) {
        String ews = "";
        System.out.println("Employees with salary at least = " + salaryToCompare);
        for(int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getSalary() >= salaryToCompare) {
                ews = employeesList.get(i).SpecialInformation();
                System.out.println(ews);
            }
        }
        return ews;
    }

    public float meanSalaryinDept(int number) {
        int numberEmployees = 0;
        float salarySum = 0;
        float averageSalary;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getDeptNo() == number) {
                salarySum += employeesList.get(i).getSalary();
                numberEmployees++;
            }
        }
        averageSalary = salarySum / numberEmployees;
        System.out.println("Average salary of department number " + number + " stand at: " + averageSalary);
        return averageSalary;
    }

    public float highestSalaryFM(){
        System.out.println("Enter a number of department number wherein you want to find the highest salary for female and male sex " +
                "or enter \"-1\" to find for all employees in a company");
        Scanner scan1 = new Scanner(System.in);
        int tempScan = scan1.nextInt();
        float salaryMaxF = employeesList.get(0).getSalary();
        float salaryMaxM = employeesList.get(0).getSalary();
        int posF = 0;
        int posM = 0;
        if (tempScan == -1)
            for (int i = 0; i < employeesList.size(); i++) {
                    if (employeesList.get(i).getSex() == 'F') {
                        if (employeesList.get(i).getSalary() > salaryMaxF) {
                            salaryMaxF = employeesList.get(i).getSalary();
                            posF = i;
                        }
                    } else if (employeesList.get(i).getSex() == 'M') {
                        if (employeesList.get(i).getSalary() > salaryMaxM) {
                            salaryMaxM = employeesList.get(i).getSalary();
                            posM = i;
                        }
                    }
            }
        if (tempScan != -1)
            for (int i = 0; i < employeesList.size(); i++) {
                    if (employeesList.get(i).getDeptNo() == tempScan) {
                        if (employeesList.get(i).getSex() == 'F') {
                            if (employeesList.get(i).getSalary() > salaryMaxF) {
                                salaryMaxF = employeesList.get(i).getSalary();
                                posF = i;
                            }
                        } else if (employeesList.get(i).getSex() == 'M') {
                            if (employeesList.get(i).getSalary() > salaryMaxM) {
                                salaryMaxM = employeesList.get(i).getSalary();
                                posM = i;
                            }
                        }
                    }
            }
        String tempDisplay;
        if (tempScan == -1)
            tempDisplay = "all";
        else
            tempDisplay = Integer.toString(tempScan);
        System.out.println("The highest salary from department number " + tempDisplay + " has " + employeesList.get(posF).getName() + " " + employeesList.get(posF).getSurname()  + " with " + salaryMaxF + " salary from female sex");
        System.out.println("The highest salary from department number " + tempDisplay + " has "+ employeesList.get(posM).getName() + " " + employeesList.get(posM).getSurname()  + " with " + salaryMaxM + " salary from male sex");
        return Math.max(salaryMaxF, salaryMaxM);
    }

    public float sexFtoMDominancePercentage(){
        System.out.println("Choose a department number wherein you want to display a sex dominance result. For all departments enter \"-1\"");
        for (int dept : listOfDept)
            System.out.println(dept);
        System.out.println("------------");
        Scanner scan1 = new Scanner(System.in);
        int no = scan1.nextInt();
        int noF = 0;
        int noM = 0;
        if (no == -1)
            for (int i = 0; i < employeesList.size(); i++){
                    if (employeesList.get(i).getSex() == 'F')
                        noF++;
                    else if (employeesList.get(i).getSex() == 'M')
                        noM++;
            }
        else if (no != -1)
            for (int i = 0; i < employeesList.size(); i++){
                if (employeesList.get(i).getDeptNo() == no)
                    if (employeesList.get(i).getDeptNo() == no){
                        if (employeesList.get(i).getSex() == 'F')
                            noF++;
                        else if (employeesList.get(i).getSex() == 'M')
                            noM++;
                    }
            }
        String displayNo;
        if (no == -1)
            displayNo = "all";
        else
            displayNo = Integer.toString(no);
        float ratioReturn;
        float ratio;
        try {
            ratio = noF / noM * 100;
            ratioReturn = noF / noM;
            Formatter ratioF = new Formatter();
            ratioF.format("%.2f", ratio);
            String ratioToDisplay = ratioF.toString();
            System.out.println("Ratio of female to male sex in department no " + displayNo + " stand at " + ratioToDisplay + " %");
        }
        catch(ArithmeticException ae) {
            ratio = 0;
            ratioReturn = 0;
            System.out.println("Number of male sex is 0. The ratio department no " + displayNo + " stand at 0% for male to female sex");
        }
        return ratioReturn;
    }

}

