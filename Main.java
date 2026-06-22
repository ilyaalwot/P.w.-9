public class Main {
    public static void main(String[] args) {
        BookVector vector = new BookVector();

        Book b1 = new Book("1984", "George Orwell", 1949);
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book b3 = new Book("Dune", "Frank Herbert", 1965);
        Book b4 = new Book("Fahrenheit 451", "Ray Bradbury", 1953);

        System.out.println("=== Додавання в кінець ===");
        vector.add(b1);
        vector.add(b2);
        vector.printAll();

        System.out.println("\n=== Додавання на початок ===");
        vector.addFirst(b3);
        vector.printAll();

        System.out.println("\n=== Додавання в середину ===");
        vector.add(1, b4);
        vector.printAll();

        System.out.println("\n=== Отримання елемента за індексом 2 ===");
        System.out.println(vector.get(2));

        System.out.println("\n=== Метрики ===");
        System.out.println("Size: " + vector.size());
        System.out.println("Capacity: " + vector.capacity());

        System.out.println("\n=== Видалення елемента за індексом 1 ===");
        Book removed = vector.remove(1);
        System.out.println("Видалено: " + removed);
        vector.printAll();

        System.out.println("\n=== Очищення колекції ===");
        vector.clear();
        vector.printAll();

        System.out.println("Size після clear: " + vector.size());
        System.out.println("Capacity після clear: " + vector.capacity());
    }
}
