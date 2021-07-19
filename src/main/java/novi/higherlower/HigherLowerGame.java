package novi.higherlower;

public class HigherLowerGame {
    boolean gameIsRunning;
    int numberToGuess;
    int numberOfTurns;

    public void startGame() {
        gameIsRunning = true;

        Double number = Math.random() * 100;
        numberToGuess = number.intValue();

        numberOfTurns = 0;
    }

    public String performGuess(int guess) {
        numberOfTurns++;

        if (guess == numberToGuess) {
            gameIsRunning = false;
            return String.format("Correct! you guessed the number in %d turns", numberOfTurns);
        } else if (guess > numberToGuess) {
            return "That number is too high";
        } else {
            return "That number is too low";
        }
    }

    public boolean isRunning() {
        return gameIsRunning;
    }
}
