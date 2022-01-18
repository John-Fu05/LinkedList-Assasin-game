package Final_project;

//CS211 Justin Xiao and Tianlin Fu  
//FinalProject
//15 June 2020
//Chapter 16 #4 
//This is the class that performs the assassin game, can be used to store a list of E values.
//Due to unclear instruction from the book my group had to search online for more clear specifications
//we came across this web page and decided our approach to the project from here:
//https://courses.cs.washington.edu/courses/cse143/19wi/handouts/assassin.html
import java.util.List;
import java.util.Random;

public class Assassin {
	// stores the kill ring and graveyard so that it can be accessed
	// create the size variable
	private AssassinNode killRing;
	private AssassinNode graveyard;
	private int size;

	// takes in a list of names to connect together to form our kill ring
	// pre: The list of names has at least one name (is not empty)
	// post: Builds a kill ring of individually connected assassin nodes
	public Assassin(List<String> datas) {
		if (datas == null || datas.size() == 0) {
			throw new IllegalArgumentException("No datas to process!");
		}
		for (int i = 0; i < datas.size(); i++) {
			size++;
			String data = datas.get(i);
			AssassinNode assassin = new AssassinNode(data);
			if (killRing == null) {
				killRing = assassin;
			} else {
				AssassinNode current = killRing;
				while (current.next != null) {
					current = current.next;
				}
				current.next = assassin;
			}
		}
	}

	// get the size of the kill ring
	public int size() {
		return size;
	}

	// prints the players that are currently in the kill ring and who they are
	// stalking
	public String printKillRing() {
		if (killRing == null) {
			return "[]";
		} else {
			String result = "[" + killRing.data;
			AssassinNode current = killRing.next;
			while (current != null) {
				result += " , " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// prints the players that are currently in graveyard
	public String printGraveyard() {
		if (graveyard == null) {
			return "[]";
		} else {
			String result = "[" + graveyard.data;
			AssassinNode current = graveyard.next;
			while (current != null) {
				result += " , " + current.data;
				current = current.next;
			}
			result += "]";
			return result;
		}
	}

	// check if the game is over
	// return whether or not there is one person left in the kill ring
	public boolean isGameOver() {
		return (killRing.next == null);
	}

	// prints the winner's name
	// return the name of the last person left in the kill ring
	public String winner() {
		return (String) killRing.data;
	}

	// gets and returns a random name from the kill ring
	public String getRandomName() {
		Random rand = new Random();
		int random = rand.nextInt(size);
		AssassinNode current = killRing;
		for (int i = 0; i < random; i++) {
			current = current.next;
		}
		return (String) current.data;
	}

//	public void killAll() {
//		while (!isGameOver()) {
//			System.out.println(size);
//			System.out.println(printKillRing());
//			System.out.println(printGraveyard());
//			System.out.println();
//			kill(getRandomName());
//		}
//
//	}

	// prints the name of the most recently killed member
	public String recentDeceased() {
		if (graveyard == null) {
			return " ";
		} else {
			return (String) graveyard.data;
		}
	}

	// pre: game is not over && the kill ring contains the given name
	// post: removes victim from the kill ring,
	// then moves them to the front of the graveyard.
	public void kill(String data) {
		if (isGameOver()) {
			throw new IllegalStateException();
		}
		AssassinNode killed = null;
		if (killRing.data.equals(data)) { // if victim is at front of kill ring
			killed = killRing;
			killRing = killRing.next;
		} else { // if victim isn't at front of kill ring
			AssassinNode current = killRing;
			while (current.next != null) {
				if (current.next.data.equals(data)) {
					killed = current.next;
					if (current.next.next != null) { // if there is someone after the victim in list
						current.next = current.next.next;
						break;
					} else { // if there isn't someone after the victim
						current.next = null;
						break;
					}
				}
				current = current.next;
			}
		}
		size--;
		// place the victim at the front of the graveyard
		if (graveyard != null) {
			killed.next = graveyard;
		} else {
			killed.next = null;
		}
		graveyard = killed;
	}
}