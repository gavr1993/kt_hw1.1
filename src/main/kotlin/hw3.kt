fun main() {
    val secondsAgo = 2_500_000
    val publishedAgoText = getPublishedAgoText(secondsAgo)
    println("Опубликовано $publishedAgoText назад.")
}

fun getPublishedAgoText(publishedAgo: Int): String {
    val minutesAgo = publishedAgo / 60
    val hoursAgo : Int = publishedAgo / 3_600
    val daysAgo : Int = publishedAgo / 86_400
    val weeksAgo : Int = publishedAgo / 604_800
    val monthAgo : Int = publishedAgo / 2_628_000
    if (publishedAgo in 0..59) {
        return when (publishedAgo) {
            in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$publishedAgo секунды"
            in 5..20, in 25..30, in 35..40, in 45..50, in 55..59 -> "$publishedAgo секунд"
            1, 21, 31, 41, 51 -> "$publishedAgo секунду"
            else -> "несколько секунд"
        }
    }
    if (publishedAgo in 60..3_599) {
        return when (minutesAgo) {
            in 2..4, in 22..24, in 32..34, in 42..44, in 52..54 -> "$minutesAgo минуты"
            in 5..20, in 25..30, in 35..40, in 45..50, in 55..59 -> "$minutesAgo минут"
            1, 21, 31, 41, 51 -> "$minutesAgo минуту"
            else -> "несколько минут"
        }
    }
    if(publishedAgo in 3_600..86_339) {
        return when (hoursAgo) {
            in 2..4, 22 -> "$hoursAgo часа"
            in 5..20 -> "$hoursAgo часов"
            1, 21 -> "$hoursAgo час"
            else -> "несколько часов"
        }
    }
    if(publishedAgo in 83_340..86_400) {
        return "сутки"
    }
    if(publishedAgo in 86_401..604_799) {
        return when (daysAgo) {
            in 2..4 -> "$daysAgo дня"
            5, 6 -> "$daysAgo дней"
            1 -> "1 день"
            else -> "несколько дней"
        }
    }
    if(publishedAgo in 604_800..2_627_999) {
        return when (weeksAgo) {
            in 2..4 -> "$weeksAgo недели"
            1 -> "неделю"
            else -> "несколько недель"
        }
    }
    if(publishedAgo in 2_628_000..31_539_000) {
        return when (monthAgo) {
            in 2..4 -> "$hoursAgo месяца"
            in 5..11 -> "$hoursAgo месяцев"
            1 -> "месяц"
            else -> "несколько месяцев"
        }
    }
    if(publishedAgo in 31_540_000..63_079_999) {
        return "год назад"
    }
    if(publishedAgo  > 63_080_000) {
        return "несколько лет"
    }
    return "некоторое время"
}
