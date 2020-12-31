import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseText {

    MyMaps myMaps = new MyMaps();

    public ParseText(String s) {


        Pattern pattern = Pattern.compile("([A-Za-я]+)");
        Matcher matcher = pattern.matcher(s);
        int coun = 1;


        while (matcher.find()) {

            String string = matcher.group().toLowerCase();

            if (myMaps.contains(string)) {
                Integer integer = (Integer) myMaps.get(string);
                int index = integer + 1;
                myMaps.put(string, index);
            } else {
                myMaps.put(string, coun);
            }


        }


    }


    public MyMaps getmyMaps() {
        return myMaps;
    }

}
