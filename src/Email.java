/**
 *
 *  Basic holder for an email. You can assume an email is properly / safely formatted.
 *
 * @author ERIC MARTIN <br>
 *         EBMARTIN@COLOSTATE.EDU <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 202010
 */
public class Email {
    private String email;
    private String type; // options Home, Office, Other

    /** returns the email address **/
    public String getEmail() {
        return email;
    }

    /** sets the email address. No checks for valid email's**/
 // TODO STUDENT - COMPLETE
    public void setEmail(String email) {
        this.email = email;  
    }

    /** gets the type of email **/
    // TODO STUDENT - COMPLETE 
    public String getType() {
        return type; 
    }

    /** sets the type and ensure type is Home, Office, or Other**/
    // TODO STUDENT - COMPLETE
    public void setType(String type) {
    	if(type.equalsIgnoreCase("Home")) { 
    		this.type = "Home"; // this is how I ensure the output wouldn't be HOME or HoMe or home
    	}
    	else if(type.equalsIgnoreCase("Office")) {
    		this.type = "Office";
    	}
    	else if(type.equalsIgnoreCase("Other")) {
    		this.type = "Other";
    	}
    	else {
    		this.type = "Other"; // Sets invalid entries as Other
    		//System.out.println("Enter a valid Email type: Home, Office, or Other");
    	}
    }

    /** gets the client name's  E-name. This is the name before the @ in an email **/
    // TODO STUDENT - COMPLETE
    public String getEName() {
    	String eName = email.substring(0, email.indexOf('@')); // substring(begin index, end index)
        return eName; 
    }

    /** gets the domain of the email. This is the part after the @ in an email **/
    // TODO STUDENT - COMPLETE
    public String getDomain() {
    	String domain = email.substring(email.indexOf('@')+ 1);
        return domain;
    }

    /** renders the email as Type:  email - with 7 padding on the type **/
    //TODO STUDENT - COMPLETE
    public String render() {
        return String.format("%-7s %s", type + ":" , email);
    }

    /**
     * Basic constructor
     * @param type the type of email (home, work, etc)
     * @param email the email address
     */
    public Email(String type, String email) {
        setEmail(email);
        setType(type);
    }


}
