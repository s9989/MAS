package wieloaspektowe;

public abstract class GuideLines extends Document {

	public GuideLines(String name) {
		super(name);
	}
	
	
	protected int guidelinesCount = 0;
	protected String[] guidelines = new String[10];
	
}
