package NewMain;
import javax.swing.*;
import java.awt.*;

public class NewsSwingApp extends JFrame{
     private static DefaultListModel<String> newsListModel;
     private static JList<String> newsList;
     private static JTextArea newsDetailArea;

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("뉴스 요약 앱");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 500);

        // ✅ 메뉴 바 추가
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("메뉴");

        JMenuItem menuSearch = new JMenuItem("검색하기");
        JMenuItem menuWatch = new JMenuItem("저장된 뉴스 보기");
        JMenuItem menuExit = new JMenuItem("종료");

        // ✅ 이벤트 리스너 추가
        menuSearch.addActionListener(new NewsReaserchListener(newsListModel));  // ✅ 뉴스 검색
        menuWatch.addActionListener(new NewsListListener(newsList, newsDetailArea));  // ✅ 저장된 뉴스 보기
        menuExit.addActionListener(e -> System.exit(0));  // ✅ 종료

        // ✅ 메뉴 구성
        menuBar.add(menuSearch);
        menuBar.add(menuWatch);
        menuBar.add(menuExit);
        frame.setJMenuBar(menuBar);

        // ✅ 뉴스 리스트 모델 & JList 초기화
        newsListModel = new DefaultListModel<String>();
        newsList = new JList<>(newsListModel);
        JScrollPane listScrollPane = new JScrollPane(newsList);

        // ✅ 뉴스 세부 내용을 보여줄 JTextArea
        newsDetailArea = new JTextArea();
        newsDetailArea.setEditable(false);
        JScrollPane detailScrollPane = new JScrollPane(newsDetailArea);

        // ✅ 뉴스 리스트와 뉴스 상세 내용을 수직 분할
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, listScrollPane, detailScrollPane);
        splitPane.setDividerLocation(150); // 초기 분할 위치 설정

        // ✅ 프레임에 추가
        frame.add(splitPane, BorderLayout.CENTER);

        frame.setVisible(true);


    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NewsSwingApp::createAndShowGUI);
    }
}