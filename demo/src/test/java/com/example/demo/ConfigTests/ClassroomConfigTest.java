package com.example.demo.ConfigTests;

import com.example.demo.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClassroomConfigTest {

    @Autowired
    private ClassroomConfig classroomConfig;

    @Test
    public void currentCohortTest(){
        Classroom classroom = classroomConfig.currentCohort();
        Students students = classroom.getStudents();
        ArrayList<Student> arrayList = (ArrayList<Student>) students.findAll();
        for (int i = 0; i < arrayList.size(); i++) {
            String expectedName = StudentConfig.currentStudentsNames[i];
            String actualName = arrayList.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
        Instructors instructors = classroom.getInstructors();
        ArrayList<Instructor> arrayListInstructors = (ArrayList<Instructor>) instructors.findAll();
        for (int i = 0; i < arrayListInstructors.size(); i++) {
            String expectedName = InstructorsConfig.zcwNames[i];
            String actualName = arrayListInstructors.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
    }

    @Test
    public void previousCohortTest(){
        Classroom classroom = classroomConfig.previousCohort();
        Students students = classroom.getStudents();
        ArrayList<Student> arrayList = (ArrayList<Student>) students.findAll();
        for (int i = 0; i < arrayList.size(); i++) {
            String expectedName = StudentConfig.previousStudentsNames[i];
            String actualName = arrayList.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
        Instructors instructors = classroom.getInstructors();
        ArrayList<Instructor> arrayListInstructors = (ArrayList<Instructor>) instructors.findAll();
        for (int i = 0; i < arrayListInstructors.size(); i++) {
            String expectedName = InstructorsConfig.zcwNames[i];
            String actualName = arrayListInstructors.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
    }
}