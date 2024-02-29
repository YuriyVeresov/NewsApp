# NewsApp

Приложение для просмотра новостей с использованием API от newsapi.org. Новости сортируются по категориям и выводятся в алфавитном порядке.

## Описание

Это приложение позволяет пользователям просматривать последние новости по различным категориям. Новости загружаются из API newsapi.org, сортируются в алфавитном порядке и отображаются в удобном для пользователя формате.

## Запуск проекта

1. В корне проекта создать файл apikeys.properties;
2. Создать ключ если его нет [(ссылка на регистрацию)](https://newsapi.org/register)
3. Создать поле API_KEY
4. Установить значение ключа в API_KEY (пример: API_KEY="your api key")

## Технологии

Проект разработан с использованием чистой архитектуры и следующих технологий:
- [Kotlin](https://kotlinlang.org/docs/kotlin-doc.html)
- [Coroutines](https://kotlinlang.org/docs/coroutines-overview.html): Для выполнения асинхронных операций.
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata): архитектурный компонент андроид.
- [Jetpack Compose](https://developer.android.com/jetpack/compose): для создания пользовательского интерфейса Android.
- [Hilt](https://dagger.dev/hilt/): Библиотека для внедрения зависимостей.
- [Retrofit](https://square.github.io/retrofit/): для выполнения HTTP-запросов к API.
- [Moshi](https://github.com/square/moshi): для сериализации/десериализации JSON.
