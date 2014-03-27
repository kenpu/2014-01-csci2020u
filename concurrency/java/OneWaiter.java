class OneWaiter {
    public OneWaiter(Customer[] customers) {
        for(Customer c : customers) {
            while(! c.request()) {
                ;
            }
        }
    }
}
