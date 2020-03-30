package src;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;

public class main {

    public static int[] hashes = {1212, 2036, 1024, 9000};
    public static int johnTally, janeTally = 0;
    public static Vote[] votes;

    public static Voter getVoterInfo() {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter your first and last name:");
        String name = in.nextLine();

        System.out.println("Enter your DOB (mmddyyyy):");
        int DOB = in.nextInt();

        System.out.println("Enter your SSN (no dashes):");
        int SSN = in.nextInt();

        return new Voter(name, DOB, SSN);
    }

    public static Vote requestVote(Voter v) {
        Scanner in = new Scanner(System.in);
        System.out.println("You have been registered. Enter your vote (0 to vote for John Doe and 1 to vote for Jane Doe):");
        int vote = in.nextInt();

        if (vote == 0) {
            System.out.println("Your vote for John Doe has been recorded.");
        }
        if (vote == 1) {
            System.out.println("Your vote for Jane Doe has been recorded.");
        }

        return new Vote(vote, "President", v);
    }

    /*public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        long currentTime = startTime;
        while(currentTime < startTime + 20000) {
            Voter v = getVoterInfo();
            if(!v.isValid(hashes)) {
                System.out.println("Invalid credentials");
            }
            else {
                Vote vote = requestVote(v);
                String voteString = vote.getVoteString();

                try (FileWriter fw = new FileWriter("./src/Blockchain.txt", true);
                     BufferedWriter bw = new BufferedWriter(fw);
                     PrintWriter out = new PrintWriter(bw)) {
                    out.println(voteString);
                } catch (IOException e) {
                }
            }
            currentTime = System.currentTimeMillis();
        }
    }
    */
}
