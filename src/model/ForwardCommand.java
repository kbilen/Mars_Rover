package model;

public class ForwardCommand implements Command {
    private final Rover rover;

    public ForwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.moveForward();
    }
}