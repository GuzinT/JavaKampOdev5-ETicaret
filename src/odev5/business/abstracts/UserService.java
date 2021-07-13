package odev5.business.abstracts;

import odev5.entities.concretes.User;

public interface UserService {
	
    void signIn(String email, String password);
    void signUp(User user);
	void userVerify(User user);
}
