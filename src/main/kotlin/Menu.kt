class Menu
    (
    val itemsProvider: () -> List<Pair<String, () -> Boolean>>
) {

    fun run() {
        while (true) {

            val menuItems = itemsProvider()

            for (i in menuItems.indices) {
                println("$i. ${menuItems[i].first}")
            }

            val choice = readln().toIntOrNull()

            if (choice == null) {
                println("Нужно ввести цифру")
                continue
            }

            if (choice !in menuItems.indices) {
                println("Такого пункта нет")
                continue
            }

            val shouldContinue = menuItems[choice].second()
            if (!shouldContinue) break
        }
    }
}