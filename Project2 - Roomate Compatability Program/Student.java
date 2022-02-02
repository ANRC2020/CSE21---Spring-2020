public class Student {
	
	private String name;
	private char gender;
	private Date birthday;
	private Preference pref;
	private boolean matched = false;

	public Student(String name2, char charAt, Date birthday2, Preference pref2) {
		name = name2;
		gender = charAt;
		birthday = birthday2;
		pref = pref2;	
		//System.out.println(name + " " + gender + " " + birthday + " " + pref);
	}
	
	public void setmatch(boolean x) {
		matched = x;
	}

	public String getname() {
		return name;
	}
	
	public char getgender() {
		return gender;
	}
	
	public Date getbirth() {
		return birthday;
	}
	
	public Preference getpref() {
		return pref;
	}
	
	public boolean getmatch() {
		return matched;
	}
	
	public int compare(Student st){
		int score = 0;
		if(gender != st.getgender()) {
			return score;
		} else {
			score = (40 - pref.compare(st.pref)) + (60 - birthday.compare(st.birthday));
		}
		return score;
	}

	public void appendname(String string) {
		name = string;
	}
	
}