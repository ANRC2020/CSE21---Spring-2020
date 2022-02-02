public class Preference {

	private int quiteTime;
	private int music;
	private int reading;
	private int chatting;
	
	Preference(int qt, int m, int r, int c){
		quiteTime = qt;
		music = m;
		reading = r;
		chatting = c;
	} 
	
	public int getquitetime() {
		return quiteTime;
	}
	
	public int getmusic() {
		return music;
	}
	
	public int getreading() {
		return reading;
	}
	
	public int getchatting() {
		return chatting;
	}

	public int compare(Preference pref) {
		int SumDiff = Math.abs(quiteTime - pref.getquitetime()) + Math.abs(music - pref.getmusic()) + Math.abs(reading - pref.getreading()) + Math.abs(chatting - pref.getchatting()); 
		//System.out.println(SumDiff);
		return SumDiff;
	}
	
}