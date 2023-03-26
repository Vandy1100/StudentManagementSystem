package com.system.student;

import java.util.ArrayList;
import java.util.Scanner;

class Student{
    //Data Member
   private int id;
   private String name;
   private String gender;
   private int age;
   private String classroom;
   private double score;
    //Constructor Default Value
    Student(){
        id=0;
        name=null;
        gender=null;
        age=0;
        classroom=null;
        score=0;
    }
    // Constructor With Parameter
    public Student(int id, String name, String gender, int age, String classroom, double score) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.classroom = classroom;
        this.score = score;
    }
    //Input Value Student
    void inputStudent(Scanner sc){
        System.out.println("===========Input Student Information==============");
        boolean valueId= false;
        String strId;
        do{
            System.out.println("Enter Id :");
            try {
                strId=sc.next();
                id=Integer.parseInt(strId);
                valueId=true;
            }catch (Exception e){
                System.out.println("ERROR!! ID can only be Integer..!");
            }
        }while (!valueId);
        sc.nextLine();
        System.out.println("Enter Student Name :");
        name=sc.next();
        System.out.println("Enter Student Gender :");
        gender=sc.next();
        boolean valueAge= false;
        String strAge;
        do{
            System.out.println("Enter Student Age :");
            try {
                strAge=sc.next();
                age=Integer.parseInt(strAge);
                valueAge=true;
            }catch (Exception e){
                System.out.println("ERROR!! Age can only be Integer..!");
            }
        }while (!valueAge);
        sc.nextLine();
        System.out.println("Enter Student Class Room :");
        classroom=sc.next();
        boolean valueScore= false;
        String strScore;
        do{
            System.out.println("Enter Student Score :");
            try {
                strScore=sc.next();
                score=Double.parseDouble(strScore);
                valueScore=true;
            }catch (Exception e){
                System.out.println("ERROR!! Score Can Not Be String..!");
            }
        }while (!valueScore);
        System.out.println("SUCCESSFULLY ADDED STUDENT TO THE SYSTEM!");
    }
    //Getter Encapsulation
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getClassroom() {
        return classroom;
    }

    public double getScore() {
        return score;
    }

    public void setId(int id) {
        this.id = id;
    }

    //Update Value Student
    void updateStudent(Scanner sc){
        System.out.println("Enter Update Student Name :");
        name=sc.next();
        System.out.println("Enter Update Student Gender :");
        gender=sc.next();
        boolean valueAge= false;
        String strAge;
        do{
            System.out.println("Enter Update Student Age :");
            try {
                strAge=sc.next();
                age=Integer.parseInt(strAge);
                valueAge=true;
            }catch (Exception e){
                System.out.println("ERROR!! Age can only be Integer..!");
            }
        }while (!valueAge);
        sc.nextLine();
        System.out.println("Enter Update Student Class Room :");
        classroom=sc.next();
        boolean valueScore= false;
        String strScore;
        do{
            System.out.println("Enter Update Student Score :");
            try {
                strScore=sc.next();
                score=Double.parseDouble(strScore);
                valueScore=true;
            }catch (Exception e){
                System.out.println("ERROR!! Score Can Not Be String..!");
            }
        }while (!valueScore);
    }

    //Output Value Student
    void outputStudent(){
        System.out.println("id="+getId()+", Name="+getName()+", Gender="+getGender()+", Age="+getAge()+", ClassName="+getClassroom()+", Score="+getScore());
    }
    void pressKey(){
        Scanner sc = new Scanner(System.in);
        System.out.println("---------------Press Enter To Continue----------------");
        sc.nextLine();
    }

}
public class StudentManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        int op=0;
        do{
            //Manu list student Information
            System.out.println("========= Student Management System ==========");
            System.out.println("1. Insert Student To System.");
            System.out.println("2. Edit Student Information.");
            System.out.println("3. Search Student Information.");
            System.out.println("4. Delete Student Information.");
            System.out.println("5. Show Student Information.");
            System.out.println("6. Exit");
            System.out.println("----------------------------------");
            boolean valueManu=false;
            String strManu;
            do {
                System.out.println("Please Choose Option (1-6) :");
                try {
                    strManu=sc.next();
                    op=Integer.parseInt(strManu);
                    valueManu=true;
                } catch (Exception e) {
                    System.out.println("Error!! Invalid Input...! Try Again.");
                }
            }while (!valueManu);
                switch (op){
                    //Add Student Information
                    case 1:{
                        Student student = new Student();
                        student.inputStudent(sc);
                        list.add(student);
                        student.pressKey();
                    }break;
                    //Update Student Information
                    case 2:{
                        Student student = new Student();
                        System.out.println("==========Edit Student Information==========");
                        boolean editId= false;
                        String strId;
                        int editValueId=0;
                        do{
                            System.out.println("Enter Student ID To Edit :");
                            try {
                             strId=sc.next();
                                 editValueId=Integer.parseInt(strId);
                             editId=true;
                            }catch (Exception e){
                                System.out.println("ERROR!! You Can Only Be Integer!!");
                            }
                        }while (!editId);
                        boolean cheched=false;
                        for (int i=0;i< list.size();i++){
                            if(editValueId==list.get(i).getId()){
                                System.out.println("Student ID :"+list.get(i).getId());
                                student.setId(list.get(i).getId());
                                student.updateStudent(sc);
                                list.set(i,student);
                                System.out.println("SUCCESSFULLY UPDATE THE STUDENT!!!");
                                cheched=true;
                            }
                        }
                        if(cheched==false){
                            System.out.println("Student with id of "+editValueId+" dons't exit! Try different one!");
                        }
                        student.pressKey();
                    }break;
                    //Search Student Information
                    case 3:{
                     int s_op=0;
                     if (list.size()>0) {
                         do {
                             Student student = new Student();
                             System.out.println("===========Search Student Information===========");
                             System.out.println("1. Search By Id.");
                             System.out.println("2. Search By Name.");
                             System.out.println("3. Search By Gender.");
                             System.out.println("4. Search By Class Room.");
                             System.out.println("5. Exit");
                             System.out.println("------------------------------");
                             boolean valueSearch = false;
                             String strSearch;
                             do {
                                 System.out.print("Please Choose Option (1-5) :");
                                 try {
                                     strSearch = sc.next();
                                     s_op = Integer.parseInt(strSearch);
                                     valueSearch = true;
                                 } catch (Exception e) {
                                     System.out.println("Error!! Invalid Input...! Try Again.");
                                 }
                                 switch (s_op) {
                                     case 1: {
                                         System.out.println("=======Search By Id=======");
                                         int s_id = 0;
                                         boolean valueID = false;
                                         String sValueId;
                                         boolean s_ValID = false;
                                         do {
                                             System.out.println("Enter ID For Search :");
                                             try {
                                                 sValueId = sc.next();
                                                 s_id = Integer.parseInt(sValueId);
                                                 s_ValID = true;
                                             } catch (Exception e) {
                                                 System.out.println("ERROR!! Id Can Not Be String..!");
                                             }
                                         } while (!s_ValID);
                                         int num = 0;
                                         for (int i = 0; i < list.size(); i++) {
                                             if (s_id == list.get(i).getId()) {
                                                 System.out.println("========Student Information :" + (num + 1) + "========");
                                                 list.get(i).outputStudent();
                                                 valueID = true;
                                                 num++;
                                             }
                                         }
                                         if (valueID == false) {
                                             System.out.println("Not Found Student Information!!");
                                         }
                                         student.pressKey();
                                     }
                                     break;
                                     case 2: {
                                         System.out.println("=====Search By Name======");
                                         String s_name;
                                         boolean valueName = false;
                                         System.out.println("Enter Name For Search :");
                                         s_name = sc.next();
                                         int num = 0;
                                         for (int i = 0; i < list.size(); i++) {
                                             if (s_name.equalsIgnoreCase(list.get(i).getName())) {
                                                 System.out.println("========Student Information :" + (num + 1) + "========");
                                                 list.get(i).outputStudent();
                                                 valueName = true;
                                                 num++;
                                             }
                                         }
                                         if (valueName == false) {
                                             System.out.println("Not Found Student Information!!");
                                         }
                                         student.pressKey();
                                     }
                                     break;
                                     case 3: {
                                         System.out.println("=====Search By Gender======");
                                         String s_gender;
                                         boolean valueGender = false;
                                         System.out.println("Enter Gender For Search :");
                                         s_gender = sc.next();
                                         int num = 0;
                                         for (int i = 0; i < list.size(); i++) {
                                             if (s_gender.equalsIgnoreCase(list.get(i).getGender())) {
                                                 System.out.println("========Student Information :" + (num + 1) + "========");
                                                 list.get(i).outputStudent();
                                                 valueGender = true;
                                                 num++;
                                             }
                                         }
                                         if (valueGender == false) {
                                             System.out.println("Not Found Student Information!!");
                                         }
                                         student.pressKey();
                                     }
                                     break;
                                     case 4: {
                                         System.out.println("=====Search By ClassRoom======");
                                         String s_class;
                                         boolean valueClass = false;
                                         System.out.println("Enter ClassRoom For Search :");
                                         s_class = sc.next();
                                         int num = 0;
                                         for (int i = 0; i < list.size(); i++) {
                                             if (s_class.equalsIgnoreCase(list.get(i).getClassroom())) {
                                                 System.out.println("========Student Information :" + (num + 1) + "========");
                                                 list.get(i).outputStudent();
                                                 valueClass = true;
                                                 num++;
                                             }
                                         }
                                         if (valueClass == false) {
                                             System.out.println("Not Found Student Information!!");
                                         }
                                         student.pressKey();
                                     }
                                     break;
                                     case 5:{

                                     }break;
                                     default: {
                                         System.out.println("Wrong Option!! Choose Again From 1-5 !!");
                                         student.pressKey();
                                     }
                                     break;
                                 }
                             } while (!valueSearch);
                         } while (s_op!=5);
                     }else {
                         Student student = new Student();
                         System.out.println("Don't have Student For Search!!");
                         student.pressKey();
                     }
                    }break;
                    //Delete Student Information
                    case 4:{
                        Student student=new Student();
                        System.out.println("========Delete Student Information=======");
                        int d_id=0;
                        boolean valueDelete=false;
                        boolean checked=false;
                        String strId;
                        do {
                            System.out.println("Enter Student ID to Delete :");
                            try {
                                strId=sc.next();
                                d_id=Integer.parseInt(strId);
                                checked=true;
                            }catch (Exception e){
                                System.out.println("ERROR!! ID Can Not To String!!");
                            }
                        }while (!checked);
                        for (int i=0;i<list.size();i++){
                            if(d_id==list.get(i).getId()){
                                list.remove(i);
                                System.out.println("Student with the Id of "+d_id+" has been removed successfully!!");
                                valueDelete=true;
                            }
                        }
                        if(valueDelete==false){
                            System.out.println("Student with the ID of "+d_id+" not found to delete!");
                        }
                        student.pressKey();
                    }break;
                    //Show Student Information
                    case 5:{
                        System.out.println("=========Show Student Information=========");
                        Student student = new Student();
                        for(int i=0;i< list.size();i++){
                            list.get(i).outputStudent();
                        }
                        student.pressKey();
                    }break;
                    //Exit
                    case 6:{

                    }break;
                    //Wrong Option
                    default:{
                        System.out.println("Wrong Option!! Choose Again From 1-6 !!");
                        Student student = new Student();
                        student.pressKey();
                    }break;
                }
        }while(op!=6);
    }
}
