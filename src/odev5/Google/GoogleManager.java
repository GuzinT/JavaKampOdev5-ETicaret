package odev5.Google;

public class GoogleManager {
	public void sendToGoogleAccount(String googleAccount) {
		System.out.println(googleAccount + " hesabına doğrulama maili gönderildi.");
	}
	public boolean checkAccount(String googleAccount) {
		System.out.println(googleAccount + " hesabının doğrulama işlemi gerçekleştirildi.");
		return true;
	}
}
