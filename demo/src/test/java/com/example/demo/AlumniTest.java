package com.example.demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AlumniTest {

    @Autowired
    private Alumni alumni;

    @Test
    public void constructionTest(){
        Instructors instructors = alumni.getInstructors();
        Students students = alumni.getStudents();
        Integer numberOfInstructors = instructors.size();
        Integer numberOfStudents = students.size();
        Double numberOfHoursToTeachEachStudent = 1200d;
        Double numberOfHoursToTeach = numberOfHoursToTeachEachStudent * numberOfStudents;
        Double numberOfHoursPerInstructor = numberOfHoursToTeach / numberOfInstructors;
        for (Student student : students) {
            Assert.assertEquals((Double) 1200d, student.getTotalStudyTime());
        }
        for (Instructor instructor : instructors) {
            Assert.assertEquals(numberOfHoursPerInstructor, instructor.getNumberOfHoursTaught());
        }
    }
}