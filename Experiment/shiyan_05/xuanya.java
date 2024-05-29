package Experiment.shiyan_05;

import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class xuanya {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("----------所具有的功能----------");
                System.out.println("1. 创建文件");
                System.out.println("2. 读取文件");
                System.out.println("3. 复制文件");
                System.out.println("4. 合并文件");
                System.out.println("0. 退出");
                System.out.print("请输入你选择的操作：");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 0:
                        System.out.println("退出程序。");
                        return;
                    case 1:
                        createFile();
                        break;
                    case 2:
                        readFile();
                        break;
                    case 3:
                        copyFile();
                        break;
                    case 4:
                        mergeFiles();
                        break;
                    default:
                        System.out.println("无效的选项，请重新选择。");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("发生I/O异常：" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("发生异常：" + e.getMessage());
        }
    }

    private static void createFile() throws IOException {
        System.out.println("请输入文件名：");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("文件创建成功！");
            System.out.println("文件地址：" + file.getAbsolutePath());
        } else {
            System.out.println("文件已存在。");
        }
    }

    private static void readFile() throws IOException {
        System.out.println("请输入文件名：");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println("文件不存在。");
            return;
        }

        FileReader reader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        System.out.println("文件内容：");
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }
        reader.close();
    }

    private static void copyFile() throws IOException {
        System.out.println("请输入源文件名：");
        Scanner scanner = new Scanner(System.in);
        String sourceFileName = scanner.nextLine();
        File sourceFile = new File(sourceFileName);

        if (!sourceFile.exists()) {
            System.out.println("源文件不存在。");
            return;
        }

        System.out.println("请输入目标文件名：");
        String targetFileName = scanner.nextLine();
        File targetFile = new File(targetFileName);

        Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        System.out.println("文件复制成功！");
    }

    private static void mergeFiles() throws IOException {
        System.out.println("请输入第一个文件名：");
        Scanner scanner = new Scanner(System.in);
        String firstFileName = scanner.nextLine();
        File firstFile = new File(firstFileName);

        if (!firstFile.exists()) {
            System.out.println("第一个文件不存在。");
            return;
        }

        System.out.println("请输入第二个文件名：");
        String secondFileName = scanner.nextLine();
        File secondFile = new File(secondFileName);

        if (!secondFile.exists()) {
            System.out.println("第二个文件不存在。");
            return;
        }

        System.out.println("请输入合并后的文件名：");
        String mergedFileName = scanner.nextLine();
        File mergedFile = new File(mergedFileName);

        FileInputStream fis1 = new FileInputStream(firstFile);
        FileInputStream fis2 = new FileInputStream(secondFile);
        FileOutputStream fos = new FileOutputStream(mergedFile);

        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fis1.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }
        while ((bytesRead = fis2.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fis1.close();
        fis2.close();
        fos.close();

        System.out.println("文件合并成功！");
    }
}
