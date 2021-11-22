package com.example.homework21.data

import com.example.homework21.domain.NewsInteractor
import kotlin.random.Random

class DataSource : NewsInteractor {
    private val newsItems: List<NewsData> = initNewsList()

    private fun initNewsList(): List<NewsData> {
        val list = mutableListOf<NewsData>()
        val titleList =
            mutableListOf(
                "Диалог по кризису",
                "Что с валютой?",
                "Новое в Instagram",
                "Баскетбол"
            )
        val authorList =
            mutableListOf("Иван Иванов", "Пётр Петров", "Глеб Глебов", "Николай Никулин")
        val topicList = mutableListOf("Политика", "Экономика", "Технологии", "Спорт")
        val textList = mutableListOf(
            "Путин сообщил о готовности Лукашенко и Меркель к диалогу по кризису на границе ЕС.",
            "Российский рубль на торгах 12 ноября подешевел, доллар и евро подорожали.",
            "Instagram тестирует функцию оповещения о необходимости перерыва при просмотре ленты",
            "Белорусские баскетболистки одержали вторую победу в квалификации ЧЕ"
        )
        val dateList = mutableListOf("23.10.2021", "14.11.2021", "03.11.2021", "12.11.2021")

        for (i in 0..3) {
            for (j in 0..3) {
                list.add(
                    NewsData(
                        title = titleList[j],
                        author = authorList[Random.nextInt(authorList.size)],
                        date = dateList[Random.nextInt(dateList.size)],
                        topic = topicList[j],
                        text = textList[j]
                    )
                )
            }
        }
        return list
    }

    override fun loadText(): List<NewsData> {
        return newsItems
    }
}