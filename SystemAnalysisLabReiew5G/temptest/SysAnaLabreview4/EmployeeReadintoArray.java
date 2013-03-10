package SysAnaLabreview4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;

public class EmployeeReadintoArray {

	Employee[] TheEmployees = new Employee[100];

	// TheEmployees[0]=null;

	static int NumberOfLines;
	private String OriginalText;

	public EmployeeReadintoArray() throws NullPointerException, IOException {

		
		//!!!add later--1--
		 NumberOfLines = lineCounter("Employee.in");
		OriginalText = "";

		this.readin3();
		//RemoveEmptyLines();
	}

	public void readin3() throws FileNotFoundException {

		Scanner inFileEmployee = new Scanner(new FileReader("Employee.in"));

		int i = 0;
		while (inFileEmployee.hasNextLine()) {

			String TheNextLine = inFileEmployee.nextLine();
			String TheNextL=TheNextLine;
			//OriginalText = OriginalText + TheNextLine;

			// try print a line:
			// System.out.println(TheNextLine);
			if(TheNextL!=null)
				
			{

			String[] EmployeeElementByLine = TheNextL.split("	");

			int rEmployee_id = Integer.parseInt(EmployeeElementByLine[0]);
			String rEmployee_Lname = EmployeeElementByLine[1];
			String rEmployee_Fname = EmployeeElementByLine[2];
			String rSSN = EmployeeElementByLine[3];
			int rPosition_id = Integer.parseInt(EmployeeElementByLine[4]);
			String rHireDate = EmployeeElementByLine[5];
			int rDep_id_of_Employee = Integer
					.parseInt(EmployeeElementByLine[6]);
			int rQual_id_of_Employee = Integer
					.parseInt(EmployeeElementByLine[7]);

			TheEmployees[i] = new Employee();
			TheEmployees[i].EmployeeSetValue(rEmployee_id, rEmployee_Lname,
					rEmployee_Fname, rSSN, rPosition_id, rHireDate,
					rDep_id_of_Employee, rQual_id_of_Employee);

			i++;
			}
		 
		}// for end.
		

		inFileEmployee.close();

	}

	public Employee get_EmployeeByIndex(int IndexOfEmployee) {
		return TheEmployees[IndexOfEmployee];
	}

	public String get_OriginalText() throws FileNotFoundException {

		Scanner inFileEmployee = new Scanner(new FileReader("Employee.in"));

		int i = 0;
		
		while (inFileEmployee.hasNextLine()) {

			String LineTemp=inFileEmployee.nextLine();
			
			if(LineTemp!= null)// if not a empty line
			{
			String TheNextLine = LineTemp;
			
			if(OriginalText.equals(""))//if first line is empty
			{
				OriginalText =   TheNextLine;
			}
			else//if first line is not empty
			OriginalText = OriginalText +"\r\n"+ TheNextLine;
			
			//String tt=TheNextLine;
			}
			

			// try print a line:
			// System.out.println(TheNextLine);

			 


			i++;
		}// for end.
		inFileEmployee.close();
		
		//now wirte to file with the txt no empty lines:
		//PrintWriter writerNoEmptyLine=new PrintWriter("Employee.in");
		//writerNoEmptyLine.printf(OriginalText);
		//writerNoEmptyLine.close();
		
		return OriginalText;

		//
	}
	
	public void RemoveEmptyLines() throws FileNotFoundException {

	 
		
		//now wirte to file with the txt no empty lines:
		
		//String tempStringForREL="1	1	1	1	1	1	1	1";
		String tempStringForREL=get_OriginalText();
 
		PrintWriter writerNoEmptyLine=new PrintWriter("Employee.in");
		 writerNoEmptyLine.printf(tempStringForREL);
		 writerNoEmptyLine.close();
		
		//return OriginalText;

		//
	}

	


	public String get_23() {
		return "23";
	}
	
    public  int lineCounter(String filename) throws IOException,NullPointerException
    {
       int lineCount_int = 0;
       File inFile = new File(filename);
       try
       {
          Scanner file = new Scanner(inFile);
          while((file.hasNext()))
          {
             String t = file.nextLine();
             lineCount_int++;
          }
       }
       catch(IOException e)
       {
       }
       return lineCount_int;
    }
     


}
