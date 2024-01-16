package com.ty.compositekey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class ValidateUserByPasswordAndEmail {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		String sql="select y from User y where y.userId.email=?1 and y.password=?2";
		Query query=entityManager.createQuery(sql);
		
		query.setParameter(1, "boy@gmail");
		query.setParameter(2, "badboy1233");
		
	List<User> user	=query.getResultList();
	
	if(user.size()>0) {
		for(User user2:user) {
			System.out.println(user2.getUserId().getEmail());
			System.out.println(user2.getPassword());
			System.out.println("yes useris valid");
		}
	}else {
		System.out.println("not valid user");
	}
		
	}

}
