fun main() {
    val amount = 200
    val total = 11_000
    val fee = calcFee(200, 11_000)
    println(" Для неэксклюзивного автора с предыдущей суммой продаж 11000 плата с прибыли 200 составит $fee.")
    println()
    val fee2 = calcFee(7_600, 17_000, true)
    println(" Для эксклюзивного автора с предыдущей суммой продаж 17000 плата с прибыли 7600 составит $fee2.")
}

fun calcFee(
    itemPrice: Int,
    total: Int,
    exclusive: Boolean = false
)
        : Int {
    var fee = itemPrice
    val excFee: Int
    fee = when {
        total <= 1000 -> {
            (itemPrice * 0.3).toInt()
        }
        total <= 10_000 -> {
            (itemPrice * 0.25).toInt()
        }
        total <= 50_000 -> {
            (itemPrice * 0.2).toInt()
        }
        total > 50_000 -> {
            (itemPrice * 0.15).toInt()
        }
        else -> {
            itemPrice
        }
    }
    if (exclusive) {
        return (fee - itemPrice * 0.05).toInt()
    } else {
        return fee
    }
}