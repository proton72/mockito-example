open class Hammer {
    open var size: Int = 0
    open fun kick(item: Kickable) {
        "Ударили молотком размера $size по предмету размера ${item.height}"
    }

    open fun giveOtherPeople(item: Kickable) = "Ударь плз молотком размера $size по предмету размера ${item.height}"
}