import java.io.*;

public class FileUtility {
    private static void writeIntoFile(String fileName, String text, boolean append) throws IOException {
        //try with resources tetbiqi.
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, append))) {
            bw.write(text);
        }
    }

    public static void writeIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, false);
    }

    public static void appendIntoFile(String fileName, String text) throws Exception {
        writeIntoFile(fileName, text, true);
    }

    public static void writeIntoFileWithBytes(String fileName, byte[] data) throws Exception {
        FileOutputStream fop = new FileOutputStream(fileName);
        fop.write(data);
        fop.flush();
        fop.close();
    }

    //Stringi oxuyub capa verir
    public static String read(String fileName) throws Exception {
        try (InputStream in = new FileInputStream(fileName);
             InputStreamReader r = new InputStreamReader(in);
             BufferedReader reader = new BufferedReader(r)) {
            String line;
            String result = "";
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            return result;
        }
    }

    public static byte[] readBytes(String fileName) throws Exception {
        File file = new File(fileName);
        byte[] bytesArray = new byte[(int) file.length()];

        FileInputStream fileInputStream = new FileInputStream(file);
        fileInputStream.read(bytesArray);
        return bytesArray;
    }
    public static void writeObjectToFile(Serializable object,String name) throws Exception{
       try( FileOutputStream fout = new FileOutputStream(name);
        ObjectOutputStream oos = new ObjectOutputStream(fout)){
           oos.writeObject(object);
       }
    }
    public static Object readFileDeserialize(String name) throws Exception{
        Object obj = null;
        FileInputStream fi= new FileInputStream(name);
        try(ObjectInputStream in = new ObjectInputStream(fi)){
            obj=in.readObject();
        }finally {
            return obj;
        }
    }

}
