public class PritnUserMenu {
    static void mainMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню: \n");
        stringBuilder.append("1 - Получить информацию из базы данных\n");
        stringBuilder.append("2 - Удалить информацию из базы данных\n");
        stringBuilder.append("3 - Изменить информацию из базы данных\n");
        stringBuilder.append("4 - Модификация информации в базе данных\n");
        stringBuilder.append("-------------Выберите один из вариантов------------\n");
        System.out.println(stringBuilder);
    }
}
