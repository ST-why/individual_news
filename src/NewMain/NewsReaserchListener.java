package NewMain;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class NewsReaserchListener implements ActionListener {
    private DefaultListModel<String> newsListModel;

    public NewsReaserchListener(DefaultListModel<String> newsListModel) {
        this.newsListModel = newsListModel;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String query = JOptionPane.showInputDialog("검색어를 입력하세요:");
        if (query != null && !query.trim().isEmpty()) {
            try {
                String filename = NewsApi.fetchAndSaveNews(query);
                String fileData = FileManager.readFromFile(filename);

                if (fileData != null) {
                    NewsResponse newsResponse = NewsParser.parseJson(fileData);
                    newsListModel.clear();

                    for (NewsItems news : newsResponse.getItems()) {
                        newsListModel.addElement(news.getTitle().replaceAll("</?b>", ""));
                        newsListModel.addElement(news.getDescription().replaceAll("</?b>", ""));
                    }
                    JOptionPane.showMessageDialog(null, "검색된 뉴스가 목록에 추가되었습니다.");
                } else {
                    JOptionPane.showMessageDialog(null, "뉴스 검색에 실패했습니다.");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "오류 발생: " + ex.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "검색어를 입력하세요.");
        }
    }
    }