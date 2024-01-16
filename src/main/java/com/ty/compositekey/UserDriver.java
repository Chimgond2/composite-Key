package com.ty.compositekey;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class UserDriver {
	
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		UserId userId=new UserId();
		userId.setPhone(115);
		userId.setEmail("boy@gmail");
		
		
		User user=new User();
		
		user.setAge(20);
		user.setGender("male");
		user.setName("gopi");
		user.setPassword("loverboy");
		
		user.setUserId(userId);
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		
	}

}
