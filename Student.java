/*
 * Abhinandan Roul
 * Regd- 1941012359
 */
import java.util.Scanner;
public class Student
{
	String name;
	int roll;
	BookIssued allBookIssued[];
	BookIssued bookHistory[];
	
	Scanner in = new Scanner(System.in);
	int currentBookCount;
	int bookHistoryCount;
	
	public Student(String name, int roll) {
		this.name = name;
		this.roll = roll;
		allBookIssued = new BookIssued[Library.max_allowance];
		bookHistory = new BookIssued[Library.max_history];
		currentBookCount = 0;
		bookHistoryCount = 0;
		
	}
	public String getName() {
		return name;
	}
	public int getRoll() {
		return roll;
	}
	
	public String toString() {
		return "Student Name: " + name + "\n roll:" + roll + "\n Number of books Issued: " +currentBookCount  ;
	}
	
	public Book issueBook(Library library)
	{
		library.displayAllBooks();
		System.out.println("Enter Book Name to Issue: ");
		String bookNametoIssue = in.nextLine();
		
		Book bookToIssue = library.getBookByName(bookNametoIssue);
		if(bookToIssue != null && bookToIssue.qty > 0 && currentBookCount < 5)
		{ 
			bookToIssue.qty -= 1;
			currentBookCount += 1;
			
			
			System.out.println("Enter Issue Date(DD): ");
			int issueDD = in.nextInt();
			System.out.println("Enter Issue Month(MM): ");
			int issueMM = in.nextInt();
			System.out.println("Enter Issue Year(YYYY): ");
			int issueYYYY = in.nextInt();
			
			Date issueDate = new Date(issueDD,issueMM,issueYYYY);
			BookIssued bookIssued = new BookIssued(bookToIssue.name, bookToIssue.author.name, issueDate) ;
			
			for(int y = 0; y < Library.max_allowance;y++)
			{
				if(allBookIssued[y] == null)
				{
					allBookIssued[y] = bookIssued;
					break;
				}
				
				
			}
			System.out.println(bookNametoIssue+" book issued successfully.");
			System.out.println("-----------------------------------------------------------");
			return bookToIssue;
		}
		
		System.out.println("Book Not Available");
		return null;
		
	}
	
	public void depositBook(Library library)
	{
		int totalFine = 0;
		boolean isBookIssued = false;
		
		// Display all issued books
		System.out.println("-------------------------------------------------------------");
		System.out.println("All books issued by "+ this.name);
		for(int y= 0; y < Library.max_allowance; y++ )
		{
			if(this.allBookIssued[y] != null)
			{
				System.out.println(this.allBookIssued[y].toString());
				isBookIssued = true;
			}
			
			
		}
		if(!isBookIssued)
		{
			System.out.println("No book issued to you");
			return;
		}
		System.out.println("Enter Book Name to Deposit: ");
		String bookNametoDeposit = in.nextLine();
		
		for(int y = 0; y < Library.max_allowance; y ++ )
		{	
			if(allBookIssued[y] != null && allBookIssued[y].bookName.equals(bookNametoDeposit))
			{
				Date bookIssuedDate = allBookIssued[y].issueDate;
				
				// Calculate Fine
				System.out.println("Enter Deposit Date(DD): ");
				int depositDD = in.nextInt();
				System.out.println("Enter Deposit Month(MM): ");
				int depositMM = in.nextInt();
				System.out.println("Enter Deposit Year(YYYY): ");
				int depositYYYY =in.nextInt();
				
				Date bookDepositDate = new Date(depositDD ,depositMM ,depositYYYY);
				
				if(bookIssuedDate.daysDiff(bookDepositDate)> Library.max_permitted_days_without_fine)
				{
				
				totalFine = (bookIssuedDate.daysDiff(bookDepositDate) - Library.max_permitted_days_without_fine)
							* Library.fine_for_each_day;
				}
				else
					totalFine=0;
				allBookIssued[y].returnDate = bookDepositDate;
				allBookIssued[y].finePaid = totalFine;
				
				System.out.println("Book deposited with fine: " + totalFine);
				
				
				Book bookDeposited = library.getBookByName(bookNametoDeposit);
				bookDeposited.qty += 1;
				currentBookCount -= 1;
				bookHistory[bookHistoryCount] = allBookIssued[y];
				bookHistoryCount = (bookHistoryCount + 1)% Library.max_history;
				allBookIssued[y] = null;
				return;
			}
		}
		
		System.out.println("Book not available");
		
	}

	public void bookHistory()
	{
		System.out.println("-------------------------------------------------------------");
		for(BookIssued book : bookHistory)
		{
			if(book != null)
				System.out.println(book.depositHistory());
		}
	}
	
	

}

