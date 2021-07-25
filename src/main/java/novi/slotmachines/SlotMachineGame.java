package novi.slotmachines;

import java.util.Scanner;

import novi.slotmachines.machines.Penny.PennyMachine;
import novi.slotmachines.machines.SlotMachine;
import novi.slotmachines.machines.FiveReeler.FiveReeler;
import novi.slotmachines.machines.HighRoller.HighRoller;

public class SlotMachineGame {
    private Scanner inputScanner;
    private SlotMachine[] slotMachines;
    private SlotMachine activeMachine;

    private boolean gameIsRunning;
    private int tokens;

    public SlotMachineGame(Scanner inputScanner) {
        this.inputScanner = inputScanner;
        slotMachines = new SlotMachine[] { new PennyMachine(), new HighRoller(), new FiveReeler() };
    }

    public void playGame() {
        gameIsRunning = true;
        this.tokens = 100;

        int machineIndex = pickMachine();
        activeMachine = slotMachines[machineIndex];

        activeMachine.renderIntro();
        while (gameIsRunning) {
            runGameLoop();
        }
    }

    private void runGameLoop() {
        if (tokens < activeMachine.getRollPrice()) {
            System.out.println("You don't have enough coins to roll, you lost");
            gameIsRunning = false;
            return;
        }

        var move = getNextMove();
        if (move.equals("s")) {
            System.out.printf("Thank you for playing! you have %d tokens", tokens);
            gameIsRunning = false;
            return;
        } else {
            this.tokens = tokens - activeMachine.getRollPrice();
            int winnings = activeMachine.roll();
            this.tokens = tokens + winnings;
            System.out.println(activeMachine.render());
            System.out.printf("You won %d tokens\n", winnings);
            System.out.printf("You now have %d tokens\n", tokens);
        }
    }

    private int pickMachine() {
        while (true) {
            System.out.println("Which machine do you want to play? (0 = Penny Machine, 1 = High Roller, 2 = 5-reeler)");
            int input = inputScanner.nextInt();

            if (input >= 0 && input <= 2) {
                return input;
            } else {
                continue;
            }
        }
    }

    private String getNextMove() {
        while (true) {
            System.out.println("Hit r to roll or s to stop playing");

            if (inputScanner.hasNext()) {
                String move = inputScanner.nextLine();
                if (move.equals("r") || move.equals("s")) {
                    return move;
                }
            }
        }
    }
}
