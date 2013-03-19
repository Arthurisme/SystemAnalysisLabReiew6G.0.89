package SystemAnalysisLabReiew6G;

public class Qualification {

	private int Qualification_id;
	private String Qualification_Desc;

	// for future using:
	// int Employee_id, String Qualification_Desc, String Qualification_location,int
	// Qualification_id,String HireDate, int Dep_id_of_Employee,int
	// Qual_id_of_Employee;

	public Qualification() {
		Qualification_id = 0;
		Qualification_Desc = "";

	}

	public Qualification(int dEmployee_id, String dQualification_Desc,
			String dQualification_location) {
		QualificationSetValue(dEmployee_id, dQualification_Desc);

	}

	public void QualificationSetValue(int dQualification_id, String dQualification_Desc) {
		Qualification_id = dQualification_id;
		Qualification_Desc = dQualification_Desc;

	}

	public int get_Qualification_id() {
		return Qualification_id;
	}

	public String get_Qualification_Desc() {
		return Qualification_Desc;
	}

	public void set_Qualification_id(int Qualification_id_set) {
		Qualification_id = Qualification_id_set;
	}

	public void set_Qualification_Desc(String Qualification_Desc_set) {
		Qualification_Desc = Qualification_Desc_set;
	}

	public String QualificationToString() {

		String tempStr = Qualification_id + "	" + Qualification_Desc;

		return tempStr;
	}

}
