package ventegocreative.co.nz.gdgapp.commands

interface Command<T> {
    fun execute(): T
}
