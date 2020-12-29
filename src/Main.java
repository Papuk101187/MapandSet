public class Main {

    public static void main(String[] args) {


        ParseText parseText = new ParseText("Я иду по парку, иду один и вижу как по воде пробегает луч солнца");
        MyMaps myMaps = parseText.getmyMaps();
        MySet<MyMaps.Pair<String, Integer>> pairs = myMaps.pairSet();

        for (MyMaps.Pair<String, Integer> pair : pairs) {
            System.out.println("getKey() - " + pair.getKey() + ",  getValue() = " + pair.getValue());
        }


    }


}
