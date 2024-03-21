public class Chronometer {
    private final State startedState;
    private final State pausedState;
    private final State stoppedState;
    private State currentState;
    private long currentTime;
    public Chronometer() {
        startedState = new StartedState(this);
        pausedState = new PausedState(this);
        stoppedState = new StoppedState(this);
        currentState = stoppedState;
    }
    public void start() {
        currentState.start();
    }
    public void pause() {
        currentState.pause();
    }
    public void stop() {
        currentState.stop();
    }
    public void reset() {
        currentState.reset();
    }
    public void setState(State state) {
        currentState = state;
    }
    public State getStartedState() {
        return startedState;
    }
    public State getPausedState() {
        return pausedState;
    }
    public State getStoppedState() {
        return stoppedState;
    }
    public long getCurrentTime() {
        return currentTime;
    }
    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }
}
