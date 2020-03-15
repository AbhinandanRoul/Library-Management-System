/*
 * Abhinandan Roul
 * Regd- 1941012359
 */
import java.util.Scanner;

public class Library {

	Book books[];
	int bookNumber;
	public static final int max_allowance = 5;
	public static final int max_permitted_days_without_fine = 21;
	public static final int fine_for_each_day = 1;
	public static final int max_history = 10;

	Scanner in = new Scanner(System.in);

	public Library(int LibrarySize) {

		books = new Book[LibrarySize];
		bookNumber = 0;
	}

	public void addBook() {
		
		System.out.println("Enter book Name: ");
		String bookName = in.nextLine();

		System.out.println("Enter Author Name: ");
		String authorName = in.nextLine();

		System.out.println("Enter Author Email: ");
		String authorEmail = in.nextLine();

		System.out.println("Enter Book price: ");
		double bookPrice = Double.parseDouble(in.nextLine());

		System.out.println("Enter Book Quantity: ");
		int bookQty = Integer.parseInt(in.nextLine());

		System.out.println("Enter Author Gender (m/f): ");
		char authorGender = in.nextLine().charAt(0);

		Author author = new Author(authorName, authorEmail, authorGender);
		Book book = new Book(bookName, author, bookPrice, bookQty);

		books[bookNumber] = book;
		bookNumber += 1;
	}

	public void displayAllBooks() {
		System.out.println("----------------------------------------");
		System.out.println("        LIST OF BOOKS AVAILABLE             ");
		System.out.println("----------------------------------------");
		for (Book book : books) {
			System.out.println(book.toString());
			System.out.println("-------------------------------");

		}
	}

	public Book getBookByName(String bookName) {
		for (Book book : books) {
			if (book.name.equals(bookName))
				return book;
		}

		return null;
	}
}
