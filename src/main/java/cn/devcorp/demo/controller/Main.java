package cn.devcorp.demo.controller;

import cn.devcorp.demo.enums.Skill;

public class Main {
    public static void main(String[] args) {
        Skill mySkill = Skill.INTERMEDIATE;
        switch(mySkill) {
            case BEGINNER:
                System.out.println("Beginner");
                break;
            case INTERMEDIATE:
                System.out.println("Intermediate");
                break;
            case PROFICIENT:
                System.out.println("Proficient");
                break;
            case EXPERT:
                System.out.println("Expert");
        }
    }
}  