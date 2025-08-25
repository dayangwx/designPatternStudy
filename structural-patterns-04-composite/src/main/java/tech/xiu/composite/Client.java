package tech.xiu.composite;

public class Client {
    public static void main(String[] args) {
        // 创建文件
        FileSystemNode file1 = new File("report.doc", 120);
        FileSystemNode file2 = new File("image.jpg", 540);
        FileSystemNode file3 = new File("archive.zip", 1200);

        // 创建文件夹
        Folder root = new Folder("My Documents");
        Folder musicFolder = new Folder("Music");
        Folder pictureFolder = new Folder("Pictures");

        // 构建树形结构
        musicFolder.add(new File("song1.mp3", 3000));
        musicFolder.add(new File("song2.wav", 8000));

        pictureFolder.add(file2);

        root.add(file1);
        root.add(musicFolder);
        root.add(pictureFolder);
        root.add(file3);

        // --- 客户端统一操作 ---
        System.out.println("--- Printing file system structure ---");
        root.print(""); // 统一调用print方法，无需判断类型

        System.out.println("\n--- Calculating sizes ---");
        // 统一调用getSize方法，无需判断类型
        System.out.println("Size of 'Pictures' folder: " + pictureFolder.getSize() + "KB");
        System.out.println("Total size of root folder: " + root.getSize() + "KB");
    }
}
