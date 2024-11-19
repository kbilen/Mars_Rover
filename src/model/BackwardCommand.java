package model;

public class BackwardCommand implements Command {
	
    private final Rover rover;

    public BackwardCommand(Rover rover) {
        this.rover = rover;
    }

    @Override
    public void execute() {
        rover.moveBackward();
    }
}