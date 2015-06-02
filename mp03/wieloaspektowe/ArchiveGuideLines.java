package wieloaspektowe;

public class ArchiveGuideLines extends GuideLines implements Archive {

	public ArchiveGuideLines(String name) {
		super(name);
	}

	@Override
	public boolean isEditable() {
		return false;
	}
	
	public void addGuideline(String guideline) throws Exception {
		if (!this.isEditable()) {
			throw new Exception("Can't edit archived document");
		}
		if (this.guidelinesCount > 9) {
			return;
		}
		this.guidelines[this.guidelinesCount++] = guideline; 
	}
	
	public void printGuidelines() {
		for (int i = 0; i < this.guidelinesCount; i++) {
			System.out.println(this.guidelines[i]);
		}
	}

}
