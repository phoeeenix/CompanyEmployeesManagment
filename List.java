package JanKozakZal;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class List {

    private ArrayList<employee> employeesList = new ArrayList<employee>();
    private ArrayList<ArrayList<employee>> listOfLists = new ArrayList<ArrayList<employee>>();
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

    public void highestSalaryFM(){
        float salaryMaxF = employeesList.get(0).getSalary();
        float salaryMaxM = employeesList.get(0).getSalary();
        int posF = 0;
        int posM = 0;
        for (int i = 0; i < employeesList.size(); i++) {
            if (employeesList.get(i).getSex() == 'F') {
                if (employeesList.get(i).getSalary() > salaryMaxF) {
                    salaryMaxF = employeesList.get(i).getSalary();
                    posF = i;
                }
            }
            else if (employeesList.get(i).getSex() == 'M') {
                if (employeesList.get(i).getSalary() > salaryMaxM) {
                    salaryMaxM = employeesList.get(i).getSalary();
                    posM = i;
                }
            }
        }
        System.out.println("The highest salary has " + employeesList.get(posF).getName() + " " + employeesList.get(posF).getSurname()  + " with " + salaryMaxF + " salary from female sex");
        System.out.println("The highest salary has " + employeesList.get(posM).getName() + " " + employeesList.get(posM).getSurname()  + " with " + salaryMaxM + " salary from male sex");
    }




}
