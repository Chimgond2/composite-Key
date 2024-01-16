package com.ty.compositekey;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class GetUserByEmailId {
	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager=entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction=entityManager.getTransaction();
		
		String sql="select t from User t where t.userId.email=?1";
			Query query=entityManager.createQuery(sql);
			query.setParameter(1, "boy1@gmail");
			
			List<User> users=query.getResultList();
			if(users.size()>0) {
				for(User user:users) {
					System.out.println("age is "+user.getAge());
					System.out.println("gender is "+user.getGender());
					System.out.println("password is "+ user.getPassword());
					System.out.println("name is "+ user.getName());
					System.out.println("emailis :"+user.getUserId().getEmail());
					System.out.println("phone is "+user.getUserId().getPhone());
				}
			}else {
				System.out.println("there is no datail");
			}
			
	}

}
