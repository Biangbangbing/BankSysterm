package byLock1006;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class User extends Thread{
    String username;
    int remains;
    int credit=10;
    int MaxLoan=credit*1000;
    int loan;
    int drawMoney;
    int saveMoney;
    ByBankSys byBankSys;

    public User(String username,int remains,ByBankSys byBankSys){
        this.username = username;
        this.remains = remains;
        this.credit = 10;
        this.MaxLoan = credit*1000;
        this.loan=0;
        this.byBankSys = byBankSys;
    }


    public String getUserName() {
        return this.username;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    public int getRemains() {
        return remains;
    }

    public void setRemains(int remains) {
        this.remains = remains;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    public int getLoan() {
        return loan;
    }

    public void setLoan(int loan) {
        this.loan = loan;
    }

    public void updateMaxLoan(){
        this.MaxLoan = credit*1000;
    }

    public void setDrawMoney(int money){
        drawMoney = money;
    }

    public void setSaveMoney(int money){
        saveMoney = money;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            this.setDrawMoney(1);
            synchronized (byBankSys) {
                if (this.drawMoney > byBankSys.moneySUM)
                    System.out.println("银行金额紧缺，请换家银行取款");
                else if (this.drawMoney <= this.remains && this.drawMoney <= byBankSys.moneySUM) {
                    byBankSys.moneySUM -= drawMoney;
                    this.remains -= drawMoney;
                    System.out.println("——————————————取款凭证" + byBankSys.hashCode() + "——————————————————");
                    System.out.print("用户" + this.username + " 于 byBankSys " + "成功取出钱" + drawMoney + " 账户余额：" + this.remains + " 账户贷款金额：" + this.loan + " 账户信用：" + this.credit);
                    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
                    Date date = new Date(System.currentTimeMillis());
                    System.out.print(" 取款时间" + formatter.format(date));
                } else if (this.drawMoney <= this.remains + this.MaxLoan - this.loan) {
                    System.out.println("您的余额不足，可以进行贷款，您是否要进行贷款操作，如要贷款请按1；查看余额请按2；修改取款金额请按3；退出操作请按4");

                }
                System.out.println(" ————— SYS NOTICE："+byBankSys.moneySUM);
            }
        }
    }
}
