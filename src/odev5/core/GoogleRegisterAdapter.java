package odev5.core;

import odev5.Google.GoogleManager;

public class GoogleRegisterAdapter implements GoogleService{

	@Override
	public void sendMail(String email) {
		GoogleManager googleOperation=new GoogleManager();
		googleOperation.sendToGoogleAccount(email);
	
	}

	@Override
	public boolean checkValidation(String email) {
		GoogleManager googleOperation=new GoogleManager();
		googleOperation.checkAccount(email);
		return false;
	}


}
