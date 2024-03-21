public class Main {
    public static void main(String[] args) {
        Chronometer chrono = new Chronometer();

        chrono.start();
        chrono.pause();
        chrono.start();
        chrono.stop();
        chrono.reset();
    }
}