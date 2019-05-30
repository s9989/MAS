public class ArchiveElaboration extends Elaboration implements Archive {

	public ArchiveElaboration(String name) {
		super(name);
	}

	@Override
	public boolean isEditable() {
		return false;
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
