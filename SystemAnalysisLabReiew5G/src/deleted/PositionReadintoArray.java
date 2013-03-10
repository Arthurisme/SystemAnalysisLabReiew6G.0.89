package deleted;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;

import SystemAnalysisLabReview5.Position;

public class PositionReadintoArray {

	Position[] ThePositions = new Position[100];

	// ThePositions[0]=null;

	static int NumberOfLines;
	private String OriginalText;

	public PositionReadintoArray() throws NullPointerException, IOException {

		
		//!!!add later--1--
		 NumberOfLines = lineCounter("Position.in");
		OriginalText = "";

		this.readin3();
		//RemoveEmptyLines();
	}

	public void readin3() throws FileNotFoundException {

		Scanner inFilePosition = new Scanner(new FileReader("Position.in"));

		int i = 0;
		while (inFilePosition.hasNextLine()) {

			String TheNextLine = inFilePosition.nextLine();
			String TheNextL=TheNextLine;
			//OriginalText = OriginalText + TheNextLine;

			// try print a line:
			// System.out.println(TheNextLine);
			if(TheNextL!=null)
				
			{

			String[] PositionElementByLine = TheNextL.split("	");

			int rPosition_id = Integer.parseInt(PositionElementByLine[0]);
			String rPosition_Desc = PositionElementByLine[1];
			 
			ThePositions[i] = new Position();
			ThePositions[i].PositionSetValue(rPosition_id, rPosition_Desc
				 );

			i++;
			}
		 
		}// for end.
		

		inFilePosition.close();

	}

	public Position get_PositionByIndex(int IndexOfPosition) {
		return ThePositions[IndexOfPosition];
	}

	public String get_OriginalText() throws FileNotFoundException {

		Scanner inFilePosition = new Scanner(new FileReader("Position.in"));

		int i = 0;
		
		while (inFilePosition.hasNextLine()) {

			String LineTemp=inFilePosition.nextLine();
			
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
		inFilePosition.close();
		
		//now wirte to file with the txt no empty lines:
		//PrintWriter writerNoEmptyLine=new PrintWriter("Position.in");
		//writerNoEmptyLine.printf(OriginalText);
		//writerNoEmptyLine.close();
		
		return OriginalText;

		//
	}
	
	public void RemoveEmptyLines() throws FileNotFoundException {

	 
		
		//now wirte to file with the txt no empty lines:
		
		//String tempStringForREL="1	1	1	1	1	1	1	1";
		String tempStringForREL=get_OriginalText();
 
		PrintWriter writerNoEmptyLine=new PrintWriter("Position.in");
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
