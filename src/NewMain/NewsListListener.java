package NewMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewsListListener implements ActionListener {
    private static JList<String> newsList;
    private static JTextArea newsDetailArea;  // 뉴스 내용을 표시할 JTextArea 추가

    public NewsListListener(JList<String> newsList, JTextArea newsDetailArea) {
        this.newsList = newsList;
        this.newsDetailArea = newsDetailArea;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (newsList == null || newsList.isSelectionEmpty()) {
            JOptionPane.showMessageDialog(null, "뉴스를 선택해주세요.");
            return;
        }
        String selectedTitle = newsList.getSelectedValue(); // 선택된 뉴스 제목 가져오기

        if (selectedTitle != null) {
            // 2. 선택된 뉴스 제목에 해당하는 뉴스 내용 가져오기
            // 예시로는 임시로 NewsApi.fetchAndSaveNews를 통해 데이터 가져오는 것을 가정
            // 실제로는 NewsResponse에서 해당 뉴스 항목을 찾아야 함
            String newsContent = getNewsContentForTitle(selectedTitle); // 뉴스 내용을 얻는 메서드

            // 3. JTextArea에 선택된 뉴스 내용 표시
            newsDetailArea.setText(newsContent);
        }
    }

    // 뉴스 제목에 해당하는 내용 반환 (실제로는 데이터베이스나 JSON에서 데이터를 조회해야 함)
    private String getNewsContentForTitle(String title) {
        // 여기서는 임시로 title에 해당하는 더미 데이터를 반환합니다.
        // 실제 구현에서는 `title`에 해당하는 뉴스 항목을 찾아 해당하는 `description` 또는 내용을 반환해야 합니다.
        return "선택한 뉴스 제목: " + title + "\n\n" + "여기에 뉴스 내용이 표시됩니다.";
    }
}
