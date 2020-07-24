package com.lonry.model;

public enum UserType {
	//在第一行显式地列出3个枚举实例(枚举值)，系统会自动添加 public static final 修饰，
	//因为已经定义了带参数的构造器，所以在列出枚举值时必须传入对应的参数
	ADMIN("系统管理员",0),TEACHER("教师",1),STUDENT("学生",2);
	private String name;
	private int index;
	
	//定义有两个参数的构造器
	private UserType(String name,int index) {
		this.name = name;
		this.index = index;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	@Override
	public String toString() {
		return this.name;
	}
}
