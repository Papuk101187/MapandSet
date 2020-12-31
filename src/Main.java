import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main(String[] args) {

        ParseText parseText = new ParseText("Привет мир, привет жестокий мир и прощай,мир привет");
        MyMaps myMaps = parseText.getmyMaps();

        MySet<MyMaps.Pair<String, Integer>> pairs = myMaps.pairSet();

      for (MyMaps.Pair<String, Integer> pair : pairs) {
           System.out.println("getKey() - " + pair.getKey() + "  getValue() = " + pair.getValue());
        }

    }

}























