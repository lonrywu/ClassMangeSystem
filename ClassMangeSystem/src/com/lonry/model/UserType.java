package com.lonry.model;

public enum UserType {
	//�ڵ�һ����ʽ���г�3��ö��ʵ��(ö��ֵ)��ϵͳ���Զ���� public static final ���Σ�
	//��Ϊ�Ѿ������˴������Ĺ��������������г�ö��ֵʱ���봫���Ӧ�Ĳ���
	ADMIN("ϵͳ����Ա",0),TEACHER("��ʦ",1),STUDENT("ѧ��",2);
	private String name;
	private int index;
	
	//���������������Ĺ�����
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
