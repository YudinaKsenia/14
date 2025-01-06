package ru.netology.qa;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {

        super("Товар с id " + id + " не существует.");
    }
}
