public class StoppedState implements State {
    private Chronometer chrono;
    public StoppedState(Chronometer chrono) {
        this.chrono = chrono;
    }
    @Override
    public void start() {
        System.out.println("Démarrage du chronomètre.");
        chrono.setState(chrono.getStartedState());
        chrono.setCurrentTime(0);
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
