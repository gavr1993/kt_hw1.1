fun main() {
    val index= getBodyMassIndex(1.5, 300)
    val verdict = getVerdict(index)
    println(verdict)
}

fun getVerdict(index : Double): String {
    return when(index) {
        in Double.MIN_VALUE..16.0 -> "Выраженный дефицит массы тела."
        in 16.1..18.5 -> "Недостаточная (дефицит) масса тела."
        in 18.6..25.0 -> "Норма."
        in 25.1..30.0 -> "Избыточная масса тела (предожирение)."
        in 30.1..35.0 -> "Ожирение."
        in 35.1..40.0 -> "Ожирение резкое."
        in 40.1..Double.MAX_VALUE -> "Очень резкое ожирение."
        else -> "Проверьте правильность данных"
    }
}

fun getBodyMassIndex(
    height: Double,
    weight: Int
)
        : Double {
    return (weight / (height * height)).toDouble()
}