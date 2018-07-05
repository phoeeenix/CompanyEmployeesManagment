package JanKozakZal;

public class employee {

    private String name;
    private String surname;
    private char sex;
    private int deptNo;
    private float salary;
    private int childrenNo;
    private boolean married;
    private int age;

    public employee(String name, String surname){
    }

    public employee(){
    }

    public employee(String name, String surname, char sex, int deptNo, float salary){
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        this.deptNo = deptNo;
        this.salary = salary;
    }

    public String Information() {
        String answear = "name: " + name + "\nsurname: " + surname + "\nsex: " + sex + "\ndept number: " + deptNo
                + "\nsalary: " + salary + "\nchildren numer: " + childrenNo + "\nmarried: " + married;
        System.out.println(answear);
        System.out.println("-------------------------------------------------------------------------------------");
                return answear;
    }

    public String shortInformation() {
        String answear = "name: " + name + "\nsurname: " + surname + "\nsalary: " + salary;
        System.out.println(answear);
        System.out.println("-------------------------------------------------------------------------------------");
        return answear;
    }

    public String SpecialInformation() {
        String answear = "name: " + name.toUpperCase() + "\nsurname: " + surname.toUpperCase();
        //System.out.println(answear);
        System.out.println("-------------------------------------------------------------------------------------");
        return answear;
    }

    public boolean salaryMoreThan(float number) {
        if (salary > number)
            return true;
        else
            return false;
    }

    public float payRise(int percentage) {
        float newSalary = 0;
        if (percentage < 0)
            System.out.println("The percentage of pay rise must be higher than 0");
        else {
            newSalary = salary * (1 + percentage / 100 + 0.02f * childrenNo /*+ 0.03 * married*/);
            if (married == true)
                newSalary += salary * 0.03;
        }
        return newSalary;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public char getSex() {
        return sex;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public float getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }

    public int getChildrenNo() {
        return childrenNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
        System.out.println("Department number has been changed");
    }

    public void setSalary(float salary) {
        this.salary = salary;
        System.out.println("Salary has been changed");
    }

    public void setMarried(boolean married) {
        this.married = married;
        System.out.println("Marital status has been changed");
    }

    public void setChildrenNo(int childrenNo) {
        this.childrenNo = childrenNo;
        System.out.println("Number of children has been changed");
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("Name has been changed");
    }

    public void setSurname(String surname) {
        this.surname = surname;
        System.out.println("Surame has been changed");
    }

    public void setSex(char sex) {
        this.sex = sex;
        System.out.println("Sex has been set up");
    }

    public void setAge(int age) {
        this.age = age;
        System.out.println("Age has been set up");
    }
}
