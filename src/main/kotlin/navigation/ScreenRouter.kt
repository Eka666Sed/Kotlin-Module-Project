package navigation

import screen.StartScreen
import screen.base.Screen

object ScreenRouter {
    private val screens: ArrayDeque<Screen> = ArrayDeque(listOf(StartScreen()))
    private val observers: ArrayList<ScreenObserver> = arrayListOf()
        @Synchronized get

    fun routeToStartScreen() = sendUpdateEvent()

    fun routeToScreen(screen: Screen) {
        screens.addLast(screen)
        sendUpdateEvent()
    }

    fun routeBack() {
        screens.removeLast()
        sendUpdateEvent()
    }

    fun addObserver(observer: ScreenObserver) = observers.add(observer)

    private fun getCurrentScreen(): Screen? {
        return if (screens.isNotEmpty())
            screens.last()
        else null
    }

    private fun sendUpdateEvent() {
        val currentScreen = getCurrentScreen()
        observers.forEach { it.onScreenChanged(currentScreen) }
    }
}