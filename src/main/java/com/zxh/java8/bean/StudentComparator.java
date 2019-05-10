package com.zxh.java8.bean;

public class StudentComparator<T> {
	
	private int flag = 0;
	
    public StudentComparator() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentComparator(int flag) {
		super();
		this.flag = flag;
	}

	//符合函数式接口Comparator<T,T>((T,T)->int)
	public int compareStudentByScore(Student student1,Student student2){
		System.out.println("flag:"+flag);
        return student2.getScore() - student1.getScore();
    }
	
	public static int compareStudentByScoreStatic(Student student1,Student student2) {
		return student2.getScore() - student1.getScore();
	}
	
}
