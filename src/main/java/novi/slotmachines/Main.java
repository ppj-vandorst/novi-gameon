package novi.slotmachines;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        SlotMachineGame game = new SlotMachineGame(inputScanner);
        game.playGame();
        System.out.println("\n\nThe game has ended");
    }
}