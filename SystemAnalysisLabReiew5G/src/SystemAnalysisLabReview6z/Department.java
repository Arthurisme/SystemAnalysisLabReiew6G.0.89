package SystemAnalysisLabReview6z;

public class Department {

	private int Department_id;
	private String Department_Name;
	private String Department_location;
	 

	// for future using:
	// int Employee_id, String Department_Name, String Department_location,int
	// Position_id,String HireDate, int Dep_id_of_Employee,int
	// Qual_id_of_Employee;

	public Department() {
		Department_id = 0;
		Department_Name = "";
		Department_location = "";
		   

	}

	public Department(int dEmployee_id, String dDepartment_Name,
			String dDepartment_location ) {
		DepartmentSetValue(dEmployee_id, dDepartment_Name, dDepartment_location );

	}

	public void DepartmentSetValue(int dDepartment_id, String dDepartment_Name,
			String dDepartment_location ) {
		Department_id = dDepartment_id;
		Department_Name = dDepartment_Name;
		Department_location = dDepartment_location;
		   

	}


	
	public int get_Department_id() {
		return Department_id;
	}

	public String get_Department_Name() {
		return Department_Name;
	}

	public String get_Department_Location() {
		return Department_location;
	}

 

	public void set_Department_id(int Department_id_set) {
		Department_id = Department_id_set;
	}

	public void set_Department_Name(String Department_Name_set) {
		Department_Name = Department_Name_set;
	}

	public void set_Department_Location(String Department_Location_set) {
		Department_location = Department_Location_set;
	}
	 
	
	public String DepartmentToString( ) {
		
		String tempStr=
				Department_id +"	"+
		Department_Name  +"	"+
		Department_location     ;
		
		return tempStr;
	}
	

}
