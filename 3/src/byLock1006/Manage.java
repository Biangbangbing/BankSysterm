package byLock1006;

public class Manage {
    public static void main(String[] args){
        ByBankSys byBankSys = new ByBankSys(100000);
//        User user = new User("stefan",200000,byBankSys);
//        User user1 = new User("eazin",200000,byBankSys);
//        user.start();
//        user1.start();
        User2 user = new User2("stefan",200000,byBankSys);
        new Thread(user).start();
        new Thread(user).start();
    }
}
