package com.revature.beans;

import org.springframework.stereotype.Component;

@Component
public class Bear {

		
		private static boolean isWinter = false;
		private static boolean isFull = false;
		private static boolean isAwake= true;
		public static boolean isWinter() {
			return isWinter;
		}
		public static void setWinter(boolean isWinter) {
			Bear.isWinter = isWinter;
		}
		public static boolean isFull() {
			return isFull;
		}
		public static void setFull(boolean isFull) {
			Bear.isFull = isFull;
		}
		public static boolean isAwake() {
			return isAwake;
		}
		public static void setAwake(boolean isAwake) {
			Bear.isAwake = isAwake;
		}
		
		public void bearHibernates() throws Exception{
			if(!Bear.isWinter) {
				throw new Exception("bears hibernate in winter");
			}else {
				System.out.println("zzzzzzzzzz");
				//something else goes here idk
			}
			
		}
	}

