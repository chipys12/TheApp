package sample;

import javafx.scene.control.Label;

public class Account {
        int balance;
        int firstBalance;
        int deposit;
        int withdraw;
        String name;

        public Account(String name, int firstBalance, int deposit, int withdraw){
            this.firstBalance = firstBalance;
            this.deposit = deposit;
            this.withdraw = withdraw;
            this.name = "";
        }
        public void uvitani(){
            System.out.println("Vítejte " + name + " na vašem účtě. Můžete si zkontrolovat stav účtu, vybrat nebo vložit peníze.");
            balance = firstBalance + balance;
        }
        public void checkBalance(){
            System.out.println("***NewAction***");
            System.out.println("Your actual balance is " + balance + "Kč.");
        }
        public void depositMoney(){
            System.out.println("***NewAction***");
            System.out.println("Your balance before deposit is " + balance + "Kč.");
            balance = balance + deposit;
            System.out.println("You've just deposited " + deposit + ". Your actual balance is " + balance + "Kč.");
        }
        public void withdrawMoney(){
            System.out.println("***NewAction***");
            System.out.println("Your balance before withdraw is " + balance + "Kč.");
            balance = balance - withdraw;
            System.out.println("You've just withdrawed " + withdraw + "Kč. Your actual balance is " + balance + "Kč.");
        }
        public void newDeposit(int newDeposit){
            //zvoleno 200 Kč vklad.
            System.out.println("***NewAction***");
            if (newDeposit > 0){
                balance = balance + newDeposit;
                System.out.println("You've just deposited " + newDeposit + ". Your actual balance is " + balance + "Kč.");
            }else{
                System.out.println("Bohužel není možné vložit méně než 1 Kč");
            }
        }
        public void nasobeniPrvnihoVkladu(){
            if (deposit < 100){
                balance = deposit * 2 + balance;
            }else if (deposit == 100){
                balance = deposit * 3 + balance;
            }else{
                balance = deposit * 4 + balance;
            }
            System.out.println("Váš vklad byl zvýšel dle výše vkladu. Váš balanc je momentálně " + balance + "Kč.");
        }
        public void newWithdraw(int newWithdraw){
            System.out.println("***NewAction***");
            balance = balance - newWithdraw;
        }
        public int actualValue(){
            System.out.println("***NewAction***");
            return balance;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
}
