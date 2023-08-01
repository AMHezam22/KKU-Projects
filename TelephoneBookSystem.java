package A_DSProject;

import java.util.Arrays;
import java.util.Scanner;

// Abdulrahman Mohammed Hezam
// 443814592
// section: 1291
class Person {
	Scanner input = new Scanner(System.in);
	private final String fName;
	private final String lName;
	private int phoneNumber;
	private final String city;
	private final String address;
	private final char sex;
	private final String email;
	public Person() {
		System.out.println("Enter First Name: ");
		this.fName = input.nextLine();
		System.out.println("Last Name: ");
		this.lName = input.nextLine();
		System.out.println("Phone Number: ");
		this.phoneNumber = input.nextInt();
//		todo: City input doesn't work
		System.out.println("City: ");
		this.city = input.nextLine();
		System.out.println("Address: ");
		this.address = input.nextLine();
		System.out.println("Sex f/m: ");
		this.sex = input.nextLine().charAt(0);
		System.out.println("Email Address: ");
		this.email = input.nextLine();
	}
	public String getfName() {
		return fName;
	}
	public int getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	@Override
	public String toString() {
		return "Person{" + "fName='" + fName + '\'' + ", lName='" + lName + '\'' + ", phoneNumber=" + phoneNumber + ", city='" + city + '\'' + ", address='" + address + '\'' + ", sex=" + sex + ", email='" + email + '\'' + '}';
	}
}
class Node {
	private Node next;
	private final Person val;
	public Node(Person val) {
		this.next = null;
		this.val = val;
	}
	public Node getNext() {
		return next;
	}
	public Person getVal() {
		return val;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
class TBSystem {
	Scanner input = new Scanner(System.in);
	private Node head;
	private int count = 0;
	void addPerson() {
		Node p = new Node(new Person());
//		check first if the linked list is empty
		if (count == 0) {
			head = p;
			System.out.println("Added");
			count++;
		} else {
			boolean t = true;
			Node temp = head;
			while (temp.getNext() != null) {
//			search while going throw the linked list if the phone number is already exist or not
				if (temp.getNext().getVal().getPhoneNumber() == p.getVal().getPhoneNumber()) {
					System.out.println("phone number Exist!, can't add this person");
					t = false;
					break;
				}
				temp = temp.getNext();
			}
			if (t) {
				temp.setNext(p);
				System.out.println("Added");
				count++;
			}
		}
	}
	void deletePerson() {
		System.out.println("Enter Phone number you want to delete it: ");
		int phone = input.nextInt();
//		in case the head is the person we want to delete it
		if (head.getVal().getPhoneNumber() == phone) {
			head = head.getNext();
			System.out.println("delete successfully ");
			count--;
		} else {
			Node temp = head;
			boolean t = true;
			while (temp.getNext() != null) {
//			check if the phone number in the linked list or not
				if (temp.getNext().getVal().getPhoneNumber() == phone) {
					temp.setNext(temp.getNext().getNext());
					System.out.println("delete successfully ");
					count--;
					t = false;
					break;
				}
				temp = temp.getNext();
			}
			if (t) {
				System.out.println("Phone number not found. ");
			}
		}
		
	}
	/**
	 * Update Phone number by giving a Person First Name
	 */
	void updatePhoneNumber() {
		System.out.println("Enter Fist name the the person you want to update his phone number: ");
		String fName = input.nextLine();
		Node temp = head;
		boolean t = true;
		while (temp != null) {
//			check if the phone number in the linked list or not
			if (temp.getNext().getVal().getfName().equals(fName)) {
				System.out.println("Enter new Phone Number: ");
				temp.getVal().setPhoneNumber(input.nextInt());
				System.out.println("Update successfully ");
				t = false;
				break;
			}
			temp = temp.getNext();
		}
		if (t) {
			System.out.println("Name not found. ");
		}
	}
	/**
	 * print all the people in the Telephone Book System
	 */
	public void displayAll() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.getVal().toString());
			temp = temp.getNext();
		}
	}
	/**
	 * Print all the phone number to those share the same first name.
	 */
	public void displayPhone() {
		System.out.println("Enter Name: ");
//		todo: Same as in City, input doesn't work
		String fName = input.nextLine();
		Node temp = head;
		while (temp != null) {
			if (temp.getVal().getfName().equals(fName)) {
				System.out.println(temp.getVal().getPhoneNumber());
			}
			temp = temp.getNext();
		}
		System.out.println("These are the All numbers have the same name. ");
	}
	void insertionSort(String[] arr) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			String key = arr[i];
			int r = i - 1;
			/* Move elements of arr[0..i-1], that are
			greater than key, to one position ahead
			of their current position */
			while (r >= 0 && arr[r].charAt(0) > key.charAt(0)) {
				arr[r + 1] = arr[r];
				r = r - 1;
			}
			arr[r + 1] = key;
		}
	}
	public void sortTBSystem() {
		String[] people = new String[count];
		Node temp = head;
		int i = 0;
		while (temp != null) {
			people[i++] = temp.getVal().getfName();
			temp = temp.getNext();
		}
		insertionSort(people);
		System.out.println(Arrays.toString(people));
	}
}
public class TelephoneBookSystem {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		TBSystem telephoneBookSystem = new TBSystem();
		System.out.println("Welcome to AMHezam Telephone Book System Program :) .");
		System.out.println();
		System.out.println("""
				Here you can:
					- Add a new person to System. Enter ap
					- Delete any person. Enter dp
					- Update any person data. Enter up
					- Display all people in Book System. Enter da
					- Display Phone number. Enter dph
					- Sort book system. Enter sort
				 
				To Exit enter q.
				""");
		String order;
		label:
		while (true) {
			order = input.nextLine();
			switch (order) {
				case "ap":
					telephoneBookSystem.addPerson();
					break;
				case "dp":
					telephoneBookSystem.deletePerson();
					break;
				case "up":
					telephoneBookSystem.updatePhoneNumber();
					break;
				case "dph":
					telephoneBookSystem.displayPhone();
					break;
				case "da":
					telephoneBookSystem.displayAll();
					break;
				case "sort":
					telephoneBookSystem.sortTBSystem();
					break;
				case "q":
					break label;
				default:
					System.out.println("Wrong Input!. Try again");
					break;
			}
		}
		System.out.println("Thank you for using my Program <3. ");
	}
}
