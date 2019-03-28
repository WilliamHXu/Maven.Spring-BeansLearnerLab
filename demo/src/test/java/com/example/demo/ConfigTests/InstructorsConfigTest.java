package com.example.demo.ConfigTests;

import com.example.demo.Instructor;
import com.example.demo.Instructors;
import com.example.demo.InstructorsConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InstructorsConfigTest {

    @Autowired
    private InstructorsConfig instructorsConfig;

    @Test
    public void tcUsaInstructorsTest(){
        Instructors instructors = instructorsConfig.tcUsaInstructors();
        ArrayList<Instructor> arrayList = (ArrayList<Instructor>) instructors.findAll();
        for (int i = 0; i < arrayList.size(); i++) {
            String expectedName = instructorsConfig.tcUsaNames[i];
            String actualName = arrayList.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
    }

    @Test
    public void tcUKInstructorsTest(){
        Instructors instructors = instructorsConfig.tcUKInstructors();
        ArrayList<Instructor> arrayList = (ArrayList<Instructor>) instructors.findAll();
        for (int i = 0; i < arrayList.size(); i++) {
            String expectedName = instructorsConfig.tcUKNames[i];
            String actualName = arrayList.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
    }

    @Test
    public void zcwInstructorsTest(){
        Instructors instructors = instructorsConfig.zcwInstructors();
        ArrayList<Instructor> arrayList = (ArrayList<Instructor>) instructors.findAll();
        for (int i = 0; i < arrayList.size(); i++) {
            String expectedName = instructorsConfig.zcwNames[i];
            String actualName = arrayList.get(i).getName();
            Assert.assertEquals(expectedName, actualName);
        }
    }
}
