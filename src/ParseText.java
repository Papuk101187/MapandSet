import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseText {

    MyMaps myMaps = new MyMaps();
    int count = 1;
    int countnew = 0;

    public ParseText(String s) {


        Pattern pattern = Pattern.compile("([A-Za-я]+)");
        Matcher matcher = pattern.matcher(s);

        while (matcher.find()) {

            if (myMaps.put(matcher.group().toLowerCase(), count)) {
                countnew = count + 1;
                myMaps.put(matcher.group().toLowerCase(), countnew);
            }


        }


    }


    public MyMaps getmyMaps() {
        return myMaps;
    }

}
