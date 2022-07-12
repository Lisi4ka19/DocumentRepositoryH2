package documentrepositoryh2security.dto;

public class VerificationToken {

    private String userName;

    private String verificationCode;

    private String rightVerificationCode;

    public VerificationToken() {
    }

    public VerificationToken(String userName, String rightVerificationCode) {
        this.userName = userName;
        this.rightVerificationCode = rightVerificationCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getRightVerificationCode() {
        return rightVerificationCode;
    }

    public void setRightVerificationCode(String rightVerificationCode) {
        this.rightVerificationCode = rightVerificationCode;
    }
}
