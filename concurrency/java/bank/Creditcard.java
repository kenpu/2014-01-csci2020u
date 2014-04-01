class Creditcard extends Thread {
    Bank bank;
    public Creditcard(Bank bank) {
        this.bank = bank;
    }
    public void run() {
        for(int i = 0; i < 1000000; i++) {
            bank.withdraw(100);
        }
    }
}
