public class Date {

	private int year;
	private int month;
	private int day;
	private String birthday;
	
	Date(int m, int d, int y){
		month = m;
		day = d;
		year = y;
		//birthday = month + " " + day + " " + year;
	}
	
	public int getyear() {
		return year;
	}
	
	public int getmonth() {
		return month;
	}
	
	public int getday() {
		return day;
	}	
	 
	public int compare(Date dt) {
		int TotalDifference = Math.abs(yearsDifferenceInDays(dt) - daysDifference(dt));
		TotalDifference = TotalDifference / 30;
		if(TotalDifference > 60) {
			TotalDifference = 60;
		} else if (TotalDifference < 0) {
			TotalDifference = 0;
		}
		//System.out.println(TotalDifference);
		return TotalDifference;
	}
	
	public int yearsDifferenceInDays(Date dt) {
		int difference = Math.abs(year - dt.getyear())* 365;
		return difference ;
	}
	
	public int daysDifference(Date dt) {
		int difference = Math.abs(dayOfYear() - dt.dayOfYear()) + Math.abs(getday() - dt.getday());
		return difference;
	}
	
	public int dayOfYear() {
		int totalDays = 0;
		switch (month) {
		case 12: totalDays += 30;
		case 11: totalDays += 31;
		case 10: totalDays += 30;
		case 9 : totalDays += 31;
		case 8 : totalDays += 31;
		case 7 : totalDays += 30;
		case 6 : totalDays += 31;
		case 5 : totalDays += 30;
		case 4 : totalDays += 31;
		case 3 : totalDays += 28;
		case 2 : totalDays += 31;
		}
		totalDays += day;
		return totalDays;
	}
	
}