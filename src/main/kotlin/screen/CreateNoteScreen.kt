package screen

import data.ArchiveDataSource
import model.Archive
import model.Note
import navigation.ScreenRouter
import screen.base.Screen
import java.util.UUID

class CreateNoteScreen(private val archive: Archive) : Screen() {

    private var noteName = ""

    override val title: String = "Создание заметки:"

    override val options: List<String> = listOf("Введите название заметки (имя не может быть пустым):")

    override fun handleInput(input: String) {
        when {
            intInput == 0 -> ScreenRouter.routeBack()
            input.isNotEmpty() and noteName.isEmpty() -> {
                noteName = input
                println("Введите текст заметки:")
            }

            noteName.isNotEmpty() -> {
                val note = Note(UUID.randomUUID().toString(), noteName, input)
                archive.addNote(note)
                ArchiveDataSource.updateArchive(archive)
                ScreenRouter.routeBack()
            }
        }
    }
}