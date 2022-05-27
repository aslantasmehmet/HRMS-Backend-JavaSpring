package kodlamaio.HRMS.core.utilities.business.validation.TaxNumverValidation;

public class TaxNumberValidation {
	
	
	public static boolean isRealPerson(String TaxNumber) {
	return  TaxNumberFakeMernis.validate(TaxNumber);
}

}
