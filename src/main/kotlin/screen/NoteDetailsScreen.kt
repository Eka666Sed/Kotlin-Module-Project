package screen

import data.ArchiveDataSource
import model.Note
import navigation.ScreenRouter
import screen.base.Screen

class NoteDetailsScreen(private val note: Note) : Screen() {

    override val title: String = "Заметка ${note.name}"

    override val options: List<String> = listOf(
            "1. Просмотреть заметку",
            "2. Редактировать заметку"
    )

    override fun handleInput(input: String) {
        val intInput = input.toIntOrNull()
        intInput?.let {
            when (it) {
                0 -> ScreenRouter.routeBack()
                1 -> println(note.text)
                2 -> println("Введите текст заметки:")
            }
        } ?: run {
            editNote(input)
            ScreenRouter.routeBack()
        }
    }

    private fun editNote(text: String) {
        val newNote = note.copy(text = "${note.text} $text")
        ArchiveDataSource.updateNoteInArchive(newNote)
    }
}