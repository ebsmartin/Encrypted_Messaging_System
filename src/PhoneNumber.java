/**
 * Basic object to hold phone numbers. It can be assumed phone numbers are 10 digits
 *
 *
 * @author ERIC MARTIN <br>
 *         EBMARTIN@COLOSTATE.EDU <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 202010
 */
public class PhoneNumber {
    private String type;
    private String number;

    /**
     * The type of phone number - mobile, home, office, other
     * @return the type associated with the number
     */
    public String getType() {
        return type;
    }

    /**
     * sets the type of phone number
     * @param type string to set it to
     */
    public void setType(String type) {
    	if(type.equalsIgnoreCase("Mobile")) {
    		this.type = "Mobile";
    		
    	}
    	else if(type.equalsIgnoreCase("Home")) {
    		this.type = "Home";
    	}
    	else if(type.equalsIgnoreCase("Office")) {
    		this.type = "Office";
    	}
    	else if(type.equalsIgnoreCase("Other")) {
    		this.type = "Other";
    	}
    	else {
    		this.type = "Other"; //Sets invalid entries to Other
    		//System.out.println("Enter a valid Phone Type: Mobile, Home, Office, Other");
    	}
    }

    /** Gets the phone number as *raw numbers* only **/
    public String getNumber() {
        return number;
    }

    /** Sets the phone number. Number will be set as raw numbers 5554443333 for example, NOT (555)444-3333 **/
    // EDITED BY STUDENT
    public void setNumber(String number) {
    	if(number.length() == 10) {
    		this.number = number;
    	}
    	else {
    		System.out.println("Invalid phone number. Please enter a 10 digit phone number.");
    		this.number = "0000000000"; //sets number to 0000000000 to ensure null doesn't crash the program.
    	}
    }

    /** Gets the first 3 digits, you can assume US Standard, so 10 digits **/
    //TODO STUDENT - COMPLETE
    public String getAreaCode() {
        return number.substring(0, 3); 
    }

    /** Gets the second three digits. In the number (555) 444-3333, 444 would be the prefix. Remember, phone
     * numbers are stored as number strings only, so 5554443333.
     * @return the prefix
     */
    // TODO STUDENT - COMPLETE
    public String getPrefix() {
        return number.substring(3, 6);
    }

    /** get the last four digits in a number (so location 6 onward) **/
    // TODO STUDENT - COMPLETE
    public String getLine() {
        return number.substring(6,10); 
    }

    /**
     * Reformats a 10 digit only number, into US Standard display format, so 5554443333 becomes (555) 444-3333
     * @return a US Standard formatted number
     */
    // TODO STUDENT - COMPLETE
    public String getPrettyNumber() {
    	String prettyNumber = String.format("(%s) %s-%s", getAreaCode(), getPrefix(), getLine());
        return prettyNumber; 
    }

    /**
     * Returns a string of format type: prettyNumber   - the type is 7 padded (%-7s)
     * @return
     */
    // TODO STUDENT - COMPLETE
    public String render() {
        return String.format("%-7s %s", type + ":", getPrettyNumber());
    }

    /**
     * Basic constructor
     * @param type the type of number
     * @param number the phone number as a ten digit string
     */
    public PhoneNumber(String type, String number) {
        setType(type);
        setNumber(number);
    }

}
