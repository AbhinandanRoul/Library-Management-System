/*
 * Abhinandan Roul
 * Regd- 1941012359
 */
public class Date 
{
	int dd;
	int mm;
	int yyyy;
	public Date(int dd, int mm, int yyyy) {
		this.dd = dd;
		this.mm = mm;
		this.yyyy = yyyy;
	}
	public int getDd() {
		return dd;
	}
	public int getMm() {
		return mm;
	}
	public int getYyyy() {
		return yyyy;
	}
	public String toString() {
		return "Date: "+dd + "/" + mm + "/" + yyyy ;
	}
	
	public int daysDiff(Date depositDate)
	{
		int nDays[] = {31,59,90,120,151,181,212,243,273,304,334,365};
		
		int DATE_ISSUED = this.dd + nDays[this.mm -1] + this.yyyy * 365;
		int DATE_DEPOSITED = depositDate.dd + nDays[depositDate.mm - 1] + depositDate.yyyy * 365;
		
		
		return DATE_DEPOSITED - DATE_ISSUED;
	}
	
	

}
