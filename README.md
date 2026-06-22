# Практична робота №9
## Реалізація Comparable та Comparator для власної структури даних

У роботі було доповнено власну колекцію BookVector, створену в практичних роботах №7 та №8.

## Реалізовано:
- Comparable<Book> у класі Book
- Comparable<BookVector> у класі BookVector
- Comparator<Book> у класах:
  - BookYearComparator
  - BookAuthorComparator

## Сортування:
- sort() — сортування за замовчуванням через Comparable
- sort(Comparator<Book> comparator) — сортування через Comparator

## Порівняння:
- порівняння книг між собою
- порівняння колекцій між собою
