package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ManagerTest {
    Movie first = new Movie(1, 1, "Бладшот", "боевик");
    Movie second = new Movie(2, 2, "Вперёд", "мультфильм");
    Movie third = new Movie(3, 3, "Отель 'Белград'", "комедия");
    Movie fourth = new Movie(4, 4, "Джентельмены", "боевик");
    Movie fifth = new Movie(5, 5, "Человек-невидимка", "ужасы");
    Movie sixth = new Movie(6, 6, "Тролли. Мировой тур", "комедия");
    Movie seventh = new Movie(7, 7, "Номер один", "комедия");

    ManagerRepository manager = new ManagerRepository();

    @Test
    public void addMovie() {
        // добавление фильмов
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);

        Movie[] actual = manager.findAll(); // вывод всех фильмов в порядке добавления
        Movie[] expected = {first, second, third, fourth, fifth, sixth, seventh};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void lastMoviesTest() {
        ManagerRepository manager1 = new ManagerRepository(5); //вывод последних добавленных фильмов в обратном от добавления порядке

        manager1.add(first);
        manager1.add(second);
        manager1.add(third);
        manager1.add(fourth);
        manager1.add(fifth);
        manager1.add(sixth);
        manager1.add(seventh);

        Movie[] actual = manager1.findLast();
        Movie[] expected = {seventh, sixth, fifth, fourth, third};

        Assertions.assertArrayEquals(expected, actual);

    }

}
