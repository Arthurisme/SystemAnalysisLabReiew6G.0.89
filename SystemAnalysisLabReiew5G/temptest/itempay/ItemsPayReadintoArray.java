package itempay;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;

public class ItemsPayReadintoArray {

	ItemsPay[] TheItemsPays = new ItemsPay[100];

	// TheItemsPays[0]=null;

	static int NumberOfLines;
	private String OriginalText;

	public ItemsPayReadintoArray() throws NullPointerException, IOException {

		
		//!!!add later--1--
		 NumberOfLines = lineCounter("ItemsPay.in");
		OriginalText = "";

		this.readin3();
		//RemoveEmptyLines();
	}

	public void readin3() throws FileNotFoundException {

		Scanner inFileItemsPay = new Scanner(new FileReader("ItemsPay.in"));

		int i = 0;
		while (inFileItemsPay.hasNextLine()) {

			String TheNextLine = inFileItemsPay.nextLine();
			String TheNextL=TheNextLine;
			//OriginalText = OriginalText + TheNextLine;

			// try print a line:
			// System.out.println(TheNextLine);
			if(TheNextL!=null)
				
			{

			String[] ItemsPayElementByLine = TheNextL.split("	");

			int rItemsPay_No = Integer.parseInt(ItemsPayElementByLine[0]);
			String rItemsPay_Title = ItemsPayElementByLine[1];
			String rItemPay_DeductionPer = ItemsPayElementByLine[2];
			 
			TheItemsPays[i] = new ItemsPay();
			TheItemsPays[i].ItemsPaySetValue(rItemsPay_No, rItemsPay_Title,
					rItemPay_DeductionPer );

			i++;
			}
		 
		}// for end.
		

		inFileItemsPay.close();

	}

	public ItemsPay get_ItemsPayByIndex(int IndexOfItemsPay) {
		return TheItemsPays[IndexOfItemsPay];
	}

	public String get_OriginalText() throws FileNotFoundException {

		Scanner inFileItemsPay = new Scanner(new FileReader("ItemsPay.in"));

		int i = 0;
		
		while (inFileItemsPay.hasNextLine()) {

			String LineTemp=inFileItemsPay.nextLine();
			
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
		inFileItemsPay.close();
		
		//now wirte to file with the txt no empty lines:
		//PrintWriter writerNoEmptyLine=new PrintWriter("ItemsPay.in");
		//writerNoEmptyLine.printf(OriginalText);
		//writerNoEmptyLine.close();
		
		return OriginalText;

		//
	}
	
	public void RemoveEmptyLines() throws FileNotFoundException {

	 
		
		//now wirte to file with the txt no empty lines:
		
		//String tempStringForREL="1	1	1	1	1	1	1	1";
		String tempStringForREL=get_OriginalText();
 
		PrintWriter writerNoEmptyLine=new PrintWriter("ItemsPay.in");
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
