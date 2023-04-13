package com.eric.whatsup.core;

import com.eric.whatsup.domain.Student;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.*;


public class App {

    public void run() {
        //List<Student> studentList = new ArrayList<>();


        Map<String, Student> studentMap = new HashMap<>();

        String id = UUID.randomUUID().toString();
        Student student1 = new Student(id, "Eric", "Son", 14, 8);
        studentMap.put(id, student1);

        id = UUID.randomUUID().toString();
        Student student2 = new Student(id, "John", "Doe", 16, 10);
        studentMap.put(id, student2);

//        studentList.add(student1);
//        studentList.add(student2);


        String jsonString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(student1);
            System.out.println(jsonString);
        }
        catch (Exception e) {
            e.printStackTrace();
        }


        // convert the json back to Class object
        try {
            Student student1Obj = objectMapper.readValue(jsonString, Student.class);
            System.out.println(student1Obj.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
       App app = new App();
       app.run();
    }
}
