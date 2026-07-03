package com.bistu.spring6iocxml.di;

import java.util.List;
import java.util.Map;

public class Student {
    private int sid;
    private String sname;
    private Map<String, Teacher> teacherMap;
    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Student() {
    }

    public Student(int sid, String sname, Map<String, Teacher> map, List<Lesson> list) {
        this.sid = sid;
        this.sname = sname;
        this.teacherMap = map;
        this.lessonList = list;
    }

    /**
     * 获取
     *
     * @return sid
     */
    public int getSid() {
        return sid;
    }

    /**
     * 设置
     *
     * @param sid
     */
    public void setSid(int sid) {
        this.sid = sid;
    }

    /**
     * 获取
     *
     * @return sname
     */
    public String getSname() {
        return sname;
    }

    /**
     * 设置
     *
     * @param sname
     */
    public void setSname(String sname) {
        this.sname = sname;
    }

    /**
     * 获取
     *
     * @return teacherMap
     */
    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    /**
     * 设置
     *
     * @param teacherMap
     */
    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", teacherMap=" + teacherMap +
                ", lessonList=" + lessonList +
                '}';
    }
}
