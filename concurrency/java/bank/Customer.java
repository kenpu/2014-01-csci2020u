class Customer extends Thread {
    Bank bank;
    public Customer(Bank bank) {
        this.bank = bank;
    }
    public void run() {
        for(int i = 0; i < 1000000; i++) {
            bank.deposit(100);
        }
    }
}
