package SystemAnalysisLabReview5;

public class ItemsPay {

	private int ItemPay_No;
	private String ItemPay_Title;
	private double ItemPay_DeductionPer;
	 

	// for future using:
	// int Employee_id, String ItemPay_Title, String ItemPay_DeductionPer,int
	// Position_id,String HireDate, int Dep_id_of_Employee,int
	// Qual_id_of_Employee;

	public ItemsPay() {
		ItemPay_No = 0;
		ItemPay_Title = "";
		ItemPay_DeductionPer = 0;
		   

	}

	public ItemsPay(int dEmployee_id, String dItemPay_Title,
			double dItemPay_DeductionPer ) {
		ItemsPaySetValue(dEmployee_id, dItemPay_Title, dItemPay_DeductionPer );

	}

	public void ItemsPaySetValue(int dItemPay_No, String dItemPay_Title,
			double dItemPay_DeductionPer ) {
		ItemPay_No = dItemPay_No;
		ItemPay_Title = dItemPay_Title;
		ItemPay_DeductionPer = dItemPay_DeductionPer;
		   

	}


	
	public int get_ItemPay_No() {
		return ItemPay_No;
	}

	public String get_ItemPay_Title() {
		return ItemPay_Title;
	}

	public double get_ItemPay_DeductionPer() {
		return ItemPay_DeductionPer;
	}

 

	public void set_ItemPay_No(int ItemPay_No_set) {
		ItemPay_No = ItemPay_No_set;
	}

	public void set_ItemPay_Title(String ItemPay_Title_set) {
		ItemPay_Title = ItemPay_Title_set;
	}

	public void set_ItemPay_DeductionPer(double ItemPay_DeductionPer_set) {
		ItemPay_DeductionPer = ItemPay_DeductionPer_set;
	}
	 
	
	public String ItemPayToString( ) {
		
		String tempStr=
				ItemPay_No +"	"+
		ItemPay_Title  +"	"+
		ItemPay_DeductionPer     ;
		
		return tempStr;
	}
	

}
