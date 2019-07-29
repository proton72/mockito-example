open class Nail(override val height: Int) : Kickable{
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Nail

        if (height != other.height) return false

        return true
    }

    override fun hashCode(): Int {
        return height
    }
}