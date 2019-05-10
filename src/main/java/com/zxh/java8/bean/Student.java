package com.zxh.java8.bean;

public class Student {
    private String name;
    private int score;

    public Student(){

    }

    public Student(String name,int score){
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    @Override
	public String toString() {
		return "Student [name=" + name + ", score=" + score + "]";
	}

	//排序方法-非工具类，用this符合设计原则
    public  int compareStudentByScore(Student student){
        return this.getScore() - student.getScore();
    }
}