import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class NioFileUtil {
    public static void writeBytes(byte[]data,String fileName) throws Exception{
        Path filePath = Paths.get(fileName);
        Files.write(filePath,data);
    }
    public static byte[] readBytes(String fileName)throws Exception{
        Path filePath=Paths.get(fileName);
        byte[] bytesArray = Files.readAllBytes(filePath);
        return bytesArray;
    }
}
