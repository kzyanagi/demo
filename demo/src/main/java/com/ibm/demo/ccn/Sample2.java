package com.ibm.demo.ccn;

public class Sample2 {

	private static final String FEMALE = "FEMALE";
	private static final String MALE = "MALE";

	private static final int TEN = 10;
	private static final int TWENTY = 20;
	private static final int THIRTY = 30;

	public void hantei(String sex, int generation) {

		if (FEMALE.equals(sex)) {
			HanteFemaleGenneration(generation);
		} else if (MALE.equals(sex)) {
			HanteMaleGenneration(generation);
		}
	}

	private void HanteFemaleGenneration(int generation) {
		if (generation == TEN) {
			System.out.println("10代女性");
		} else if (generation == TWENTY) {
			System.out.println("２0代女性");
		} else if (generation == THIRTY) {
			System.out.println("３0代女性");
		}
	}

	private void HanteMaleGenneration(int generation) {
		if (generation == TEN) {
			System.out.println("１0代男性");
		} else if (generation == TWENTY) {
			System.out.println("20代男性");
		} else if (generation == THIRTY) {
			System.out.println("30代男性");
		}

	}

}
