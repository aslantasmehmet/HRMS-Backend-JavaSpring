package kodlamaio.HRMS.core.utilities.result;

public class ErrorResult extends Result {

	public ErrorResult(boolean success) {
		super(false);
		}
	
	public ErrorResult(String message) {
		super(false,message);
	}
}
