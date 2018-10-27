package navarro.cantero;


import java.util.Arrays;

public class Philosopher extends Thread {

    private Thread thread;
    protected int right;
    protected int left;
    protected Fork forks[];
    protected String name;
    protected int id;

    public Philosopher(String name, Fork forks[], int id) {
        this.name = name;
        this.left = this.getLeft(id);
        this.right = this.getRight(id);
        this.forks = forks;
        this.id = id;
        thread = new Thread(this);
        thread.start();
    }

    public String getNameR() {
        return name;
    }

    public int getIdR() {
        return id;
    }

    public void think() {
        try {
            System.out.println(this.getNameR() + " thinking");
            thread.sleep((int) (Math.random() * 20000));
            System.out.println(this.getNameR() + " is hungry");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void getForks() {
        System.out.println("getting forks");

        Fork forkOne = this.getForks(this.getLeft(this.getIdR()));
        Fork forkTwo = this.getForks(this.getRight(this.getIdR()));
        forkOne.use();
        forkTwo.use();
    }

    protected Fork getForks(int forkNumber) {
        return this.forks[forkNumber];
    }

    public void eat() {
        try {
            System.out.println(this.getNameR() + " is eating");
            thread.sleep((int) (Math.random() * 10000));
            System.out.println(this.getNameR() + " is eaten enough");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    protected void dropForks() {
        System.out.println(this.getNameR() + " dropping forks");

        Fork forkOne = this.getForks(this.getLeft(this.getIdR()));
        Fork forkTwo = this.getForks(this.getRight(this.getIdR()));
        forkOne.drop();
        forkTwo.drop();
    }

    protected int getRight(int forkNumber) {
        return (forkNumber + 1) % 5;
    }

    protected int getLeft(int forkNumber) {
        return forkNumber;
    }


    public void run() {
        while (true) {
            think();
            getForks();
            eat();
            dropForks();
        }
    }

    @Override
    public String toString() {
        return "Philosopher{" +
                "thread=" + thread +
                ", right=" + right +
                ", left=" + left +
                ", forks=" + Arrays.toString(forks) +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
