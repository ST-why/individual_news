package NewMain;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class NewsParser {
   public static NewsResponse parseJson(String json){
       Gson gson = new Gson();
       JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject(); // Json 문자열 데이터들을 Json 객체로 형태를 바꾼 것, 타입은 JsonObject 타입이다
       JsonArray itemsArray = jsonObject.getAsJsonArray("items"); // JsonArray 형태로 items라는 키를 배열 JsonArray 형태로 가져온 것
       NewsResponse newsResponse = new NewsResponse();

       for(int i = 0; i < itemsArray.size(); i++){
           NewsItems news = gson.fromJson(itemsArray.get(i), NewsItems.class); // itemsArray를 하나씩 자바 객체로 변환
           newsResponse.addItem(news);
       }
       return newsResponse;
   }

}
