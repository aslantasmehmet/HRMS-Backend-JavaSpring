package kodlamaio.HRMS.core.utilities.business.validation;

public class NationalityIdValidation {

		public static boolean isRealPerson(String nationalityId) {
			return FakeMernis.validate(nationalityId);
		}
}
