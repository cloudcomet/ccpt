// class Employee {
//     String name;
//     int eid;
//     Employee(String name, int eid) {
//         this.name = name;
//         this.eid = eid;
//     }
// }
class Ex1{
    void fun(int x){
        System.out.println("Ex1");
    }
}

class Ex extends Ex1{
    void fun(int x){
        System.out.println("Ex int");
    }
}




class java5 {
    public static void main(String[] args) {
        Ex e1 = new Ex();
        //e1.fun();
        e1.fun(10);
    }
}
