package inter2;

import java.util.Random;

/**
 * Copyright (C), 2019-2021, CPS Lab
 *
 * @ProjectName: leetcode_project
 * @Package: interview
 * @ClassName: Solution5
 * @Author: Tristan Shu
 * @CreateDate: 2021/2/23 下午3:34
 * @Version: 1.0
 * 模拟一个分布式系统处理请求的场景。
 * 有一个分布式系统包含了A，B，C三个应用，每个应用包含多台机器，调用关系是:请求->A->B->C。所有请求都是同步处理，每台机器同时只能处理一个请求，且每台机器处理的耗时不一致。
 * 写一段代码，利用单机多线程模拟上述场景。假设A、B、C分别有3、4、5台机器（编号为A1、A2、A3、B1等等），每台机器的处理耗时为0~5ms（可以采用随机数+sleep处理），耗时发生在调用下游之前，选取下游采用随机的方式，选择空闲的机器即可。总共处理100个请求，每个请求有一个ID（1到100），每台机器在调用下游时需要将ID传递给下游，并且在处理完毕后输出ID和本机编号。
 * 例如，第一个请求有可能的输出结果如下：
 * ID1 C2 1ms
 * ID1 B1 3ms
 * ID1 A1 8ms
 */
public class Solution5 {
    public static void main(String[] args) {
        int machineNumOfA = 3;
        int machineNumOfB = 4;
        int machineNumOfC = 5;
        Application applicationA = new Application(machineNumOfA, "A");
        Application applicationB = new Application(machineNumOfB, "B");
        Application applicationC = new Application(machineNumOfC, "C");
        int idNum = 100;
        for (int i = 0; i < idNum; i++) {
            applicationA.startMission(i + 1);
            applicationB.startMission(i + 1);
            applicationC.startMission(i + 1);
        }
    }
}

class Application {
    int machineNum;
    Machine[] machines = new Machine[machineNum];
    Thread[] threads = new Thread[machineNum];

    Application(int machineNum, String applicationName) {
        this.machineNum = machineNum;
        for (int i = 1; i <= machineNum; i++) {
            machines[i] = new Machine(applicationName + String.valueOf(i));
            threads[i] = new Thread(machines[i]);
        }
    }

    synchronized public void startMission(int id) {
        boolean flag = false;
        while (!flag) {
            for (int i = 0; i < machineNum; i++) {
                if (threads[i].isAlive()) {
                    continue;
                } else {
                    machines[i].setTaskId(id);
                    threads[i].start();
                    flag = !flag;
                }
            }
        }
    }
}

class Machine implements Runnable {
    Random random = new Random();
    String machineName;
    private int taskId;

    public Machine(String machineName) {
        this.machineName = machineName;
    }

    public void handleMessage(int taskId, String machineName) {
        try {
            int sleepTime = random.nextInt(5);
            Thread.sleep(sleepTime);
            System.out.println("ID" + taskId + " " + machineName + sleepTime + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Override
    public void run() {
        handleMessage(taskId, machineName);
    }
}
