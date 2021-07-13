package odev5;

import odev5.business.abstracts.UserService;
import odev5.business.concretes.UserCheckManager;
import odev5.business.concretes.UserManager;
import odev5.core.GoogleRegisterAdapter;
import odev5.dataAccess.abstracts.UserDao;
import odev5.dataAccess.concretes.HibernateUserDao;
import odev5.entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		
        User user1= new User(1,"Güzin","TURGUT","guzin@gmail.com","123456");
        /*User user2= new User(2,"Mehmet","Yýlmaz","mehmet@gmail.com","567890"); 
        User user3= new User(3,"Ilgýn","Yalçýn","ýlgýn@gmail.com","112233"); */
        
        UserDao userDao = new HibernateUserDao();
		UserService userService = new UserManager(userDao, new UserCheckManager(userDao), new GoogleRegisterAdapter());

		userService.signUp(user1); userService.userVerify(user1);
		userService.signIn(user1.getEmail(),user1.getPassword());
	}

}
