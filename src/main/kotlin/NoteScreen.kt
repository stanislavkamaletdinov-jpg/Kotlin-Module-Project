fun selectNote(archive: Archive) {
    val menu = Menu {
        val noteItems: List<Pair<String, () -> Boolean>> = archive.notes.map { note ->
            note.name to { showNote(note); true }
        }

        listOf(
            "Создать заметку" to createNote@{
                println("Введите имя заметки")
                val noteName = readln()

                if (noteName.isBlank()) {
                    println("Имя не может быть пустым")
                } else {

                    println("Введите текст заметки")
                    val noteText = readln()

                    runCatching {
                        Note(noteName, noteText)
                    }.onSuccess { newNote ->
                        archive.notes.add(newNote)
                        println("Заметка $noteName создана")
                    }
                        .onFailure { error ->
                            println(error.message)
                        }
                }
                true
            }
                ) +noteItems + listOf(
                "Выход" to { println("Выхожу"); false }
            )
            }
                    menu . run ()
    }

    fun showNote(note: Note) {
        println("Заметка: ${note.name}")
        println(note.text)
        println("Нажмите Enter, чтобы вернуться")
        readln()
    }