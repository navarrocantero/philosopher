package navarro.cantero;

public class Main {

    private static int forksNumber = 5;

    public static void main(String[] args) {
        String philosophers[] = {"Platon", "Descartes", "Nietzsche", "Wittgenstein", "Kant"};
        Fork forks[] = new Fork[forksNumber];
        for (int i = 0; i < forksNumber; i++) {
            forks[i] = new Fork(i);

        }
        for (int i = 0; i < forksNumber; i++) {
            Philosopher philosopher = new Philosopher(philosophers[i], forks, i);

        }

    }

}
