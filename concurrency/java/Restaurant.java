public class Restaurant {
    public static void main(String[] args) {
        Customer c1 = new Customer("jack");
        Customer c2 = new Customer("mary");
        Customer c3 = new Customer("joe");
        Customer c4 = new Customer("susan");

        Customer[] customers = new Customer[]{c1, c2, c3, c4};

        // new OneWaiter(new Customer[]{c1, c2, c3, c4});
        //

        for(Customer c: customers) {
            MultiWaiter w = new MultiWaiter(c);
            w.start();
        }
    }
}
