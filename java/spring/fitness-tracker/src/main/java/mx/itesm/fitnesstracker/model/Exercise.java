package mx.itesm.fitnesstracker.model;

public class Exercise {
	
	private int minutes;
	private String activity;
	
	public String getActivity() {
		return activity;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}

}
