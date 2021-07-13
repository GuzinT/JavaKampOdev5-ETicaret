package odev5.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import odev5.dataAccess.abstracts.UserDao;
import odev5.entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List<User>users=new ArrayList<User>();

	@Override
	public void add(User user) {
		users.add(user);
		System.out.println("Hibernate ile eklendi"+user.getFirstName());
	}

	@Override
	public List<User> getAll() {
		return users;
	}

	@Override
	public boolean emailCheck(String email) {
		for(User i: users) {
			if(i.getEmail()==email) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean passwordCheck(String password) {
		for(User i: users) {
			if(i.getPassword()==password) {
				return true;
			}
		}		
		return false;
	}



}
