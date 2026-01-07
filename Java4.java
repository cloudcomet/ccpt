class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    void displayPerson(){
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

class Student extends Person{
    int m1,m2,m3,total;
    float percentage;
    Student(String name, int age, int m1, int m2, int m3){
        super(name, age);
        this.m1 = m1;
        this.m2 = m2;
        this.m3 = m3;
        calculate();
    }
    void calculate(){
        total = m1 + m2 + m3;
        percentage = total / 3.0f;
    }
    void displayStudent(){
        displayPerson();
        System.out.println("Marks: " + m1 + ", " + m2 + ", " + m3);
        System.out.println("Total: " + total + ", Percentage: " + percentage);
    }
}

class Teacher extends Person{
    int sal;
    Teacher(String name,int age,int sal){
        super(name,age);
        this.sal=sal;
    }
    void displayTeacher(){
        displayPerson();
        System.out.println("Salary is "+sal);
    }
}


class Java4 {
    public static void main(String[] args) {
        Student s1=new Student("arun",20, 50, 60, 40);
        s1.displayStudent();
        Teacher t1=new Teacher("Jon",45,40000);
        t1.displayTeacher();

    }
}