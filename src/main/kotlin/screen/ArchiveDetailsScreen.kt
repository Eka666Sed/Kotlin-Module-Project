package screen

import model.Archive
import screen.base.Screen
import model.Note
import navigation.ScreenRouter


class ArchiveDetailsScreen (
        private val archive: Archive
) : Screen() {

    private val items: List<Note> = archive.getNotes()

    override val title: String = "Архив: ${archive.name}"

    override val options: List<String> = listOf("1. Создать заметку")

    override fun printStartOptions() {
        super.printStartOptions()
        items.forEachIndexed { index, note ->
            println("${index + 2}. ${note.name}")
        }
    }

    override fun handleInput(input: String) {
        val intInput = input.toIntOrNull()
        intInput?.let {
            when (it) {
                0 -> ScreenRouter.routeBack()
                1 -> ScreenRouter.routeToScreen(CreateNoteScreen(archive))
                else -> {
                    if (it - 2 in items.indices) {
                        val note = items[intInput - 2]
                        ScreenRouter.routeToScreen(NoteDetailsScreen(note))
                    } else printWrongInputMessage()
                }
            }
        } ?: run {
            printWrongInputMessage()
        }
    }
}


