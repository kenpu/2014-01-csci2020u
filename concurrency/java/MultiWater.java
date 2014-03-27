class MultiWaiter extends Thread {
    Customer c;
    public MultiWaiter(Customer c) {
        this.c = c;
    }
    public void run() {
        while(! c.request()) {
            ;
        }
    }
}
