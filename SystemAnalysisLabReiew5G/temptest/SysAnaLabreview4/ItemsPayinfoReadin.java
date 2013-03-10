package SysAnaLabreview4;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.math.BigDecimal;

public class ItemsPayinfoReadin {

	
	double 
	Prv_tax,
	Fed_Tax,
	QueParentalInsurancePlan,
	E_ins,
	Qpp,
	Union_d;

	public ItemsPayinfoReadin() throws FileNotFoundException {

		readin2();

	}

	public void readin2() throws FileNotFoundException {

		Scanner inFile = new Scanner(new FileReader("ItemsPayinfoReadin.txt"));
		// Scanner inFile = new Scanner(new FileReader("Course.in"));
		// PrintWriter outFile = new PrintWriter("coursesNo.txt");

		Prv_tax = inFile.nextDouble();
		Fed_Tax = inFile.nextDouble();
		QueParentalInsurancePlan = inFile.nextDouble();
		E_ins = inFile.nextDouble();
		Qpp = inFile.nextDouble();
		Union_d = inFile.nextDouble();
	 
		
		inFile.close();

	}

	public double getPrv_tax() {

		return Prv_tax/100;
	}
	public double getFed_Tax() {

		return Fed_Tax/100;
	}
	public double getQueParentalInsurancePlan() {

		return QueParentalInsurancePlan/100;
	}
	public double getE_ins() {

		return E_ins/100;
	}
	public double getQpp() {

		return Qpp/100;
	}
	public double getUnion_d() {

		return Union_d/100;
	}
	public double getTotalDeduction() {

		return this.getE_ins()+this.getFed_Tax()+this.getPrv_tax()+this.getQpp()
				+this.getQueParentalInsurancePlan()+this.getUnion_d();
	}

}
