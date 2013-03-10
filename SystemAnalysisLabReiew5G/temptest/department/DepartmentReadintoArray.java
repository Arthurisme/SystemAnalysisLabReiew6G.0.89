package department;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;

public class DepartmentReadintoArray {

	Department[] TheDepartments = new Department[100];

	// TheDepartments[0]=null;

	static int NumberOfLines;
	private String OriginalText;

	public DepartmentReadintoArray() throws NullPointerException, IOException {

		
		//!!!add later--1--
		 NumberOfLines = lineCounter("Department.in");
		OriginalText = "";

		this.readin3();
		//RemoveEmptyLines();
	}

	public void readin3() throws FileNotFoundException {

		Scanner inFileDepartment = new Scanner(new FileReader("Department.in"));

		int i = 0;
		while (inFileDepartment.hasNextLine()) {

			String TheNextLine = inFileDepartment.nextLine();
			String TheNextL=TheNextLine;
			//OriginalText = OriginalText + TheNextLine;

			// try print a line:
			// System.out.println(TheNextLine);
			if(TheNextL!=null)
				
			{

			String[] DepartmentElementByLine = TheNextL.split("	");

			int rDepartment_id = Integer.parseInt(DepartmentElementByLine[0]);
			String rDepartment_Name = DepartmentElementByLine[1];
			String rDepartment_Location = DepartmentElementByLine[2];
			 
			TheDepartments[i] = new Department();
			TheDepartments[i].DepartmentSetValue(rDepartment_id, rDepartment_Name,
					rDepartment_Location );

			i++;
			}
		 
		}// for end.
		

		inFileDepartment.close();

	}

	public Department get_DepartmentByIndex(int IndexOfDepartment) {
		return TheDepartments[IndexOfDepartment];
	}

	public String get_OriginalText() throws FileNotFoundException {

		Scanner inFileDepartment = new Scanner(new FileReader("Department.in"));

		int i = 0;
		
		while (inFileDepartment.hasNextLine()) {

			String LineTemp=inFileDepartment.nextLine();
			
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
		inFileDepartment.close();
		
		//now wirte to file with the txt no empty lines:
		//PrintWriter writerNoEmptyLine=new PrintWriter("Department.in");
		//writerNoEmptyLine.printf(OriginalText);
		//writerNoEmptyLine.close();
		
		return OriginalText;

		//
	}
	
	public void RemoveEmptyLines() throws FileNotFoundException {

	 
		
		//now wirte to file with the txt no empty lines:
		
		//String tempStringForREL="1	1	1	1	1	1	1	1";
		String tempStringForREL=get_OriginalText();
 
		PrintWriter writerNoEmptyLine=new PrintWriter("Department.in");
		 writerNoEmptyLine.println(tempStringForREL);
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
