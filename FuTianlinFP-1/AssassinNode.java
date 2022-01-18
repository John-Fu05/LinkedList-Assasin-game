package Final_project;

//CS211 Justin Xiao and Tianlin Fu 
//FinalProject
//15 June 2020
//Chapter 16 #4 
//A class for storing a single node of an Assassin list,
//this node class is for storing a list of E values.
public class AssassinNode<E> {

	public E data; // data stored in this node
	public AssassinNode next; // link to next node in the list

	// post: constructs a node with given data and given link
	public AssassinNode(E name, AssassinNode next) {
		this.data = name;
		this.next = next;
	}

	// post: constructs a node with given data and null link
	public AssassinNode(E data) {
		this(data, null);
	}

	// post: constructs a node with data 0 and null link
	public AssassinNode() {
		this(null, null);
	}
}
