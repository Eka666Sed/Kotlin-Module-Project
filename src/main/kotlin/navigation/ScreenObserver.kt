package navigation

import screen.base.Screen

interface ScreenObserver {

    fun onScreenChanged(newScreen: Screen?)
}