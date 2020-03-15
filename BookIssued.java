/*
 * Abhinandan Roul
 * Regd- 1941012359
 */
public class BookIssued {
	
	String bookName;
	String authorName;
	Date issueDate;
	Date returnDate;
	int finePaid;
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public BookIssued(String bookName, String authorName, Date issueDate) {
		this.bookName = bookName;
		this.authorName = authorName;
		this.issueDate = issueDate;
		this.finePaid = 0;
		this.returnDate = null;
	}
	public String toString() {
		return "Book Name: " + bookName + ", Author Name: "
				+ authorName + ", Issue Date: " + issueDate.toString();
	}
	public String depositHistory() {
		return "Book Name: " + bookName + ", Author Name: "
				+ authorName + ", Issue Date: " + issueDate.toString()+ ", Deposit Date: " + returnDate.toString() + ", Fine Paid: "+ finePaid;
	}
	
	
	
	
	

}
