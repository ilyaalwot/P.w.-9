public class BookVector {
    private Book[] data;
    private int size;

    public BookVector() {
        data = new Book[5];
        size = 0;
    }

    public void add(Book book) {
        ensureCapacity();
        data[size] = book;
        size++;
    }

    public void addFirst(Book book) {
        ensureCapacity();

        for (int i = size; i > 0; i--) {
            data[i] = data[i - 1];
        }

        data[0] = book;
        size++;
    }

    public void add(int index, Book book) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Невірний індекс: " + index);
        }

        ensureCapacity();

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }

        data[index] = book;
        size++;
    }

    public Book get(int index) {
        checkIndex(index);
        return data[index];
    }

    public Book remove(int index) {
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
        data = new Book[5];
        size = 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    private void ensureCapacity() {
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
            throw new IndexOutOfBoundsException("Невірний індекс: " + index);
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
}
