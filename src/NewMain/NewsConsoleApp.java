package NewMain;
import java.util.Scanner;

public class NewsConsoleApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println(" ===== 뉴스 콘솔 프로그램 ===== ");
            System.out.println("1. 뉴스 검색");
            System.out.println("2. 저장된 뉴스 보기");
            System.out.println("3. 종료");
            System.out.print("선택: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch(choice){
                case 1 :
                    System.out.print(" 검색어를 입력하세요: ");
                    String query = scanner.nextLine();
                    String filename = NewsApi.fetchAndSaveNews(query);
                    String fileData = FileManager.readFromFile(filename);

                    if(fileData != null) {
                        NewsResponse newsResponse = NewsParser.parseJson(fileData);

                        for (NewsItems news : newsResponse.getItems()){
                            String cleandTitle = news.getTitle().replaceAll("</?b>","");
                            String cleandDescription = news.getDescription().replaceAll("</?b>","");
                            System.out.println("제목: " +  cleandTitle);
                            System.out.println("내용: " + cleandDescription);
                            System.out.println("====================================");

                        }
                    }
                    else {
                        System.out.println("파일을 읽는 데 실패했습니다.");
                    }
                    break;

                case 2:
                    String saveData = FileManager.readFromFile("news_data.json");
                    if(saveData == null){
                        System.out.println("저장된 뉴스가 없습니다!");
                        break;
                    }
                    else {
                        NewsResponse savedResponse = NewsParser.parseJson(saveData);
                        for (NewsItems news : savedResponse.getItems()) {
                            String cleandTitle = news.getTitle().replaceAll("</?b>","");
                            String cleandDescription = news.getDescription().replaceAll("</?b>","");
                            System.out.println("제목: " + cleandTitle);
                            System.out.println("내용: " + cleandDescription);
                            System.out.println("====================================");
                        }
                    }
                     break;
                case 3:
                    System.out.println("프로그램을 종료합니다.");
                    return;

                default:
                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
            }
        }
    }
}
