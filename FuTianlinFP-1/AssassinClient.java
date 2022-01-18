package Final_project;

//CS211 Justin Xiao and Tianlin Fu   
//FinalProject
//15 June 2020
//Chapter 16 #4 
//The test client for the assassin game
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class AssassinClient {

	public static void main(String[] args) throws FileNotFoundException {
		List<String> names = new LinkedList();
		// adds names to list from file
		Scanner input = new Scanner(new File("names.txt"));
		String name = null;
		while (input.hasNext()) {
			name = input.next();
			names.add(name);
		}
		// randomize the list to create a different order of kill ring every round
		Collections.shuffle(names);
		Assassin h = new Assassin(names);
		// runs until there is only one player left in game
		// was a method in Assassin, however due to it having print statements we moved
		// it to the client
		while (!h.isGameOver()) {
			System.out.println("Kill ring members: " + h.printKillRing());// prints the members of kill ring
			System.out.println("Graveyard: " + h.printGraveyard());// prints the members of graveyard
			System.out.println("The most recently killed member: " + h.recentDeceased());// prints the most recently
																							// killed player
			System.out.println();
			h.kill(h.getRandomName()); // kill a random player in kill ring
		}
		System.out.println("The winner is: " + h.winner()); // prints out the winner of the round
	}

}
