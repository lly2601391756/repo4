package com.chinasoft.Jsoup;

import com.chinasoft.pojo.Teacher;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class jsoupTest {
    public static void main(String[] args) throws IOException {
        String path = jsoupTest.class.getClassLoader().getResource("teachers.xml").getPath();
//        System.out.println(path);
        Document document = Jsoup.parse(new File(path), "utf-8");
        Elements names = document.getElementsByTag("name");
//        System.out.println(names.get(1).text());
        Elements genders = document.getElementsByTag("gender");
        Elements salarys = document.getElementsByTag("salary");
        List<Teacher> list = new ArrayList<Teacher>();
        Teacher teacher = null;
        String name = null;
        String gender = null;
        double salary;
        for (int i = 0; i < names.size(); i++) {
            teacher = new Teacher();
            name = names.get(i).text();
            gender = genders.get(i).text();
            salary = Double.parseDouble(salarys.get(i).text());
            teacher.setName(name);
            teacher.setGender(gender);
            teacher.setSalary(salary);
            list.add(teacher);
        }
        for (Teacher teacher1 : list) {
            System.out.println(teacher1);
        }

    }
}
