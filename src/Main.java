public class Main {
    public static void main(String[] args) throws Exception {
        FileUtility.writeIntoFile("D://Test/test.txt","Hello World");
        FileUtility.appendIntoFile("D://Test/test.txt","\nHow are you?");
        FileUtility.appendIntoFile("D://Test/test.txt","\nI'm fine,thank you very much");
        //png tipli java photosunun bytlar ile oxuyub yeniden qurdu
        byte[] photo = FileUtility.readBytes("D://Test/java.png");
        FileUtility.writeIntoFileWithBytes("D://Test/java2.png",photo);
    }
}