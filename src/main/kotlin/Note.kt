class Note
    (
    val name: String,
    val text: String
) {

    init {
        require(name.isNotBlank()) { "Название записки не может быть пустым" }
        require(text.isNotBlank()) { "Содержание записки не может быть пустым" }
    }
}