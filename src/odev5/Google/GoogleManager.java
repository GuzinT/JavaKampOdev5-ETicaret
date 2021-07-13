package odev5.Google;

public class GoogleManager {
	public void sendToGoogleAccount(String googleAccount) {
		System.out.println(googleAccount + " hesabýna doðrulama maili gönderildi.");
	}
	public boolean checkAccount(String googleAccount) {
		System.out.println(googleAccount + " hesabýnýn doðrulama iþlemi gerçekleþtirildi.");
		return true;
	}
}
