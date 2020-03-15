/*
 * Abhinandan Roul
 * Regd- 1941012359
 */
import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		System.out.println("Library started...");
		System.out.println("Please enter number of books in the library: ");
		int LibrarySize = Integer.parseInt(in.nextLine());
		boolean logOut = false;
		boolean exit = false;
		Student currentStudent = null;
		
		Library library = new Library(LibrarySize);
		for(int bookCount = 0; bookCount < LibrarySize; bookCount++)
		{
			System.out.println("Enter Book "+ (bookCount+1)+" Details: ");
			library.addBook();
			System.out.println("Book Added : \n" + library.books[bookCount].toString());
			System.out.println("--------------------------------------------------------");
			
		}
		
		System.out.println("Register Students");
		System.out.println("Please enter number of Students: ");
		int total_students = Integer.parseInt(in.nextLine());
		
		
		Student allStudents[] = new Student[total_students];
		
		System.out.println("Provide details of "+ total_students+ " students: ");
		for(int y = 0; y < total_students; y++)
		{
			System.out.println("Enter Student "+ (y+1)+" Name: ");
			String studentName = in.nextLine();
			System.out.println("Enter Student "+ (y+1)+" Roll Number: ");
			int studentRoll =in.nextInt();
			
			Student student = new Student(studentName, studentRoll);
			allStudents[y] = student;
			System.out.println("Student "+ studentName+ " added with roll number "+ studentRoll);
		}
		
		while(!exit)
		{   System.out.println("-------------------------------------------------");
		    System.out.println("*************************************************");
			System.out.println("            Welcome to Central Library            ");
			System.out.println("*************************************************");
			System.out.println("-------------------------------------------------");
			logOut = false;
			
			while(!logOut)
			{
				System.out.println("Please enter your roll number : ");
				int rollNum = in.nextInt();
				
				for(int y = 0; y < total_students; y++)
				{
					if(allStudents[y].roll == rollNum)
					{	
						currentStudent = allStudents[y];
						break;
					}
					
				}
				if(currentStudent == null)
				{
					System.out.println("Invalid Roll number");
					continue;
				}
				
				while(!logOut && !exit)
				{
					System.out.println(currentStudent.name+" What do you want to do? ");
					System.out.println("1.Issue Book ");
					System.out.println("2.Deposit Book");
					System.out.println("3.Book History");
					System.out.println("4.Log Out");
					System.out.println("5.Exit");
					
					int choiceSelected =in.nextInt();
					switch(choiceSelected)
					{
						case 1: currentStudent.issueBook(library);
						break;
						case 2: currentStudent.depositBook(library);
						break;
						case 3 :currentStudent.bookHistory();
						break;
						case 4 :logOut = true;
						break;
						case 5: logOut = true;
								exit = true;
								System.out.println("Thank you for using the service.");
								System.out.println("Made by- Abhinandan Roul"+"\n"+"Regd-1941012359");
						break;
						default:System.out.println("Invalid Choice. Choose Again"); 
					}
					
				}
				
			}
			
			
		}

	}

}
