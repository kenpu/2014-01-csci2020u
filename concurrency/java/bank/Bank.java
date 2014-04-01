class Bank {
    public float balance;
    public Bank(float b) {
        this.balance = b;
    }
    public synchronized void withdraw(float amt) {
        this.balance = this.balance - amt;
    }
    public synchronized void deposit(float amt) {
        this.balance = this.balance + amt;
    }
}
