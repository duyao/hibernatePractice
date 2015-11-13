package com.dy.hibernate.sortedSet;

import java.util.Comparator;

public class MyClass implements Comparator<Certificate> {

	@Override
	public int compare(Certificate o1, Certificate o2) {
		// TODO Auto-generated method stub
		final int BEFORE = -1;
		final int AFTER = 1;
		System.out.println("!!!!!!!!!!!!!!!!!!!!!");
		/* To reverse the sorting order, multiple by -1 */
		if (o2 == null) {
			return BEFORE * -1;
		}

		Comparable thisCertificate = o1.getName();
		Comparable thatCertificate = o2.getName();

		if (thisCertificate == null) {
			return AFTER * 1;
		} else if (thatCertificate == null) {
			return BEFORE * -1;
		} else {
			return thisCertificate.compareTo(thatCertificate) * -1;
		}
	}

}
