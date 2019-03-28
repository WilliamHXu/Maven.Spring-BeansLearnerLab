package com.example.demo.ConfigTests;

import com.example.demo.Student;
import com.example.demo.StudentConfig;
import com.example.demo.Students;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentConfigTest {


    @Autowired
    private StudentConfig studentConfig;

    @Test
    public void currentStudentsTest(){
        Students students = studentConfig.currentStudents();
        ArrayList<Student> arrayList = (ArrayList<Student>) students.findAll();
        for (int i = 0; i < arrayList.size(); i++) {
            String expectedName = studentConfig.currentStudentsNames[i];
            String actualName = arrayList.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
    }

    @Test
    public void previousStudentsTest(){
        Students students = studentConfig.previousStudents();
        ArrayList<Student> arrayList = (ArrayList<Student>) students.findAll();
        for (int i = 0; i < arrayList.size(); i++) {
            String expectedName = studentConfig.previousStudentsNames[i];
            String actualName = arrayList.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
    }

}
