package cn.devcorp.demo.pojo;

/**
 * Description: TODO
 *
 * @author YK107
 * @date 2023/11/20 16:22
 *
 * <pre>
 *              www.cloudscope.cn
 *      Copyright (c) 2019. All Rights Reserved.
 * </pre>
 */
public class Student {
    private String name;
    private String grade;
    private double score;
    public Student(String name, String grade, double score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade='" + grade + '\'' +
                ", score=" + score +
                '}';
    }
}
