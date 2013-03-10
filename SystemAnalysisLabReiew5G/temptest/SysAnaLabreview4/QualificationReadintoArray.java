package SysAnaLabreview4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;

public class QualificationReadintoArray {

	Qualification[] TheQualifications = new Qualification[100];

	// TheQualifications[0]=null;

	static int NumberOfLines;
	private String OriginalText;

	public QualificationReadintoArray() throws NullPointerException, IOException {

		
		//!!!add later--1--
		 NumberOfLines = lineCounter("Qualification.in");
		OriginalText = "";

		this.readin3();
		//RemoveEmptyLines();
	}

	public void readin3() throws FileNotFoundException {

		Scanner inFileQualification = new Scanner(new FileReader("Qualification.in"));

		int i = 0;
		while (inFileQualification.hasNextLine()) {

			String TheNextLine = inFileQualification.nextLine();
			String TheNextL=TheNextLine;
			//OriginalText = OriginalText + TheNextLine;

			// try print a line:
			// System.out.println(TheNextLine);
			if(TheNextL!=null)
				
			{

			String[] QualificationElementByLine = TheNextL.split("	");

			int rQualification_id = Integer.parseInt(QualificationElementByLine[0]);
			String rQualification_Desc = QualificationElementByLine[1];
			 
			TheQualifications[i] = new Qualification();
			TheQualifications[i].QualificationSetValue(rQualification_id, rQualification_Desc
				 );

			i++;
			}
		 
		}// for end.
		

		inFileQualification.close();

	}

	public Qualification get_QualificationByIndex(int IndexOfQualification) {
		return TheQualifications[IndexOfQualification];
	}

	public String get_OriginalText() throws FileNotFoundException {

		Scanner inFileQualification = new Scanner(new FileReader("Qualification.in"));

		int i = 0;
		
		while (inFileQualification.hasNextLine()) {

			String LineTemp=inFileQualification.nextLine();
			
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
		inFileQualification.close();
		
		//now wirte to file with the txt no empty lines:
		//PrintWriter writerNoEmptyLine=new PrintWriter("Qualification.in");
		//writerNoEmptyLine.printf(OriginalText);
		//writerNoEmptyLine.close();
		
		return OriginalText;

		//
	}
	
	public void RemoveEmptyLines() throws FileNotFoundException {

	 
		
		//now wirte to file with the txt no empty lines:
		
		//String tempStringForREL="1	1	1	1	1	1	1	1";
		String tempStringForREL=get_OriginalText();
 
		PrintWriter writerNoEmptyLine=new PrintWriter("Qualification.in");
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
