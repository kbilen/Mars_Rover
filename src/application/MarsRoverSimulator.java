
package application;

import java.util.HashSet;
import java.util.Set;

import model.Command;
import model.ForwardCommand;
import model.RightCommand;
import model.Rover;
import model.LeftCommand;
import model.BackwardCommand;


public class MarsRoverSimulator {
    public static void main(String[] args) {
        Set<String> obstacles = new HashSet<>();
        obstacles.add("2,2");
        obstacles.add("3,4");

        Rover rover = new Rover(0, 0, 'N', obstacles);

        // Création et exécution des commandes
        Command[] commands = {
            new ForwardCommand(rover),
            new ForwardCommand(rover),
            new RightCommand(rover),
            new ForwardCommand(rover),
            new ForwardCommand(rover)
        };

        for (Command command : commands) {
            command.execute();
        }

        rover.printPosition();
    }
}