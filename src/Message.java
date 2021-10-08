/**
 *
 * Holds a message for the client, so they can read it.
 *
 * @author ERIC MARTIN <br>
 *         EBMARTIN@COLOSTATE.EDU <br>
 *         Computer Science Department <br>
 *         Colorado State University
 * @version 202010
 */
public class Message {
    private String message;
    private String encryptionType;
    private String from;
    private String to;
    private String subject;

    /** Gets the message. Just a simple text String **/
    //TODO STUDENT - COMPLETE
    public String getMessage() {
        return message; 
    }

    /** sets the message, Just a simple text string**/
    //TODO STUDENT - COMPLETE
    public void setMessage(String message) {
    	this.message = message;
        
    }

    /** Gets the encryption type **/
    //TODO STUDENT - COMPLETE
    public String getEncryptionType() {
        return encryptionType; 
    }

    /** sets the encryption type. **/
    //TODO STUDENT - COMPLETE
    public void setEncryptionType(String encryptionType) {
        this.encryptionType = encryptionType; // no check if appropriate type is entered.
    }

    /** gets the sender email **/
    //TODO STUDENT - COMPLETE
    public String getFrom() {
        return from; 
    }

    /** sets the sender email **/
    //TODO STUDENT - COMPLETE
    public void setFrom(String from) {
        this.from = from;
    }

    /** get the to email **/
    //TODO STUDENT - COMPLETE
    public String getTo() {
        return to; 
    }

    /** sets the to email **/
    //TODO STUDENT - COMPLETE
    public void setTo(String to) {
        this.to = to;
    }

    /** gets the subject line **/
    //TODO STUDENT - COMPLETE
    public String getSubject() {
        return subject; 
    }

    /** sets the subject line **/
    //TODO STUDENT - COMPLETE
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // -----------------------------------  Don't modify below this line

    /**
     * renders the head of the message for printing
     */
    private String renderHead() {
        return String.format("     To: %s%n", getTo()) +
               String.format("   From: %s%n", getFrom()) +
               String.format("Subject: %s%n", getSubject()) +
               String.format("--------------------------------%n");

    }

    /** renders the message assuming no decrypting **/
    public String render() {
       return renderHead() + getMessage() + "\n";
    }

    /** renders with decryption **/
    public String render(String encryptionKey) {
        return renderHead() + getMessage(encryptionKey) + "\n";
    }


    /** gets a message based on the encryptionKey **/
    public String getMessage(String encryptionKey) {
        String rtn = message;
        if(getEncryptionType().equals(SubstitutionCipher.TYPE)) {
            rtn = SubstitutionCipher.decrypt(message, encryptionKey);

        }else if(getEncryptionType().equals(ShiftingCaesarCipher.TYPE)) {
            rtn = ShiftingCaesarCipher.decrypt(message, encryptionKey);
        }
        return rtn;
    }

    /** sets a message and encrypts it based on type and key **/
    public void setMessage(String message, String encryptionType, String encryptionKey) {
        if(encryptionType.equals(SubstitutionCipher.TYPE)) {
            message = SubstitutionCipher.encrypt(message, encryptionKey);
        }else if(encryptionType.equals(ShiftingCaesarCipher.TYPE)) {
            message = ShiftingCaesarCipher.encrypt(message, encryptionKey);
        }
        setMessage(message);
        setEncryptionType(encryptionType);
    }

    /**
     * Sets up a basic message, assuming no encryption
     * @param to email
     * @param from email
     * @param subject subject line
     * @param message the message
     */
    public Message(String to, String from, String subject, String message) {
        setTo(to);
        setFrom(from);
        setSubject(subject);
        setMessage(message);
    }

    /**
     * Constructs a message that automatically encrypts
     * @param to  an email
     * @param from an email
     * @param subject subject line
     * @param message  message
     * @param encryptionType type of encryption
     * @param encryptionKey the key to encrypt it with
     */
    public Message(String to, String from, String subject, String message, String encryptionType, String encryptionKey) {
        setTo(to);
        setFrom(from);
        setSubject(subject);
        setMessage(message, encryptionType, encryptionKey);
    }

}
