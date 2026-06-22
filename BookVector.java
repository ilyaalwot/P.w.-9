import java.util.Comparator;

public class BookVector implements Comparable<BookVector> {
    private Book[] data;
    private int size;

    public BookVector() throws InvalidCapacityException {
        this(5);
    }

    public BookVector(int capacity) throws InvalidCapacityException {
        if (capacity <= 0) {
            throw new InvalidCapacityException("Початкова місткість повинна бути більше 0");
        }

        data = new Book[capacity];
        size = 0;
    }

    public void add(Book book) {
        if (book == null) {
            throw new NullBookException("Неможливо додати null у Vector");
        }

        ensureCapacity();
        data[size] = book;
        size++;
    }

    public void addFirst(Book book) {
        if (book == null) {
            throw new NullBookException("Неможливо додати null у Vector");
        }

        ensureCapacity();

        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }

        data[0] = book;
        size++;
    }

    public void add(int index, Book book) {
        if (book == null) {
            throw new NullBookException("Неможливо додати null у Vector");
        }

        if (index < 0 || index > size) {
            throw new InvalidIndexException("Невірний індекс для вставки: " + index);
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = book;
        size++;
    }

    public Book get(int index) throws EmptyVectorException {
        if (size == 0) {
            throw new EmptyVectorException("Vector порожній, неможливо отримати елемент");
        }

        checkIndex(index);
        return data[index];
    }

    public Book remove(int index) throws EmptyVectorException {
        if (size == 0) {
            throw new EmptyVectorException("Vector порожній, неможливо видалити елемент");
        }

        checkIndex(index);

        Book removed = data[index];

        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        data[size - 1] = null;
        size--;

        return removed;
    }

    public void clear() {
        if (data == null) {
            throw new VectorStateException("Внутрішній масив не ініціалізований");
        }

        for (int i = 0; i < size; i++) {
            data[i] = null;
        }

        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        if (data == null) {
            throw new VectorStateException("Внутрішній масив не ініціалізований");
        }
        return data.length;
    }

    private void ensureCapacity() {
        if (data == null) {
            throw new VectorStateException("Внутрішній масив не ініціалізований");
        }

        if (size >= data.length) {
            Book[] newData = new Book[data.length * 2];

            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new InvalidIndexException("Невірний індекс: " + index);
        }
    }

    public void printAll() {
        if (size == 0) {
            System.out.println("Vector порожній");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.println(i + ": " + data[i]);
        }
    }

    // Сортування за замовчуванням через Comparable<Book>
    public void sort() {
        if (size < 2) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (data[j].compareTo(data[j + 1]) > 0) {
                    Book temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Сортування через Comparator<Book>
    public void sort(Comparator<Book> comparator) {
        if (size < 2) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if (comparator.compare(data[j], data[j + 1]) > 0) {
                    Book temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    // Порівняння колекцій між собою
    // Будемо порівнювати за кількістю елементів
    @Override
    public int compareTo(BookVector other) {
        return Integer.compare(this.size, other.size);
    }
}
