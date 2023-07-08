package screen

import navigation.ScreenRouter
import screen.base.Screen


class StartScreen: Screen() {
    override val title: String = "Старт:"

    override val options: List<String> = listOf("1. Создать архив", "2. Мои архивы")

    override fun handleInput(input: String) = when (input.toIntOrNull()) {
        0 -> ScreenRouter.routeBack()
        1 -> ScreenRouter.routeToScreen(CreateArchiveScreen())
        2 -> ScreenRouter.routeToScreen(ArchivesScreen())
        else -> printWrongInputMessage()
    }
}