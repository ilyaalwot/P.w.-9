public class Main {
    public static void main(String[] args) {
        try {
            BookVector vector = new BookVector(5);

            Book b1 = new Book("Dune", "Frank Herbert", 1965);
            Book b2 = new Book("1984", "George Orwell", 1949);
            Book b3 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
            Book b4 = new Book("Fahrenheit 451", "Ray Bradbury", 1953);

            vector.add(b1);
            vector.add(b2);
            vector.add(b3);
            vector.add(b4);

            System.out.println("=== Початковий Vector ===");
            vector.printAll();

            // Comparable для Book
            System.out.println("\n=== Порівняння двох книг через Comparable ===");
            System.out.println("b1.compareTo(b2) = " + b1.compareTo(b2));

            // sort() без аргументів - по title
            System.out.println("\n=== Сортування за замовчуванням (Comparable, по title) ===");
            vector.sort();
            vector.printAll();

            // sort(Comparator) - по year
            System.out.println("\n=== Сортування через Comparator (по year) ===");
            vector.sort(new BookYearComparator());
            vector.printAll();

            // sort(Comparator) - по author
            System.out.println("\n=== Сортування через Comparator (по author) ===");
            vector.sort(new BookAuthorComparator());
            vector.printAll();

            // Порівняння двох колекцій
            BookVector vector2 = new BookVector(5);
            vector2.add(new Book("Java Core", "Some Author", 2020));
            vector2.add(new Book("Clean Code", "Robert Martin", 2008));

            System.out.println("\n=== Порівняння двох колекцій ===");
            int result = vector.compareTo(vector2);

            if (result > 0) {
                System.out.println("Перший Vector більший за другий");
            } else if (result < 0) {
                System.out.println("Перший Vector менший за другий");
            } else {
                System.out.println("Vectors рівні за кількістю елементів");
            }

        } catch (InvalidCapacityException e) {
            System.out.println("Помилка створення Vector: " + e.getMessage());
        }
    }
}
