public class Main {
    public static void main(String[] args) {
        System.out.println("=== Практична робота №8. Користувацькі виключення ===");

        // 1. Перевірка некоректної місткості
        try {
            BookVector badVector = new BookVector(0);
        } catch (InvalidCapacityException e) {
            System.out.println("Помилка створення Vector: " + e.getMessage());
        }

        try {
            BookVector vector = new BookVector(2);

            Book b1 = new Book("1984", "George Orwell", 1949);
            Book b2 = new Book("Dune", "Frank Herbert", 1965);
            Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);

            System.out.println("\n=== Додавання книг ===");
            vector.add(b1);
            vector.add(b2);
            vector.addFirst(b3);
            vector.printAll();

            System.out.println("\n=== Спроба додати null ===");
            try {
                vector.add(null);
            } catch (NullBookException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            System.out.println("\n=== Спроба звернення за неправильним індексом ===");
            try {
                System.out.println(vector.get(10));
            } catch (InvalidIndexException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            System.out.println("\n=== Видалення елемента за індексом 1 ===");
            try {
                Book removed = vector.remove(1);
                System.out.println("Видалено: " + removed);
            } catch (EmptyVectorException | InvalidIndexException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            System.out.println("\n=== Поточний стан Vector ===");
            vector.printAll();
            System.out.println("Size: " + vector.size());
            System.out.println("Capacity: " + vector.capacity());

            System.out.println("\n=== Очищення Vector ===");
            vector.clear();
            vector.printAll();

            System.out.println("\n=== Спроба видалити з порожнього Vector ===");
            try {
                vector.remove(0);
            } catch (EmptyVectorException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

            System.out.println("\n=== Спроба отримати елемент з порожнього Vector ===");
            try {
                vector.get(0);
            } catch (EmptyVectorException e) {
                System.out.println("Помилка: " + e.getMessage());
            }

        } catch (InvalidCapacityException e) {
            System.out.println("Критична помилка створення Vector: " + e.getMessage());
        }
    }
}
