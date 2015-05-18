package atrybut_pochodny;

import java.util.Date;

public class Stage {

	protected long deadline;
	
	/* Atrybut pochodny */
	protected long timeLeft = this.deadline - Stage.getCurrentTime();
	
	static protected long getCurrentTime() {
		Date d = new Date();
		return d.getTime();
	}
	
}
