import java.util.*;

class Customer {
    public String name;
    public Random rand;
    public Customer(String name) {
        this.name = name;
        this.rand = new Random();
    }
    public boolean request() {
        boolean done = false;
        System.out.printf("[%s]: what does this mean?\n", this.name);
        try {
            Thread.sleep(this.rand.nextInt(5000));
        } catch(InterruptedException e) {
            ;
        }
        done = (this.rand.nextFloat() > 0.7);

        if(done) 
            System.out.printf("[%s]: I'm all good now.\n", this.name);
        return done;
    }
}
