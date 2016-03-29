// WE MAY USE ANOTHER DRIVER TO TEST YOUR PROGRAM

import java.io.*;

public class GameMain {

    public static void main(String[] args) throws IOException {

        // the parameter passed to the constructors represents
        // the number of players in this game.
        // In the following, there are three players playing
        // Old Maid together, four playing Big2, and five
        // playing Last Card

        System.out.println(
            "************\n" +
            "* OLD MAID *\n" +
            "************\n");

        OldMaid oldmaidgame = new OldMaid(3);
        oldmaidgame.playOneGame();

        System.out.println(
            "\n***********\n" +
            "* BIG TWO *\n" +
            "***********\n");
        Big2 big2game = new Big2(4);
        big2game.playOneGame();

        System.out.println(
            "\n*************\n" +
            "* LAST CARD *\n" +
            "*************\n");
        LastCard lastcardgame = new LastCard(5);
        lastcardgame.playOneGame();
    }
}
