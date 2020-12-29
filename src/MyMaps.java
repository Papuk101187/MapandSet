import java.util.Iterator;
import java.util.Objects;

public class MyMaps<K, V> {

    private MySet<Pair<K, V>> pairs = new MySet();

    public static class Pair<K, V> {

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        private K key;
        private V value;

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return key.equals(pair.key);
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }
    }


    public V get(K key) {
        Pair<K, V> elem = new Pair<>(key, null);
        return pairs.find(elem).value;
    }

    public MySet<Pair<K, V>> pairSet() {
        return this.pairs;
    }

    public boolean put(K key, V value) {   //---- МЕТОД ДЛЯ ДОБАВЛЕНИЯ ОБЪЕКТА В КОНТЕЙНЕР----//
        Pair<K, V> elem = new Pair<>(key, value);
        return pairs.add(elem);
    }

    public boolean contains(K key) {
        Pair<K, V> elem = new Pair<>(key, null);
        return pairs.contains(elem);
    }


}