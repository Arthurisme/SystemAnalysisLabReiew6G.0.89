package Employee;

public class Employee {

	private int Employee_id;
	private String Employee_Lname;
	private String Employee_Fname;
	private String SSN;
	private int Position_id;
	private String HireDate;
	private int Dep_id_of_Employee;
	private int Qual_id_of_Employee;

	// for future using:
	// int Employee_id, String Employee_Lname, String Employee_Fname,int
	// Position_id,String HireDate, int Dep_id_of_Employee,int
	// Qual_id_of_Employee;

	public Employee() {
		Employee_id = 0;
		Employee_Lname = "";
		Employee_Fname = "";
		  SSN="";
		Position_id = 0;
		HireDate = "";
		Dep_id_of_Employee = 0;
		Qual_id_of_Employee = 0;

	}

	public Employee(int dEmployee_id, String dEmployee_Lname,
			String dEmployee_Fname, String dSSN,int dPosition_id, String dHireDate,
			int dDep_id_of_Employee, int dQual_id_of_Employee) {
		EmployeeSetValue(dEmployee_id, dEmployee_Lname, dEmployee_Fname,dSSN,
				dPosition_id, dHireDate, dDep_id_of_Employee,
				dQual_id_of_Employee);

	}

	public void EmployeeSetValue(int dEmployee_id, String dEmployee_Lname,
			String dEmployee_Fname,String dSSN, int dPosition_id, String dHireDate,
			int dDep_id_of_Employee, int dQual_id_of_Employee) {
		Employee_id = dEmployee_id;
		Employee_Lname = dEmployee_Lname;
		Employee_Fname = dEmployee_Fname;
		  SSN=  dSSN;
		Position_id = dPosition_id;
		HireDate = dHireDate;
		Dep_id_of_Employee = dDep_id_of_Employee;
		Qual_id_of_Employee = dQual_id_of_Employee;

	}


	
	public int get_Employee_id() {
		return Employee_id;
	}

	public String get_Employee_Lname() {
		return Employee_Lname;
	}

	public String get_Employee_Fname() {
		return Employee_Fname;
	}

	public int get_Position_id() {
		return Position_id;
	}
	public String get_SSN() {
		return SSN;
	}
	public String get_HireDate() {
		return HireDate;
	}

	public int get_Dep_id_of_Employee() {
		return Dep_id_of_Employee;
	}

	public int get_Qual_id_of_Employee() {
		return Qual_id_of_Employee;
	}

	public void set_Employee_id(int Employee_id_set) {
		Employee_id = Employee_id_set;
	}

	public void set_Employee_Lname(String Employee_Lname_set) {
		Employee_Lname = Employee_Lname_set;
	}

	public void set_Employee_Fname(String Employee_Fname_set) {
		Employee_Fname = Employee_Fname_set;
	}
	public void Set_SSN(String SSN_set) {
		  SSN=SSN_set;
	}
	public void set_Position_id(int Position_id_set) {
		Position_id = Position_id_set;
	}

	public void set_HireDate(String HireDate_set) {
		HireDate = HireDate_set;
	}

	public void set_Dep_id_of_Employee(int Dep_id_of_Employee_set) {
		Dep_id_of_Employee = Dep_id_of_Employee_set;
	}

	public void set_Qual_id_of_Employee(int Qual_id_of_Employee_set) {
		Qual_id_of_Employee = Qual_id_of_Employee_set;
	}
	
	public String EmployeeToString( ) {
		
		String tempStr=
		Employee_id +"	"+
		Employee_Lname  +"	"+
		Employee_Fname  +"	"+
		  SSN +"	"+
		Position_id  +"	"+
		HireDate +"	"+
		Dep_id_of_Employee  +"	"+
		Qual_id_of_Employee  ;
		
		return tempStr;
	}
	

}
