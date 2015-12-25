package com.ibm.demo.ccn;

public class Sample1 {
	
	private static final String FEMALE="FEMALE";
	private static final String MALE="MALE";
	
	private static final int TEN=10;
	private static final int TWENTY=20;
	private static final int THIRTY=30;

	
	public void hantei(String sex,int generation){	
	
		if(FEMALE.equals(sex) & generation==TEN){
			System.out.println("10代女性");
		}else if (FEMALE.equals(sex) & generation==TWENTY){
			System.out.println("２0代女性");
		}else if (FEMALE.equals(sex) & generation==THIRTY){
			System.out.println("３0代女性");
		}else if (FEMALE.equals(sex) & generation==40){
			System.out.println("40代女性");
		}else if (FEMALE.equals(sex) & generation==50){
			System.out.println("50代女性");
		}else if(MALE.equals(sex) & generation==TEN){
			System.out.println("１0代男性");
		}else if (MALE.equals(sex) & generation==TWENTY){
			System.out.println("20代男性");
		}else if (MALE.equals(sex) & generation==THIRTY){
			System.out.println("30代男性");
		}else if (MALE.equals(sex) & generation==40){
			System.out.println("４0代男性");
		}else if (MALE.equals(sex) & generation==50){
			System.out.println("５0代男性");
		}
		
		
	}

}
