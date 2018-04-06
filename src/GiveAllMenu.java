public class GiveAllMenu {
    static void giveMainMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Главное меню. Выберите пункт:\n");
        stringBuilder.append("1 - Получение информации по наличию товара\n");
        stringBuilder.append("2 - Добавление товара\n");
        stringBuilder.append("3 - Удаление товара\n");
        stringBuilder.append("4 - Получить товар по ID-уникальному номеру\n");
        stringBuilder.append("5 - Изменение товара\n");
        System.out.println(stringBuilder);
    }
}
