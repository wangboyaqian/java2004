package com.qfedu.controller;

import com.qfedu.entity.NewStudent;
import com.qfedu.entity.ScoreResult;
import com.qfedu.service.NewStudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EchartsController {
    @Autowired
    private NewStudentInfoService newStudentInfoService;

    @RequestMapping("/hello.do")
    @ResponseBody
    public List<NewStudent> page() {
        List<NewStudent> newStudents = newStudentInfoService.getAllStudent();
        System.out.println(newStudents.size());
        return newStudents;
    }
    @RequestMapping(value = "/getData")
    @ResponseBody
    public List<ScoreResult> getData() {
        List<NewStudent> students = newStudentInfoService.getAllStudent();
        List<ScoreResult> results = new ArrayList<ScoreResult>();
        for (NewStudent newStudent : students) {
            //把学生的成绩和姓名封装到一个result
            ScoreResult result = new ScoreResult(newStudent.getScore(), newStudent.getName());
            results.add(result);
        }
        return results;
    }
}
