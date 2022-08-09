import java.util.ArrayList;

public class TuitionRegisterStudent {
	
	private static final int OPTION_ADD = 2;
	private static final int OPTION_DELETE = 3;
	private static final int OPTION_VIEW = 1;
	private static final int OPTION_SEARCH = 4;
	private static final int OPTION_UPDATE = 5;
	private static final int OPTION_WAITLIST = 6;
	
	private static final int OPTION_QUIT = 7;
	public static void main(String[] args) {
		ArrayList<Register> registerList = new ArrayList<Register>();
		
		registerList.add (new Register("001","0011", "susan@gmail.com","pending","2022-09-13", "no"));
		registerList.add(new Register("002","0022", "thomas@gmail.com", "pending", "2022-07-19", "no"));
		
		
		int option = 0;
		
		while (option != OPTION_QUIT) {
			
			TuitionRegisterStudent.menu();
			option = Helper.readInt("Enter an option > ");
			
			if (option == OPTION_VIEW) {
				TuitionRegisterStudent.viewAllRegister(registerList);
				
			}else if (option == OPTION_ADD) {
				TuitionRegisterStudent.setHeader("ADD");
				
				Register rr = addRegister();
				TuitionRegisterStudent.addRegister(registerList, rr);
				System.out.println("New Registration added");
			
		
		}else if (option == OPTION_DELETE) {
			TuitionRegisterStudent.setHeader("DELETE");		
	
			TuitionRegisterStudent.deleteRegister(registerList );
		}else if (option == OPTION_SEARCH) {
			TuitionRegisterStudent.setHeader("SEARCH");
			TuitionRegisterStudent.searchRegister(registerList);
			
		}else if (option == OPTION_UPDATE) {
			TuitionRegisterStudent.setHeader("UPDATE TUITION STATUS");
			TuitionRegisterStudent.UpdateStatus(registerList);
		}else if (option == OPTION_WAITLIST) {
			TuitionRegisterStudent.setHeader("PLACE STUDENT ON WAIT LIST");
			TuitionRegisterStudent.WaitList(registerList);
			
			
		} else if (option == OPTION_QUIT) {
			System.out.println("Bye!");
		} else {
			System.out.println("Invalid option");
						
			}
		}
	}
	
	
	
	public static void menu() {
		TuitionRegisterStudent.setHeader("REGISTER FOR A TUITION");
		System.out.println("1. Display all Reigsters");
		System.out.println("2. Add a registration");
		System.out.println("3. Delete existing registration");
		System.out.println("4. Search existing registration");
		System.out.println("5. Update Tuition status");
		System.out.println("6. Place Student on Waiting list");
		System.out.println("7. Quit");
		Helper.line(80, "-");

	}
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	//================================= Option 1 View (CRUD - Read) =================================
	public static String retrieveAllRegister(ArrayList<Register> registerList) { 
		String output = "";

		for (int i = 0; i < registerList.size(); i++) {

			output += String.format("%-84s", registerList.get(i).toString());
		}
		return output;
	}
	public static void viewAllRegister(ArrayList<Register> registerList) {
		Helper.line(80, "-");
		System.out.println("REGISTER LIST");
		Helper.line(80, "-");
	
		String output = String.format("%-10s %-20s %-20s %-10s %-20s %-10s\n", "REGISTER ID", "TIMETABLE ID",
				"EMAIL", "STATUS","REGISTER DATE", "WAITING LIST");
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
			String waitList = Helper.readString("Student on waiting list? > ");

			Register rr= new Register(RegID, timetableID, email, status, RegDate,waitList);
			return rr;
			
		}
		public static void addRegister(ArrayList<Register> registerList, Register rr) {
			
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
			String regID = Helper.readString("Enter Register ID to delete> ");
			
			Boolean isDeleted =doDeleteRegister(registerList, regID);
			if (isDeleted == false) {
				System.out.println("Invalid Register ID");
			} else {
				System.out.println("Register ID  " + regID + " deleted");
			}
		}
		
		public static boolean doSearchRegister (ArrayList<Register> registerList, String regID) {
			
			boolean isSame = false;

			for (int i = 0; i < registerList.size(); i++) {
				
				if (registerList.get(i).getRegID().equals(regID)) {
					String heading = String.format("%-10s %-20s %-20s %-10s %-20s\n", "REGISTER ID", "TIMETABLE ID",
							"EMAIL", "STATUS","REGISTER DATE");
					String output = String.format("%-10s %-20s %-20s %-10s %-20s\n",  registerList.get(i).getRegID() ,  registerList.get(i).getTimetableID(),
							registerList.get(i).getEmail(), registerList.get(i).getStatus(), registerList.get(i).getRegDate());
					
					System.out.println(heading);
					System.out.println(output);
					isSame = true;
					 }			
			}
			return isSame;
				
		}
		
		public static void searchRegister(ArrayList<Register> registerList) {
			String regID = Helper.readString("Search Register ID by ID> ");
			Boolean isSame =doSearchRegister(registerList, regID);	
			
			if (isSame == false) {
				System.out.println("Invalid Register ID");
			}
		}
		
		public static boolean doUpdateStatus(ArrayList<Register> registerList, String regID, String status) {
			boolean isUpdated = false;

			for (int i = 0; i < registerList.size(); i++) {
				
				if(registerList.get(i).getRegID().equals(regID) && registerList.get(i).getStatus() != "pending") {
					registerList.get(i).setStatus(status);
					
					isUpdated = true;
				}
			}
			return isUpdated;
				
		}
		public static void UpdateStatus(ArrayList<Register> registerList) {
			String regID = Helper.readString("Enter Register ID>");
			String status = Helper.readString("Update status to >");
			Boolean isUpdated =doUpdateStatus(registerList, regID, status);	
		
			if (isUpdated== false) {
				System.out.println("Invalid Register ID");
			} else {
				System.out.println("Register ID  " + regID + " updated");
			}
		}
		public static boolean doWaitList(ArrayList<Register> registerList, String regID, String waitList) {
			boolean isWaitList = false;
			
			for (int i = 0; i < registerList.size(); i++) {
				
				if(registerList.get(i).getRegID().equals(regID)) {
					registerList.get(i).setWaitList(waitList);
					
					isWaitList = true;
				}
			}
			return isWaitList;
		}
		
		public static void WaitList(ArrayList<Register> registerList) {
			String regID = Helper.readString("Enter Register ID>");
			String waitList = Helper.readString("Student on waiting list? >");
			Boolean isWaitList = doWaitList(registerList, regID, waitList);
			
			if (isWaitList== false) {
				System.out.println("Invalid Register ID");
			} else {
				System.out.println("Register ID  " + regID + "has been added to the waiting list");
			}
			//minxi
			
			
			
		}
		
	
	
}
			
			
			
	
	

	
	


