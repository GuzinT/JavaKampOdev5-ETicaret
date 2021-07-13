package odev5.business.concretes;

import odev5.business.abstracts.UserCheckService;
import odev5.business.abstracts.UserService;
import odev5.core.GoogleRegisterAdapter;
import odev5.dataAccess.abstracts.UserDao;
import odev5.entities.concretes.User;

public class UserManager implements UserService{

	public boolean status =false;
	
	UserDao userDao;
	UserCheckService userCheckService;
	GoogleRegisterAdapter systemService;
	
	public UserManager(UserDao userDao, UserCheckService userCheckService, GoogleRegisterAdapter systemService) {
		super();
		this.userDao = userDao;
		this.userCheckService = userCheckService;
		this.systemService = systemService;
	}

	@Override
	public void signIn(String email, String password) {
		if (userDao.emailCheck(email) == false && userDao.passwordCheck(password) == false) {

			System.out.println("Girilen bilgiler yanl��.");

		} 
		else if (userDao.emailCheck(email) == false) {

		System.out.println("Yanl�� Email adresi girdiniz..");

		} else if (userDao.passwordCheck(password) == false) {

			System.out.println("Yanl�� �ifre girdiniz.");

		} 
		else {
			System.out.println("Sisteme Giri� Ba�ar�l�.");
		}
		
	}

	@Override
	public void signUp(User user) {
		if (userCheckService.checkEmailValidation(user) == true && userCheckService.checkFirstName(user) == true
				&& userCheckService.checkLastName(user) == true && userCheckService.checkPassword(user) == true) {

			if (userDao.emailCheck(user.getEmail()) == false) {
				systemService.sendMail(user.getEmail());
				status = true;
			} else {
				System.out.println("Email daha �nce kullan�lm��t�r.");
				status = false;
			}
		} else {
			status = false;
		}
		
	}

	@Override
	public void userVerify(User user) {
		if (status == true) {
			userDao.add(user);
			System.out.println("'" + user.getFirstName() + " " + user.getLastName() + "'" + " Kullan�c� sisteme eklendi.");
			status = false;
		} else {
			System.out.println("Kullan�c� bulunamad�.");
			status = false;
		}
		
	}

}
