package odev5.Google;

public class GoogleManager {
	public void sendToGoogleAccount(String googleAccount) {
		System.out.println(googleAccount + " hesab�na do�rulama maili g�nderildi.");
	}
	public boolean checkAccount(String googleAccount) {
		System.out.println(googleAccount + " hesab�n�n do�rulama i�lemi ger�ekle�tirildi.");
		return true;
	}
}
