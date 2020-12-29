public class ParseText {

    MyMaps myMaps = new MyMaps();
    int count = 1;
    int countnew;


    public ParseText(String s) {

        for (int i = 0; i < s.split(" ").length; i++) {
            if (myMaps.put(s.split(" ")[i], count)) {
                countnew = count + 1;
                myMaps.put(s.split(" ")[i], countnew);
            }

        }

    }

    public MyMaps getmyMaps() {
        return myMaps;
    }

}
