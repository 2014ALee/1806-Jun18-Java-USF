package com.revature;

import com.revature.models.User;

public class PassByValueDriver {
	public static void main(String[] args) {
		/*
		 * Passing objects as parameters
		 * 
		 * When we declare an object reference (String myStr), it is just that.
		 */
		User user = new User("Xi", "Jinping", "XiJinping", "china", "xi.jinping@gmail.com");
		System.out.println(user);
		changeEmail(user);
		System.out.println(user);
		User user2 = new User("Xi", "Jinping", "XiJinping", "china", "xi.jinping@gmail.com") {
			@Override
			public String toString() {
				return "User [firstName=" + this.getFirstName() + ", lastName="
						+ this.getLastName() + ", username=" + this.getUsername()
						+ ", password=" + this.getPassword() + ", email="
						+ this.getEmail() + "]";
			}
		};
		System.out.println(user2);
		changeEmail(user2);
		System.out.println(user2);
		
	}
	private static void changeEmail(User u) {
		u.setEmail("xi.jinping@gov.cn");
	}
}
