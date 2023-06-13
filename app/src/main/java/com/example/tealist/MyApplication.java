package com.example.tealist;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<Tea> teaList = new ArrayList<Tea>();
    private static int nextId = 10;

    public MyApplication() {
        fillTeaList();
    }

    private void fillTeaList() {
        Tea t0 = new Tea(0, "Улун Уи Да Хун Пао", "вкус мягкий - нет резких оттенков, лист дает аромат конопляного масла, настой сладкий и приятный", "https://dachatea.ru/system/uploads/product_image/file/23637/medium_IMG_6742.JPG");
        Tea t1 = new Tea(1, "Йерба Мате \"Деспалада\"", " понравится тем, кто знает историю и культуру Мате", "https://dachatea.ru/system/uploads/product_image/file/21138/medium_IMG_0685.jpg");
        Tea t2 = new Tea(2, "Зеленый Хуан Шань Мао Фэн, Цин Мин", "на выдохе в послевкусие поднимается аромат выпечки и печенья", "https://dachatea.ru/system/uploads/product_image/file/24223/medium_IMG_7987.JPG");
        Tea t3 = new Tea(3, "Е Шэн Бай Ча Шоу Мэй", "Во вкусе много сладких фруктовых нот, с оттенками рассыпчатых дачных яблок и груш", "https://dachatea.ru/system/uploads/product_image/file/25945/medium_IMG_0868.JPG");
        Tea t4 = new Tea(4, "Красный Е Шэн Сяо Чжун", "Вкус настоя цитрусовый с кислинкой, не яркий, напоминает выдержанный красный чай", "https://dachatea.ru/system/uploads/product_image/file/22660/very_big_IMG_4201.JPG");
        Tea t5 = new Tea(5, "Зеленый Япония \"Сенча Фукамуси\"", "Обладает насыщенным ароматом и мягким вкусом, быстро заваривается", "https://dachatea.ru/system/uploads/product_image/file/10949/very_big_IMG_7602.jpg");
        Tea t6 = new Tea(6, "Травяной сбор \"Гидатлинская долина\"", "приятный вкус плодов шиповника и плодов боярышника", "https://dachatea.ru/system/uploads/product_image/file/21007/very_big_IMG_0355.JPG");
        Tea t7 = new Tea(7, "Белый чай Патхивара org, Непал", "Вкус чая сладкий, жирный, богатый на цитрусовые оттенки", "https://dachatea.ru/system/uploads/product_image/file/18550/very_big_IMG_4624.jpg");
        Tea t8 = new Tea(8, "Красный чай Sunny blooms, Цейлон", "Сбор 2023 года", "https://dachatea.ru/system/uploads/product_image/file/26522/very_big_IMG_1804.JPG");
        Tea t9 = new Tea(9, "Иван-чай гранулированный с листом малины ферментированным", "Иван-чай нормализует нервную и пищеварительную системы", "https://dachatea.ru/system/uploads/product_image/file/22829/medium_IMG_4630.JPG");
        teaList.addAll(Arrays.asList(new Tea[]{t0, t1, t2, t3, t4, t5, t6, t7, t8, t9}));
    }

    public static List<Tea> getTeaList() {
        return teaList;
    }

    public static void setTeaList(List<Tea> teaList) {
        MyApplication.teaList = teaList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }
}
