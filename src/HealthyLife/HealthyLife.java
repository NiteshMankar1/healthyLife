package HealthyLife;

public class HealthyLife 
{
   public static void sendSms(String message,String number)           // Method sendSms with parameters
	 {
		 System.out.println(message);
		 System.out.println(number);
		 try                                                              // We are using this all in try and catch block to avoid mistakes 
		 {
		 String apikey="83sf6iHjpQCPDqARu5lTdSXmkFn74eUOrgGxazLc0YVIKtvbJoiLDu64KQlt5m9dvCGUkjWR8z3ZNbTI";     // Saving apikey taken from message gateway company
		 String sendID="FSTSMS";                                          // Specifying SenderID
		                                                                  // important step               
		 message=URLEncoder.encode(message, "UTF-8");                     // To decode characters into Unicode (Unicode= Each char,no,symbol has its own number) 
		 
		 String language="english";                                       // Specifying Language given on the message gateway platform
		 
		 String route="p";                                       
		 
		 
		 String myUrl="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&sender_id="+sendID+"&message="+message+"&variable_values="+language+"&route="+route+"&numbers="+number;
		
		                                                                  // Sending get request to get message  
		 
		 URL url=new URL(myUrl);                                          // Creation of object of myURL
		 
		 HttpsURLConnection con=(HttpsURLConnection)url.openConnection(); //  Opens Connection with specified URL   
		 
		 
		 con.setRequestMethod("GET");                                     //  To set Request Method.In default we get "GET"
		 
		 con.setRequestProperty("user-Agent","Mozilla/5.0");              // Using Browser Token
		 con.setRequestProperty("cache-control","no-cache");              // submitting validation request 
		 
		 System.out.println("Wait......");                                // Asking for some time
		 
		 int code=con.getResponseCode();                                  // To take Response from the server
		 
		 System.out.println("Respond code : "+code);                      // To print the Response
		 
		 StringBuffer response=new StringBuffer();                        // To Read the data in buffer
		 
		 BufferedReader br=new BufferedReader(new InputStreamReader(con.getInputStream()));       // To access the data and stored in object 
		 while(true)                                                      // using While loop to read the data From br object  
		 {
			 String line=br.readLine();                                     // Reading the data
		 	 if(line==null)                                                 // using If statements for error or we can say for null messages
			 {
				 break;                                                       // If it is null then then break it
			 }
			 response.append(line);                                         // To concatenate the the message 
		 }
		 
		 System.out.println(response);                                    // Printing the Response
		 
		 }catch (Exception e)                                             // Ending The Try and catch loop with handling exception        
		  
		 {
			 e.printStackTrace();                                           // Method we are adding for to tell the error 
		 }
	 }
	 
	 
	 
	        public static void main(String [] args)                     // Using main function for calling
	  {
		  System.out.println("Time for Vaccine Sunita Sharma mam");       // Printing the line
		                        
		  LocalDate d= LocalDate.now();                                   // Making Object for displaying date
		  System.out.println("Date = "+d);                                // Asking for date
		  
		  LocalTime t= LocalTime.now();                                   // Making Object for displaying time
		  System.out.println("Time = "+t);                                // Asking for Time
		  
		  HealthyLife.sendSms("Time for Exercise mam "," ");                  // Calling Class then method and then using the messages
		  
}
