package screen

import data.ArchiveDataSource
import screen.base.Screen
import model.Archive
import navigation.ScreenRouter

class ArchivesScreen : Screen() {

    private val items: List<Archive> = ArchiveDataSource.getArchives()

    override val title: String = "Список архивов:"

    override val options: List<String> = listOf()

    override fun printStartOptions() {
        super.printStartOptions()
        if (items.isEmpty())
            println("У вас нет архивов")
        else {
            items.forEachIndexed { index, archive ->
                println("${index + 1}. ${archive.name}")
            }
        }
    }

    override fun handleInput(input: String) {
        val intInput = input.toIntOrNull()
        if (intInput == 0) ScreenRouter.routeBack()
        else if (intInput != null) {
            val archive = items[intInput - 1]
            ScreenRouter.routeToScreen(ArchiveDetailsScreen(archive))
        }
    }
}