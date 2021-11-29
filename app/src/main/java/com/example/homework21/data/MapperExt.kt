package com.example.homework21.data

import com.example.homework21.data.storage.NewsEntity
import com.example.homework21.domain.News
import java.lang.Exception

fun NewsEntity.toNews() =
    News(
        title = resolveTitle(title),
        author = resolveAuthor(author),
        topic = resolveTopic(topic),
        text = resolveText(text),
        date = resolveDate(date)
    )

fun resolveTitle(title: String): News.Title =
    when (title) {
        "Диалог по кризису" -> News.Title.POLITICS
        "Что с валютой?" -> News.Title.ECONOMY
        "Новое в Instagram" -> News.Title.TECHNOLOGIES
        "Баскетбол" -> News.Title.SPORT
        else -> throw Exception("This title does not exist")
    }

fun resolveAuthor(author: String): News.Author =
    when (author) {
        "Иван Иванов" -> News.Author.IVAN
        "Пётр Петров" -> News.Author.PETER
        "Глеб Глебов" -> News.Author.GLEB
        "Николай Никулин" -> News.Author.NIKOLAY
        else -> throw Exception("This author does not exist")
    }

fun resolveTopic(topic: String): News.Topic =
    when (topic) {
        "Политика" -> News.Topic.POLITICS
        "Экономика" -> News.Topic.ECONOMY
        "Технологии" -> News.Topic.TECHNOLOGIES
        "Спорт" -> News.Topic.SPORT
        else -> throw Exception("This topic does not exist")
    }

fun resolveText(text: String): News.Text =
    when (text) {
        "Путин сообщил о готовности Лукашенко и Меркель к диалогу по кризису на границе ЕС." -> News.Text.POLITICS
        "Российский рубль на торгах 12 ноября подешевел, доллар и евро подорожали." -> News.Text.ECONOMY
        "Instagram тестирует функцию оповещения о необходимости перерыва при просмотре ленты." -> News.Text.TECHNOLOGIES
        "Белорусские баскетболистки одержали вторую победу в квалификации ЧЕ." -> News.Text.SPORT
        else -> throw Exception("This text does not exist")
    }

fun resolveDate(date: String): News.Date =
    when (date) {
        "04.08.2021" -> News.Date.AUGUST
        "12.09.2021" -> News.Date.SEPTEMBER
        "23.10.2021" -> News.Date.OCTOBER
        "14.11.2021" -> News.Date.NOVEMBER
        else -> throw Exception("This date does not exist")
    }

fun News.toNewsEntity() =
    NewsEntity(
        title = title.title,
        author = author.author,
        topic = topic.topic,
        text = text.text,
        date = date.date
    )