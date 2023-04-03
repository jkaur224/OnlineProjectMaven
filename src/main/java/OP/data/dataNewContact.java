package OP.data;

import OP.utilities.Xls_Reader;

public class dataNewContact {
		
	Xls_Reader xl = new Xls_Reader("C:\\QA\\Testing\\OnlineProjectData.xlsx");
	
	public String correctTitle=xl.getCellData("Contact", "Title", 3);
	public String correctFirstName=xl.getCellData("Contact", "FirstName", 3);
	public String correctLastName=xl.getCellData("Contact", "LastName", 3);
}
