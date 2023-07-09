package screen

import data.ArchiveDataSource
import navigation.ScreenRouter
import screen.base.Screen

class CreateArchiveScreen : Screen() {

    override val title: String = "Создание архива:"
    override val options: List<String> = listOf("Введите название архива (имя не может быть пустым):")

    override fun handleInput(input: String) {
        when {
            intInput == 0 -> ScreenRouter.routeBack()
            input.isNotEmpty() -> {
                ArchiveDataSource.createArchive(name = input)
                println("Ваш архив добавлен в список архивов")
                println()
                ScreenRouter.routeBack()
            }

            else -> println("Введите название архива:")
        }
    }
}