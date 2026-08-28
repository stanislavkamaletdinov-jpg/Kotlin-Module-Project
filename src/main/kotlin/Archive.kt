class Archive
    (
    val name: String)
{

    init {
        require(name.isNotBlank()) {"Имя архива не может быть пустым"}
    }

    val notes: MutableList<Note> = mutableListOf()

}