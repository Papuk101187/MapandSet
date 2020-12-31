import java.awt.datatransfer.DataFlavor;
import java.util.Iterator;

public class MySet<T> implements Iterable<T> {

    private Node[] buckets; // шаблон контейнер для наших нод;
    private int size = 0; // размер нашего контейнера;

    public int getSize() {
        return size;
    }

    public MySet() {
        this.buckets = new Node[20]; // коструктор для ицилизации контейнера с нодами
    }

    private static class Node { // класс наших создания наших НОД;
        Object value;
        Node next;

        public Node(Object value) {
            this.value = value;
        }
    }

    private Node findElem(T elem, int bucketIndex) {  //---- МЕТОД ДЛЯ ПОИСКА ОБЪЕКТА В КОНТЕЙНЕРЕ----//
        for (Node cur = buckets[bucketIndex]; cur != null; cur = cur.next) { //---- проходимся по массиву с нашими Нодами;
            if (cur.value.equals(elem)) { //---- если мы находим по значению;
                return cur; // если нашли то мы его возвращаем;
            }
        }
        return null; // если не находим возвращаем просто NULL;
    }

    public boolean add(T elem) {   //---- МЕТОД ДЛЯ ДОБАВЛЕНИЯ ОБЪЕКТА В КОНТЕЙНЕР----//
        int index = getIndex(elem);
        Node existElem = findElem(elem, index); // отравляем в метод поиска в контейнере (отправляем ЗНАЧЕНИЕ И ИНДЕКС);
        if (existElem != null) { // если находим;
            existElem.value = elem; // присваваем значение в найденное ноде новое значение;
            return true;
        } else {                 // если НЕ находим;
            Node n = new Node(elem); // создаём новую ноду;
            n.next = buckets[index]; // мы новой созданное ноде говорим "твой следующий елемент это список - то есть связываем ёё;
            buckets[index] = n; // после чего мы говорим что первым елементом нашего списка будет наша новая НОДА;
            ++size; // увеличиваем длину . делая инкремент нашего size;
            return false;
        }
    }

    private int getIndex(T elem) {
        int hash = elem.hashCode(); // находим ХЕШКОД этого елемента;
        hash = hash > 0 ? hash : -hash;
        return hash % buckets.length;
    }

    private int getHashCode(T elem) { // ---- ПОЛУЧАЕМ ХЕШКОД ----
        int hash = elem.hashCode(); // получаем хеш код объекта
        hash = hash > 0 ? hash : -hash; // проверяем если ниже нуля то добавляем минус чтобы минус на минус дал +
        return hash; // выводим хеш код объекта
    }

    public boolean contains(T elem) {
        int index = getIndex(elem);
        Node existElem = findElem(elem, index); // отравляем в метод поиска в контейнере (отправляем ЗНАЧЕНИЕ И ИНДЕКС);
        return existElem != null; // если не NULL возвращаем
    }

    public T find(T elem) {
        int index = getIndex(elem);
        Node existElem = findElem(elem, index); // отравляем в метод поиска в контейнере (отправляем ЗНАЧЕНИЕ И ИНДЕКС);
        return existElem != null ? (T) existElem.value : null;
    }

    @Override
    public Iterator<T> iterator() { // cоздали итератор анонимным классом
        return new Iterator<T>() {

            private int curBucKet = -1; // переменная для перехода на другой бакет или на другую корзину -1 потому
            // что когда мы зайдём в hasNext у нас первое условие не выполнится и чтобы попасть в первую корзиу и там искать.
            private Node cur = null; // нода которая будет у нас первым елементом в нашей выбранной корзине ,
            // null - чтобы начальное значение было а дальше мы его задаём

            @Override
            public boolean hasNext() { // hasNext проверяем есть ли дальше елементы

                if (cur != null && cur.next != null) { // если наш елемент не равняется null и следующий также не равняется null;
                    cur = cur.next; // то наш елемент сдвигаем дальше путём присваивания;
                    return true; // и возвращаем TRUE;
                }
                // по хорошему наше первое условие с if первый раз выполнятся НЕ БУДЕТ а будет идти в цикл и там начинать с начала
                // с первого бакета с первого елемента;

                //------------------ЕСЛИ В КОРЗИНЕ НИЧЕГО НЕ НАШЛИ МЫ ПЕРЕХОДИМ К ДРУГОЙ КОРЗИНЕ----------//
                for (curBucKet++; curBucKet < buckets.length; curBucKet++) { // "curBucKet++" - тут мы сразу делаем инкремент
                    // чтобы перейти на первую корзиу , "curBucKet < buckets.length" -тут мы говорим что наш curBucKet меньше нашего контейнера
                    // и "curBucKet++" - мы увеличиваем если не нашли;

                    if (buckets[curBucKet] != null) { // если первый елемент корзины НЕ равняется null //
                        cur = buckets[curBucKet]; // мы говорим что наш cur будет этим елементом
                        return true; // и выводим TRUE
                    }
                }
                return false; // если не нашли то выводим FALSE;
            }

            @Override
            public T next() {
                return (T) cur.value; // выводим наш елемент cur;
            }
        };
    }

    public T get(int index) {
        int count = 0;

        for (T t : this) {
            if (count == index) {
                return t;
            }
            count++;
        }

        return null;
    }


}