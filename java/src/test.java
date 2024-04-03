public class test {
    public static void main(String[] args) {
        //Integer i1 = 40;
        //Integer i2 = Integer.valueOf(40);
        System.out.println(0.2*0.2);

    }
    
}

class A{
    A(){

    }
    A(String args){
        System.out.println(args);
    }
    private String name = "test";
    public void getName(){
        System.out.println(name);
    }
}
class B extends A{
    B(){
        getName();
    }
}