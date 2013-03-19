package SystemAnalysisLabReiew6G;

public class Position {

	private int Position_id;
	private String Position_Desc;

	// for future using:
	// int Employee_id, String Position_Desc, String Position_location,int
	// Position_id,String HireDate, int Dep_id_of_Employee,int
	// Qual_id_of_Employee;

	public Position() {
		Position_id = 0;
		Position_Desc = "";

	}

	public Position(int dEmployee_id, String dPosition_Desc,
			String dPosition_location) {
		PositionSetValue(dEmployee_id, dPosition_Desc);

	}

	public void PositionSetValue(int dPosition_id, String dPosition_Desc) {
		Position_id = dPosition_id;
		Position_Desc = dPosition_Desc;

	}

	public int get_Position_id() {
		return Position_id;
	}

	public String get_Position_Desc() {
		return Position_Desc;
	}

	public void set_Position_id(int Position_id_set) {
		Position_id = Position_id_set;
	}

	public void set_Position_Desc(String Position_Desc_set) {
		Position_Desc = Position_Desc_set;
	}

	public String PositionToString() {

		String tempStr = Position_id + "	" + Position_Desc;

		return tempStr;
	}

}
