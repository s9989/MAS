package metoda_klasowa;

import java.util.Vector;
import atrybut_pochodny.Stage;

public class Stages {
	
	private Vector<Stage> collection = new Vector<Stage>();
	
	public void add(Stage stage) {
		this.collection.add(stage);
	}
	
	public void remove(Stage stage) {
		this.collection.remove(stage);
	}

 	/* Metoda klasowa */
	public void removeAllStages() {
		this.collection.removeAllElements();
	}
	
}
