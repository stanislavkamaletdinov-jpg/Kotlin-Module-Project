fun selectArchive(archivesList: MutableList<Archive>) {
    val menu = Menu {
        val archiveItems: List<Pair<String, () -> Boolean>> = archivesList.map { archive ->
            archive.name to { selectNote(archive); true }
        }

        listOf(
            "Создать архив" to {
                println("Введите имя архива")
                val archiveName = readln()

                runCatching {
                    Archive(archiveName)
                }.onSuccess { newArchive ->
                    archivesList.add(newArchive)
                    println("Архив $archiveName создан")
                }
                    .onFailure { error ->
                        println(error.message)
                    }; true
            }
        ) + archiveItems + listOf(
            "Выход" to { println("Выхожу"); false }
        )
    }
    menu.run()
}