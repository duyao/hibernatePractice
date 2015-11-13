package com.dy.hibernate.sortedSet;

//sortedSet需要实现Comparable<Certificate>
public class Certificate implements Comparable<Certificate> {

	private int id;
	private String name;

	public Certificate() {
	}

	public Certificate(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int compareTo(Certificate that) {
		// TODO Auto-generated method stub
		//怎么排序的？换了-1和1的位置都是一样的，字典顺序的
		final int BEFORE = 1;
		final int AFTER = -1;
		System.out.println("11111111111111111111111111111111111");
		if (that == null) {
			return BEFORE;
		}

		Comparable thisCertificate = this.getName();
		Comparable thatCertificate = that.getName();

		if (thisCertificate == null) {
			return AFTER;
		} else if (thatCertificate == null) {
			return BEFORE;
		} else {
			return thisCertificate.compareTo(thatCertificate);
		}
	}

}
