class Prog {
    public static void main(String[] args) {
        Bank bank = new Bank(100);
        Customer cust = new Customer(bank);
        Creditcard card = new Creditcard(bank);

        card.start();
        cust.start();

        try {
            cust.join();
            card.join();
        } catch(InterruptedException e) {
            ;
        }

        System.out.println("$" + bank.balance);
    }
}
