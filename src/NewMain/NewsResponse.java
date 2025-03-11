package NewMain;
import java.util.ArrayList;
import java.util.List;

public class NewsResponse {
    private List<NewsItems> items = new ArrayList<>();

    public List<NewsItems> getItems(){
        return items;
    }
    public void addItem(NewsItems item){
        this.items.add(item);
    }
}
