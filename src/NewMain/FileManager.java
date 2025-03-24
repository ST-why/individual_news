package NewMain;

import java.nio.file.StandardOpenOption;
import java.nio.file.*;
import java.io.IOException; // 파일 입출력에서 발생할 수 있는 예외를 처리할 때 사용

public class FileManager {
    public static void writeToFile (String data, String filename) {

        try{
            Files.write(Paths.get(filename), data.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING); // 파일에 데이터를 쓰는 메서드 첫 번째 인자는 파일경로, 두번째 인자는 데이터 바이트 배열 제공
            System.out.println("뉴스 데이터를 파일에 저장 했습니다: " + filename);
        } catch (IOException e){
            System.err.println(" 파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    public static  String readFromFile (String filename){
        try{
            return new String (Files.readAllBytes(Paths.get(filename)));
        } catch (IOException e){
            System.err.println(" 파일 읽기 중 오류 발생: " + e.getMessage() ) ;
            return null;
        }
    } // 파일에서 데이터를 읽어오는 메서드, Files.write()와 Files.readAllBytes()는 NIO API에서 제공하는 파일 입출력 방법
}
