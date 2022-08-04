import java.util.ArrayList;

public class TuitionRegisterStudent {
	
	private static final int OPTION_ADD = 3;
	private static final int OPTION_DELETE = 2;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_QUIT = 4;
	
	public static void main(String[] args) {
		ArrayList<Register> registerList = new ArrayList<Register>();
		
		registerList.add (new Register("001","0011", "susan@gmail.com","pending","2022-09-13"));
		registerList.add(new Register("002","0022", "thomas@gmail,com", "pending", "2022-07-19"));
		
	}
	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveAllRegister(ArrayList<Register> registerList) { 
		String output = "";

		for (int i = 0; i < registerList.size(); i++) {

			output += String.format("%-84s\n", registerList.get(i).toString());
		}
		return output;
	}
	public static void viewAllRegister(ArrayList<Register> registerList) {
		Helper.line(80, "-");
		System.out.println("REGISTER LIST");
		Helper.line(80, "-");
	
		String output = String.format("%-10s %-10s %-30s %-10s %-20s\n", "REGISTER ID", "TIMETABLE ID",
				"EMAIL", "STATUS","REGISTER DATE");
		 output += retrieveAllRegister(registerList);	
		System.out.println(output);
	}
	//================================= Option 3 Add =================================
		public static Register addRegister() {
			String RegID = Helper.readString("Enter Register ID> ");
			String timetableID = Helper.readString("Enter Timetable ID > ");
			String email = Helper.readString("Enter Student Email > ");
			String status = Helper.readString("Enter status of Tuition > ");
			String RegDate = Helper.readString("Enter Register Date > ");

			Register rr= new Register(RegID, timetableID, email, status, RegDate);
			return rr;
			
		}
		public static void addCamcorder(ArrayList<Register> registerList, Register rr) {
			
			registerList.add(rr);
			
		}
		//================================= Option 2 Delete  =================================
		public static boolean doDeleteRegister (ArrayList<Register> registerList, String regID) {
			
			boolean isDeleted = false;

			for (int i = 0; i < registerList.size(); i++) {
				
				String RegID = registerList.get(i).getRegID();
				
				if (regID.equalsIgnoreCase(RegID)) {
					
					registerList.remove(i);
				
					
					isDeleted = true;
					
				}
			}
			 return isDeleted;
		}

		public static void deleteRegister(ArrayList<Register> registerList) {
			Helper.line(80, "-");
			System.out.println("REGISTER LIST");
			Helper.line(80, "-");
			
			String regID = Helper.readString("Enter Register ID > ");
			
			Boolean isDeleted =doDeleteRegister(registerList, regID);
			if (isDeleted == false) {
				System.out.println("Invalid Register ID");
			} else {
				System.out.println("Register ID  " + regID + " deleted");
			}
		}
	
}
	
	


