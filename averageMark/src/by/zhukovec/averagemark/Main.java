package by.zhukovec.averagemark;

import by.zhukovec.averagemark.action.AverageMark;
import by.zhukovec.averagemark.entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Anna on 15.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Map subjects1 = new HashMap<Subject, Integer>();

        subjects1.put(Subject.HISTORY, 6);
        subjects1.put(Subject.MATH, 10);
        subjects1.put(Subject.PE, 9);
        Student student1 = new Student("Ivan", "Ivanov", subjects1);

        Map subjects2 = new HashMap<Subject, Integer>();
        subjects2.put(Subject.HISTORY, 6);
        subjects2.put(Subject.MATH, 10);
        subjects2.put(Subject.PE, 9);
        Student student2 = new Student("Anton", "Sergeev", subjects2);

        Map subjects3 = new HashMap<Subject, Integer>();
        subjects3.put(Subject.HISTORY, 9);
        subjects3.put(Subject.MATH, 7);
        subjects3.put(Subject.PE, 6);
        subjects3.put(Subject.ECONOMY, 8);
        Student student3 = new Student("Kate", "Shenec", subjects3);

        Map subjects4 = new HashMap<Subject, Integer>();
        subjects4.put(Subject.TOPOLOGY, 5);
        subjects4.put(Subject.IT, 4);
        subjects4.put(Subject.PE, 6);
        Student student4 = new Student("Daria", "Belko", subjects4);

        Map subjects5 = new HashMap<Subject, Integer>();
        subjects5.put(Subject.TOPOLOGY, 9);
        subjects5.put(Subject.IT, 10);
        subjects5.put(Subject.PE, 7);
        subjects5.put(Subject.WEB, 9);
        Student student5 = new Student("Alex", "Perez", subjects5);

        Map subjects6 = new HashMap<Subject, Integer>();
        subjects6.put(Subject.TOPOLOGY, 8);
        subjects6.put(Subject.IT, 6);
        subjects6.put(Subject.PE, 6);
        subjects6.put(Subject.WEB, 9);
        Student student6 = new Student("Nikita", "Subbot", subjects6);

        List<Student> studentsGroup1 = new ArrayList<>();
        studentsGroup1.add(student1);
        studentsGroup1.add(student2);
        Group group1 = new Group(1, studentsGroup1);

        List<Student> studentsGroup2 = new ArrayList<>();
        studentsGroup2.add(student3);
        Group group2 = new Group(2, studentsGroup2);

        List<Student> studentsGroup3 = new ArrayList<>();
        studentsGroup3.add(student4);
        studentsGroup3.add(student5);
        studentsGroup3.add(student6);
        Group group3 = new Group(1, studentsGroup3);

        List<Group> groupsFaculty1 = new ArrayList<>();
        groupsFaculty1.add(group1);
        groupsFaculty1.add(group2);
        Faculty faculty1 = new Faculty("MMF", groupsFaculty1);

        List<Group> groupsFaculty2 = new ArrayList<>();
        groupsFaculty2.add(group3);
        Faculty faculty2 = new Faculty("SBMT", groupsFaculty2);

        List<Faculty> faculties = new ArrayList<>();
        faculties.add(faculty1);
        faculties.add(faculty2);

        University university = new University(faculties);

        System.out.println("Средний балл у студента " + student1.getFirstName() + ": " + student1.getLastName() + " " + AverageMark.findingByStudent(student1));
        System.out.println("Средний балл в группе " + group2.getGroupNumber() + ": " + AverageMark.findingByGroup(group2));
        System.out.println("Средний балл на факультете " + faculty1.getFacultyName() + ": " + AverageMark.findingByFaculty(faculty1));
        System.out.println("Средний балл в университете: " + AverageMark.findingByUniversity(university));
        System.out.println("Средний балл по экономике в университете: " + AverageMark.findingByProjectInUniversity(university, Subject.ECONOMY));
        System.out.println("Средний балл по физкультуре на факультете " + faculty1.getFacultyName() + ": " + AverageMark.findingByProjectInFaculty(faculty1, Subject.PE));
        System.out.println("Средний балл по истории в группе " + group1.getGroupNumber() + ": " + AverageMark.findingByProjectInGroup(group1, Subject.HISTORY));
    }
}
