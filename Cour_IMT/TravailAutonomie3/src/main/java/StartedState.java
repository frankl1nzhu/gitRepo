public class StartedState implements State {
    private Chronometer chrono;
    public StartedState(Chronometer chrono) {
        this.chrono = chrono;
    }
    @Override
    public void start() {
        System.out.println("Le chronomètre est démarré.");
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
