//package interview;
//
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Copyright (C), 2019-2021, CPS Lab
// *
// * @ProjectName: leetcode_project
// * @Package: PACKAGE_NAME
// * @ClassName: interview.Solution3
// * @Author: Tristan Shu
// * @CreateDate: 2021/2/8 上午11:03
// * @Version: 1.0
// */
//public class Solution3 {
//    class Person {
//        int bigRoom;
//        int smallRoom;
//        int rentCeiling;
//        String name;
//        String phoneNum;
//
//        Person(String name, int bigRoom, int smallRoom, int rentCeiling) {
//            this.bigRoom = bigRoom;
//            this.smallRoom = smallRoom;
//            this.rentCeiling = rentCeiling;
//            this.name = name;
//            this.phoneNum = phoneNum;
//        }
//
//        private void putPhoneNum(String num) {
//            this.phoneNum = num;
//        }
//    }
//
//    class House {
//        int bigRoom;
//        int smallRoom;
//        int rent;
//
//        House(int bigRoom, int smallRoom, int rent) {
//            this.bigRoom = bigRoom;
//            this.smallRoom = smallRoom;
//            this.rent = rent;
//        }
//    }
//
//    public static void main(String[] args) {
//        List<Person> personList = new LinkedList<>();
//        String phoneNum1 = "";
//        String phoneNum2 = "";
//        Person person1 = new Person("小明", 2, 3, 6000);
//        Person person2 = new Person("小李", -1, -1, 1500);
//        person1.putPhoneNum(phoneNum1);
//        person2.putPhoneNum(phoneNum2);
//        personList.add(person1);
//        personList.add(person2);
//        Scanner scanner = new Scanner(System.in);
//        int bigRoom = scanner.nextInt();
//        int smallRoom = scanner.nextInt();
//        int rent = scanner.nextInt();
//        House house = new House(bigRoom, smallRoom, rent);
//        for(Person person : personList){
//            if((person.bigRoom == house.bigRoom || person.bigRoom == -1) && (person.smallRoom == house.smallRoom || person.smallRoom == -1)){
//                if(person.rentCeiling >= house.rent){
//                    notify(person);
//                }
//            }
//        }
//    }
//    private static void notify(Person person){
//        System.out.println("Notify" + person.name);
//    }
//}
