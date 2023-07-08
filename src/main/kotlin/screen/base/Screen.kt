package screen.base

abstract class Screen {

    abstract val title: String

    protected var intInput: Int? = null

    abstract val options: List<String>

    abstract fun handleInput(input: String)

    open fun printStartOptions() {
        println(title)
        println("0. Выход")
        options.forEach { println(it) }
    }

    protected fun printWrongInputMessage() = println("Вы ввели неверное значение")
}
