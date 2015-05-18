package atrybut_opcjonalny;

import atrybut_klasowy.Project;

public class Stage {
	
	Project project;
	
	/* Atrybut opcjonalny */
	Conception conception;
	
	Stage(Project project) {
		this.project = project;
	}
	
	Stage(Project project, Conception c) {
		this.project = project;
		conception = c;
	}
	
}
