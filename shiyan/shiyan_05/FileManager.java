
package shiyan.shiyan_05;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

class FileManager {
    private File file;
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

    // 文件和目录管理
    public boolean createDirectory(String dirPath) {
        File dir = new File(dirPath);
        return dir.mkdir();
    }

    public boolean deleteFile() {
        return file.delete();
    }

    public boolean deleteDirectory(String dirPath) {
        File dir = new File(dirPath);
        return dir.delete();
    }

    public String[] listFiles(String dirPath) {
        File dir = new File(dirPath);
        return dir.list();
    }

    // 获取文件路径
    public String getFilePath() {
        return file.getAbsolutePath();
    }
}