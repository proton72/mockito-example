open class Hammer {
    open var size: Int = 0
    open fun kick(item: Kickable) {
        "Ударили молотком размера $size по гвоздю $item"
    }
}