
package shiyan.shiyan_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class io {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            FileManager fileManager = null;
            String filename;
            System.out.println("--------------------");
            System.out.println("1. 创建文件");
            System.out.println("2. 写文件");
            System.out.println("3. 读文件");
            System.out.println("4. 复制文件");
            System.out.println("5. 获取文件路径");
            System.out.println("6. 随机读文件");
            System.out.println("7. 随机写文件");
            System.out.println("0. 退出");
            while(true){
                System.out.print("请输入你选择的操作：");
                int choice = sc.nextInt();
                sc.nextLine(); // 读取换行符

                switch (choice) {
                    case 0:
                        System.out.println("退出程序。");
                        return;
                    case 1:
                        // 创建文件
                        System.out.print("请输入文件名：");
                        filename = sc.nextLine();
                        fileManager = new FileManager(filename);
                        if (fileManager.createFile()) {
                            System.out.println("创建文件 " + fileManager.getFilePath() + " 成功！");
                        } else {
                            System.out.println("文件已经存在");
                        }
                        break;
                    case 2:
                        // 写入文件
                        System.out.print("请输入文件名：");
                        filename = sc.nextLine();
                        fileManager = new FileManager(filename);
                        InputStreamReader isr = new InputStreamReader(System.in);
                        BufferedReader br = new BufferedReader(isr);
                        StringBuilder contentToWrite = new StringBuilder();
                        String str;
                        System.out.println("请输入写入文件的内容（输入0结束）：");
                        while (true){
                            str = br.readLine();
                            if (str.equals("0"))
                                break;
                            contentToWrite.append(str).append(System.lineSeparator());
                        }
                        fileManager.writeFile(contentToWrite.toString());
                        System.out.println("写入文件成功！");
                        break;
                    case 3:
                        // 读取文件
                        System.out.print("请输入文件名：");
                        filename = sc.nextLine();
                        fileManager = new FileManager(filename);
                        String content = fileManager.readFile();
                        System.out.println("文件内容: \n" + content);
                        break;
                    case 4:
                        // 复制文件
                        System.out.print("请输入源文件名：");
                        filename = sc.nextLine();
                        fileManager = new FileManager(filename);
                        System.out.print("请输入目标文件名：");
                        String destFilename = sc.nextLine();
                        fileManager.copyFile(destFilename);
                        System.out.println("复制文件成功！");
                        break;
                    case 5:
                        //获取文件路径
                        System.out.print("请输入文件名：");
                        filename = sc.nextLine();
                        fileManager = new FileManager(filename);
                        System.out.println("文件路径为："+fileManager.getFilePath());
                        break;
                    case 6:
                        //随机读文件
                        System.out.print("请输入文件名：");
                        filename = sc.nextLine();
                        fileManager = new FileManager(filename);
                        System.out.print("请输入读取文件的位置：");
                        long position=sc.nextLong();
                        sc.nextLine(); // 消耗换行符
                        System.out.print("请输入读取文件的大小：");
                        int size=sc.nextInt();
                        System.out.println(fileManager.randomReadFile(filename,position,size));
                        System.out.println("随机读取文件成功！");
                        break;
                    case 7:
                        //随机写文件
                        System.out.print("请输入文件名：");
                        filename = sc.nextLine();
                        fileManager = new FileManager(filename);
                        System.out.print("请输入写入的位置：");
                        long position1=sc.nextLong();
                        sc.nextLine(); // 消耗换行符
                        System.out.print("请输入写入的内容：");
                        String content1=sc.nextLine();
                        fileManager.randomWriteFile(position1,content1);
                        System.out.println("随机写入文件成功！");
                        content1 = fileManager.readFile();
                        System.out.println("文件内容: \n" + content1);
                        break;
                    default:
                        System.out.println("无效的选项，请重新选择。");
                }
                System.out.println("-----------------------------------------------------");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}