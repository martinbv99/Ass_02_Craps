import java.util.Random;
import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        Random gen = new Random();
        Scanner in = new Scanner(System.in);

        int die1, die2, die3 = 0;
        int dieTotal = 0;
        int rollNum = 0;
        boolean rollDone = false;
        boolean gameWon = false;
        String playAgain;

        do
        {
            rollDone = false;
            rollNum=0;
            System.out.println("Let's play Craps!");
            System.out.println("Roll #\tDie 1\tDie 2\tDie total");
            System.out.println("__________________________________________");

            die1 = gen.nextInt(6) + 1;
            die2 = gen.nextInt(6) + 1;
            dieTotal = die1 + die2;
            rollNum++;

            System.out.printf("%6d\t%6d\t%6d\t%6d\n", rollNum, die1, die2, dieTotal);

            if (dieTotal == 7 || dieTotal == 11) {
                System.out.println("You rolled a " + dieTotal);
                gameWon = true;
            } else if (dieTotal == 2 || dieTotal == 3 || dieTotal == 12) {
                System.out.println("You rolled a " + dieTotal + " You CRAPPED!");
                rollDone = true;
                gameWon =false;
            }
            else
            {   int points = dieTotal;
                System.out.println("You have " + points + " points! Time to roll again!");

                System.out.println("Roll #\tDie 1\tDie 2\tDie total");
                System.out.println("__________________________________________");

                do
                {
                    die1 = gen.nextInt(6) + 1;
                    die2 = gen.nextInt(6) + 1;
                    dieTotal = die1 + die2;
                    rollNum++;

                    System.out.printf("%4d\t%6d\t%6d\t%6d\n", rollNum, die1, die2, dieTotal);

                    if (dieTotal == 7)
                    {
                        System.out.println("You rolled a 7!");
                        rollDone = true;

                    } else if (dieTotal == points)
                    {
                        System.out.println("You made your point!");
                        gameWon = true;
                        rollDone = true;
                    }
                } while (!rollDone);
            }

            if (gameWon)
            {
                System.out.println("You won! Good job B)");
            }
            else
            {
                System.out.println("You LOST LOSER! :P");
            }

            do
            {
                System.out.print("Do you want to play again? [Y/N]: ");
                playAgain= in.nextLine();
                playAgain = playAgain.toUpperCase();

                if (!playAgain.equals("Y") && !playAgain.equals("N"))
                {
                    System.out.println("Invalid input. Please enter Y or N");
                }

            }while(!playAgain.equals("Y") && !playAgain.equals("N"));

        }while (playAgain.equals("Y"));

    }
}