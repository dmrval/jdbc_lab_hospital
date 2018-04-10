public class PritnUserMenu {
    static void mainMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню: \n");
        stringBuilder.append("1 - Получить информацию из базы\n");
        stringBuilder.append("2 - Добавить информацию в базу\n");
        stringBuilder.append("3 - Удалить информацию из базы\n");
        stringBuilder.append("4 - Изменить информацию из базы\n");
        stringBuilder.append("5 - Модификация информации в базе\n");
        System.out.println(stringBuilder);
    }

    static void menu_1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("По какой базе получить инфо: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }

    static void menu_2() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Какую информацию добавить: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }

    static void menu_3() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Какую информацию удалить: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }

    static void menu_4() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Какую информацию модифицировать: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад в главное меню\n");
        System.out.println(stringBuilder);
    }
}
