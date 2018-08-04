package mx.itesm.fitnesstracker.model;

import org.hibernate.validator.constraints.Range;

public class Goal {
	
	@Range(min = 1, max = 120)
	private int minutes;

	public Goal() {
		super();
	}
	
	public Goal(int minutes) {
		super();
		this.minutes = minutes;
	}

	public int getMinutes() {
		return minutes;
	}

	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
}
