package damic;

public class User implements IUser {
    @Override
    public void buyComputer() {
        System.out.println("买电脑");
    }

    @Override
    public void payMoney() {
        System.out.println("付钱");
    }
}
