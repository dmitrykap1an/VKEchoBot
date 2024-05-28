# VK echo bot

## Функционал бота:
 - Отправка сообщений в ответ по шаблону:  "Вы написали: <Ваше сообщение боту>"


## Ивенты, на которые реагирует бот:</h3>
  - message_new
  - confirmation

Остальные эвенты игнорируются

## Запуск бота

В первую очередь надо изменить env_file.env:
  - заполнить ACCESS_TOKEN - токен доступа для бота(его можно сгенерировать, зайдя на страницу вашего сообщества -> Управление -> Работа с API -> Ключи доступа -> Создать ключ -> Разрешить приложению доступ к сообщениям сообщества -> Создать)
  - заполнить GROUP_ID - id группы вашего бота
  - заполнить CALLBACK_SERVER_INFO_TITLE - Заголовок вашего callback сервера
  - изменить CALLBACK_SERVER_INFO_URL(добавить доменное имя вашего сервера)
  - заполнить SERVER_PORT на свободный порт вашей машины

Далее для запуска выполняем команду в рабочей директории проекта:
```docker
docker build -t vk-echo-bot . ; docker run --env-file env_file.env vk-echo-bot
```
Бот автоматически привяжется к вашему сообществу, удалит все остальные callback серверы(Это надо для того, чтобы неплодились нерабочие инстансы бота) и добавит конфигурацию ивентов.

В конечном итоге, останется лишь подтвердить адрес сервера вручную, так как в vk api нет ендпоинта для автоматического подтверждения. Для этого надо зайти на страницу вашего сообщества -> Управление -> Работа с API -> Callback API -> Настройки сервера -> Подтвердить. Бот автоматически обработает confirmation ивент и начнет свою работу.


[Рабочая имплементация бота](https://vk.com/im?sel=-226051101 "Бот")

Также самого бота можно добавить в беседу. Для того, чтобы он ответил на ваше сообщение нужно его тегнуть.
