
package shiyan.shiyan_05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class FileManager {
    private File file;
    public FileManager(){}
    public FileManager(String filePath) {
        this.file = new File(filePath);
    }

    // 创建文件
    public boolean createFile() throws IOException {
        return file.createNewFile();
    }

    // 写入文件
    public void writeFile(String data) throws IOException {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(data);
        }
    }

    // 读取文件
    public String readFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (FileReader reader = new FileReader(file)) {
            int character;
            while ((character = reader.read()) != -1) {
                content.append((char) character);
            }
        }
        return content.toString();
    }

    // 复制文件
    public void copyFile(String destPath) throws IOException {
        File destFile = new File(destPath);
        try (FileInputStream in = new FileInputStream(file);
             FileOutputStream out = new FileOutputStream(destFile)) {
            int byteData;
            while ((byteData = in.read()) != -1) {
                out.write(byteData);
            }
        }
    }

    // 随机写文件
//    public void randomWriteFile(long position, String data) throws IOException {
//        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
//            raf.seek(position);
//            raf.writeBytes(data);
//        }
//    }

    //    // 随机写文件
//    public void randomWriteFile(long position, String data) throws IOException {
//        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
//            raf.seek(position);
//            raf.write(data.getBytes());
//        }
//    }
// 随机写文件
    public void randomWriteFile(long position, String data) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
           raf.seek(position);
           raf.write(data.getBytes(StandardCharsets.UTF_8)); // 使用 UTF-8 编码
        }
    }

//    // 随机写文件
//    public void randomWriteFile(long position, String data) throws IOException {
//        try (RandomAccessFile raf = new RandomAccessFile(file, "rw")) {
//            raf.seek(position);
//            raf.write(data.getBytes(StandardCharsets.UTF_8));
//        }
//    }

//    // 随机读取文件
//    public String randomReadFile(long position, int size) throws IOException {
//        byte[] buffer = new byte[size];
//        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
//            raf.seek(position);
//            raf.readFully(buffer);
//        }
//        return new String(buffer);
//    }
        // 随机读取文件
        public String randomReadFile(String filename,long position, int size) throws IOException {
            RandomAccessFile rf = new RandomAccessFile(filename,"r");
            rf.seek(position);
            return rf.readLine();
        }

//    // 随机读取文件
//    public String randomReadFile(long position, int size) throws IOException {
//        StringBuilder content = new StringBuilder();
//        try (RandomAccessFile raf = new RandomAccessFile(file, "r")) {
//            raf.seek(position);
//            byte[] buffer = new byte[size];
//            int bytesRead = raf.read(buffer);
//            if (bytesRead != -1) {
//                content.append(new String(buffer, 0, bytesRead, StandardCharsets.UTF_8));
//            }
//        }
//        return content.toString();
//    }

    // 获取文件路径
    public String getFilePath() {
        return file.getAbsolutePath();
    }


    //目录
    // 创建目录的方法
    public boolean createDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (dir.exists()) {
            System.out.println("目录已存在: " + dirPath);
            return false;
        }
        return dir.mkdir();
    }

    // 删除目录的方法
    public boolean deleteDirectory(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("目录不存在或不是目录: " + dirPath);
            return false;
        }
        return deleteDirectoryRecursively(dir);
    }
    // 递归删除目录内容的辅助方法
    private boolean deleteDirectoryRecursively(File dir) {
        File[] allContents = dir.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                if (!deleteDirectoryRecursively(file)) {
                    return false;
                }
            }
        }
        return dir.delete();
    }

    // 在目录中创建文件的方法
    public boolean createFile(String dirPath, String fileName) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("目录不存在或不是目录: " + dirPath);
            return false;
        }
        File file = new File(dir, fileName);
        try {
            return file.createNewFile();
        } catch (IOException e) {
            System.out.println("创建文件时出错: " + e.getMessage());
            return false;
        }
    }

    // 移动文件到目录的方法
    public boolean moveFileToDirectory(String sourceFilePath, String destDirPath) {
        File sourceFile = new File(sourceFilePath);
        File destDir = new File(destDirPath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.out.println( sourceFilePath+"不存在或不是文件: " );
            return false;
        }

        if (!destDir.exists() || !destDir.isDirectory()) {
            System.out.println(destDirPath+"目录不存在或不是目录: "  );
            return false;
        }

        File destFile = new File(destDir, sourceFile.getName());
        try {
            Files.move(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            return true;
        } catch (IOException e) {
            System.out.println("移动文件时出错: " + e.getMessage());
            return false;
        }
    }

    // 列出目录中文件的方法
    public String[] listFiles(String dirPath) {
        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("目录不存在或不是目录: " + dirPath);
            return null;
        }
        return dir.list();
    }
}