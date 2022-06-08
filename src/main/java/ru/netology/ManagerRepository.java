package ru.netology;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class ManagerRepository {
    private Movie[] films = new Movie[0];
    private int numberLastMovies; // желаемое количество последних фильмов
    private int id;

    public ManagerRepository() {
        numberLastMovies = films.length;
    }

    public ManagerRepository(int numberLastMovies) {
        this.numberLastMovies = numberLastMovies;
    }

    public void add(Movie film) {
        int length = films.length + 1;
        Movie[] tmp = new Movie[length];
        System.arraycopy(films, 0, tmp, 0, films.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = film;
        films = tmp;
    }

    public Movie[] findAll() {
        return films;
    }

    public Movie[] findLast() {
        if (numberLastMovies < films.length) {
            Movie[] result = new Movie[numberLastMovies];
            for (int i = 0; i < numberLastMovies; i++) {
                int index = films.length - i - 1;
                result[i] = films[index];
            }
            return result;
        } else {
            Movie[] result = new Movie[films.length];
            for (int i = 0; i < result.length; i++) {
                int index = films.length - i - 1;
                result[i] = films[index];
            }
            return result;
        }
    }
}