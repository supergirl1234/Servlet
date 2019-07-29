package damic;

public class Test {

    public static void main(String[] args) {

        DamicProxy damicProxy=new DamicProxy();
        IUser user= (IUser) damicProxy.proxyObject(new User());
       user.buyComputer();
    }
}
