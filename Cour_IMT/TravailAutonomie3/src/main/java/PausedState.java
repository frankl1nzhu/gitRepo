public class PausedState implements State {
    private Chronometer chrono;
    public PausedState(Chronometer chrono) {
        this.chrono = chrono;
    }
    @Override
    public void start() {
        System.out.println("Reprise du chronomètre.");
        chrono.setState(chrono.getStartedState());
    }
    @Override
    public void pause() {
        System.out.println("Chronomètre en pause.");
        chrono.setState(chrono.getPausedState());
    }
    @Override
    public void stop() {
        System.out.println("Chronomètre arrêté.");
        chrono.setState(chrono.getStoppedState());
    }
    @Override
    public void reset() {
        System.out.println("Chronomètre remis à zéro.");
        chrono.setCurrentTime(0);
    }
}