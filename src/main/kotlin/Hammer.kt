open class Hammer(paramsOfHammer: Parameters = Parameters(5, 5)) {
    open var params = paramsOfHammer
    open var size
        get() = params.size
        set(value) {
            this.params.size = value + 1
        }
    open var weight
        get() = params.weight
        set(value) {
            this.params.weight = value - 1
        }

    open fun kick(item: Kickable) {
        "Ударили молотком размера $size и веса $weight по предмету высоты ${item.height}"
    }

    open fun giveOtherPeople(item: Kickable) =
            "Ударь плз молотком размера $size и веса $weight по предмету высоты ${item.height}"
}

open class Parameters(open var size: Int, open var weight: Int)