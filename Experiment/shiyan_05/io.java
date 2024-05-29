
package Experiment.shiyan_05;

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
            String dir;
            System.out.println("--------------------------");
            System.out.println("1. 创建文件");
            System.out.println("2. 写文件");
            System.out.println("3. 读文件");
            System.out.println("4. 复制文件");
            System.out.println("5. 获取文件路径");
            System.out.println("6. 随机读文件");
            System.out.println("7. 随机写文件");
            System.out.println("8. 创建目录");
            System.out.println("9. 目录中增加文件");
            System.out.println("10. 列出目录中所有文件");
            System.out.println("11. 删除目录");
            System.out.println("0. 退出");
            System.out.println("--------------------------");
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
                    case 8:
                        //创建目录
                        System.out.print("请输入创建目录的名称：");
                        fileManager=new FileManager();
                        dir = sc.nextLine();
                        if (fileManager.createDirectory(dir)) {
                            System.out.println(dir+"目录创建成功: "  );
                        }
                        break;
                    case 9:
                        fileManager =new FileManager();
                        //在目录中增加文件
                        System.out.print("请输入添加文件的目录：");
                        dir=sc.nextLine();
                        System.out.println("1.在目录中创建文件");
                        System.out.println("2.在目录中添加已有文件");
                        System.out.print("选择：");
                        int ch = sc.nextInt();
                        if (ch==1){
                            System.out.print("请输入创建文件的名称：");
                            filename=sc.nextLine();
                            sc.nextLine(); // 消耗换行符
                            fileManager.createFile(dir,filename);
                            System.out.println("创建文件成功文件成功！");
                        }else if (ch==2){
                            sc.nextLine(); // 消耗换行符
                            System.out.print("请输入文件源路径：");
                            String sourceFilePath=sc.nextLine();
                            fileManager.moveFileToDirectory(sourceFilePath,dir);
                            System.out.println("创建文件成功文件成功！");
                        }
                        break;
                    case 10:
                        //列出目录中所有的文件
                        fileManager =new FileManager();
                        System.out.print("请输入目录：");
                        dir=sc.nextLine();
                        String[] files = fileManager.listFiles(dir);
                        if (files != null) {
                            System.out.println("目录中的文件列表:");
                            for (String file : files) {
                                System.out.println( file);
                            }
                        } else {
                            System.out.println("无法列出文件，因为目录不存在或不是目录: " + dir);
                        }
                        break;
                    case 11:
                        //删除目录
                        fileManager =new FileManager();
                        System.out.print("请输入要删除的目录：");
                        dir=sc.nextLine();
                        if (fileManager.deleteDirectory(dir)) {
                            System.out.println(dir+"目录删除成功!"  );
                        } else {
                            System.out.println(dir+"无法删除目录"  );
                        }
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