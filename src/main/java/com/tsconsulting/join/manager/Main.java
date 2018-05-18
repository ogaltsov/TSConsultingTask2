package com.tsconsulting.join.manager;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {

            System.out.println("[INFO] Идет считывание файла.");

            Manager.initManager(args[0], args[1]);

        } catch (IOException | NullPointerException e) {
            System.out.println("[ERROR] Ошибка! Не найден файл: " + e.getMessage());
        }
        System.out.println("[INFO] Программа завершена!");
    }
}