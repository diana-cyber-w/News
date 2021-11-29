package com.example.homework21.domain

data class News(
    val title: Title,
    val author: Author,
    val topic: Topic,
    val text: Text,
    val date: Date
) {
    enum class Title(val title: String) {
        POLITICS("Диалог по кризису"),
        ECONOMY("Что с валютой?"),
        TECHNOLOGIES("Новое в Instagram"),
        SPORT("Баскетбол")
    }

    enum class Author(val author: String) {
        IVAN("Иван Иванов"),
        PETER("Пётр Петров"),
        GLEB("Глеб Глебов"),
        NIKOLAY("Николай Никулин")
    }

    enum class Topic(val topic: String) {
        POLITICS("Политика"),
        ECONOMY("Экономика"),
        TECHNOLOGIES("Технологии"),
        SPORT("Спорт")
    }

    enum class Text(val text: String) {
        POLITICS("Путин сообщил о готовности Лукашенко и Меркель к диалогу по кризису на границе ЕС."),
        ECONOMY("Российский рубль на торгах 12 ноября подешевел, доллар и евро подорожали."),
        TECHNOLOGIES("Instagram тестирует функцию оповещения о необходимости перерыва при просмотре ленты."),
        SPORT("Белорусские баскетболистки одержали вторую победу в квалификации ЧЕ.")
    }

    enum class Date(val date: String) {
        AUGUST("04.08.2021"),
        SEPTEMBER("12.09.2021"),
        OCTOBER("23.10.2021"),
        NOVEMBER("14.11.2021")
    }
}
