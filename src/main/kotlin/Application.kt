import java.util.Scanner
import navigation.ScreenObserver
import navigation.ScreenRouter
import screen.base.Screen
import kotlin.system.exitProcess

class Application : ScreenObserver {

    private var scanner = Scanner(System.`in`)
    private lateinit var currentScreen: Screen

    init {
        ScreenRouter.addObserver(this)
    }

    override fun onScreenChanged(newScreen: Screen?) {
        newScreen?.let {
            currentScreen = newScreen
            currentScreen.printStartOptions()
        } ?: run {
            stop()
        }
    }

    fun start() {
        ScreenRouter.routeToStartScreen()
        while (scanner.hasNext()) {
            val stringInput = scanner.nextLine()
            currentScreen.handleInput(stringInput)
        }
    }

    private fun stop() {
        println("Конец!")
        exitProcess(0)
    }
}