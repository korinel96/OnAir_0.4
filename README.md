# OnAir_0.4
Всем привет!
Данный проект является частью дипломной работы Ким В.Ю.

Суть приложения проста - проводить видеотрансляцию. Данное приложени можно также встроить как модуль для OpenVPN for Android (данный проект будет залит позже в отдельном репозитории).

На главном экране приложения вам предлагается сделать выбор разрешения и фреймрейта для видеотрансляции. Стоит понимать, что данный выбор делается для того, чтобы сформировать корректную ссылку на стрим, КОТОРАЯ задает все параметры будущей трансляции. Суть в том, что, редактирую ссылку на трансляцию, можно удаленно задавать параметры видеотрансляции.

Чтобы просмотреть трансляцию, смартфон с запущенным приложением должен находиться в одной сети с принимающим устройством. Например, прием удобно осуществлять на ПК/ноутбуке с помощью приложения VLC (ctrl+n, вставить ссылку, сформированную в приложении). Для уменьшения задержек стоит изменить кэширование в дополнительных настройках VLC (300мс будет вполне достаточно).

ВНИМАНИЕ! Разрешения видео, представленные на главном экране приложения были получены экспериментальным путем и работают на LG Nexus 5X Android 7.1.2. Данные разрешения могут некорректно работать на других устройствах и вызывать ошибки в приложении, в то время как теоретически могут работать с разрешениями, которые вызывали ошибки на испытуемом устройстве.

Чтобы не искать в данном репозитории приложение(оно довольно глубоко скомпилированно) ниже приведена ссылка на папку, где храниться актуальная версия приложения.

По всем вопросам писать на vkjohn96@gmail.com. С удовольствием на них отвечу!

Ссылка на приложение: https://goo.gl/DM2Vn5

P.S. Также существует пример интеграции данного проекта в иной проект с открытым исходный кодом под лицензией GPLv2, его можно найти по ссылке https://github.com/korinel96/ics-openvpn_with_RTSP_streaming/. Приложение на основе данного проекта можно найти по ссылке выше.