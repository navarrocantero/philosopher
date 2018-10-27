package navarro.cantero;


public class Fork {

    private int id;
    private boolean ussing;

    public Fork(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    synchronized public void use() {
        if (ussing) {
            System.out.println(" can't get fork number:" + this.getId());
        } else {
            ussing = true;
            System.out.println("taken fork number:" + this.getId());
        }
    }

    synchronized public void drop() {
        ussing = false;
        System.out.println(" fork number: " + this.getId() + "is available");
    }

    @Override
    public String toString() {
        return "Fork{" +
                "id=" + id +
                ", ussing=" + ussing +
                '}';
    }
}