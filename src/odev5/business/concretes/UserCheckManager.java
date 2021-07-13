package odev5.business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import odev5.business.abstracts.UserCheckService;
import odev5.dataAccess.abstracts.UserDao;
import odev5.entities.concretes.User;

public class UserCheckManager implements UserCheckService{
	UserDao userDao;	

	public UserCheckManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public boolean checkFirstName(User user) {
		if (user.getFirstName().isEmpty()) {
			System.out.println("Zorunlu alanlar boş bırakılamaz.");
			return false;
		} else {
			if (user.getFirstName().length() <= 2) {
				System.out.println("İsminiz 3 karakterden kısa olamaz.");
				return false;
			}
		}
		return true;
	}


	@Override
	public boolean checkLastName(User user) {
		if (user.getLastName().isEmpty()) {
			System.out.println("Zorunlu alanlar boş bırakılamaz.");
			return false;
		} else {
			if (user.getLastName().length() <= 2) {
				System.out.println("İsminiz 3 karakterden kısa olamaz.");
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean checkEmailValidation(User user) {
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(user.getEmail());
		if (matcher.matches()==true) {
			return true;
		}else {
			System.out.println("Email uygun değil.");
			return false;
		}
	}

	@Override
	public boolean checkPassword(User user) {
		if (user.getPassword().isEmpty()) {
			System.out.println("Zorunlu alanlar boş bırakılamaz.");
			return false;
		} else {
			if (user.getPassword().length() < 5) {
				System.out.println("Şifreniz 5 karakterden kısa olamaz.");
				return false;
			}
		}
		return true;
	}
	

}
