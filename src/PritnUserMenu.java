public class PritnUserMenu {
    static void mainMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню: \n");
        stringBuilder.append("1 - Получить информацию из базы данных\n");
        stringBuilder.append("2 - Удалить информацию из базы данных\n");
        stringBuilder.append("3 - Изменить информацию из базы данных\n");
        stringBuilder.append("4 - Модификация информации в базе данных\n");
        System.out.println(stringBuilder);
    }

    static void menu_1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("По какой базе получить инфо: \n");
        stringBuilder.append("1 - Пациентов\n");
        stringBuilder.append("2 - Врачей\n");
        stringBuilder.append("3 - Визитов\n");
        stringBuilder.append("4 - Вернуться назад\n");
        System.out.println(stringBuilder);
    }
}
