package tests;

import java.io.*;

import static tests.Utils.readObject;
import static tests.Utils.writeObject;

public class ExampleLab6 {
    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("user.dir"));

//        testFiles();
        testDirectories();
//        serializingDemo();
//        deserializingDemo();
//        easySerializingDemo();
//        easyDeserializingDemo();

    }

    public static void testFiles() throws IOException {
        File f = new File("testfiles/dummy.txt");
        // The above path is a relative path where we are referring to the file dummy.txt in our Java program’s CWD.

        // check if the file “dummy.txt” already exists or not with the `exists()` method of the File class
        if (!f.exists()) {
            f.createNewFile();  // actually create this dummy.txt file
        }

        // to write a String to a file, you can do the following:
        Utils.writeContents(f, "Hello World");
    }

    public static void testDirectories() {
        // you can make a File object that represents a directory:
        File d = new File("testfiles/dummy1/dummy2");

        // Similar to files, this directory might not actually exist in your file system.
        // To actually create the folder in your file system, you can run:
        boolean flag = d.mkdir();  // and now there should be a folder called dummy in your CWD.
        System.out.println(flag);

        File dd = new File("testfiles/dummy11/dummy22");
        System.out.println(dd.mkdirs());
    }

    public static void serializingDemo() {
        Model m = new Model(114514);
        File outFile = new File("testfiles/out.txt");

        try {
            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(outFile));
            out.writeObject(m);
            out.close();
        } catch (IOException excp) {
            System.out.println("...");
        }
    }

    public static void deserializingDemo() {
        Model m;
        File inFile = new File("testfiles/out.txt");

        try {
            ObjectInputStream inp =
                    new ObjectInputStream(new FileInputStream(inFile));
            m = (Model) inp.readObject();
            inp.close();
        } catch (IOException | ClassNotFoundException excp) {
            System.out.println("...");
            m = null;
        }

        assert m != null;
        System.out.println(m.val());
    }

    public static void easySerializingDemo() {
        Model m = new Model(1919810);
        File outFile = new File("testfiles/easy.out");
        writeObject(outFile, m);
    }

    public static void easyDeserializingDemo() {
        Model m;
        File inFile = new File("testfiles/easy.out");
        m = readObject(inFile, Model.class);

        System.out.println(Model.class);
        System.out.println(m.val());
    }
}
