package wieloaspektowe;

public class ProcessedElaboration extends Elaboration implements Processed {

	public ProcessedElaboration(String name) {
		super(name);
	}

	@Override
	public boolean isEditable() {
		return true;
	}
	
	public void setComment(String comment) throws Exception {
		if (!this.isEditable()) {
			throw new Exception("Can't edit archived document");
		}
		this.comment = comment;
	}
	
	public void printComment() {
		System.out.println(this.comment);
	}

}
