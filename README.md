## Для запуска тестов нужно?

* Установить JDK, версии 11+
* В IDE поставить расширения:
- Gauge 0.3.21
- Lombok
* Установить maven последней версии
* Установить Gauge version: 1.1.5 или выше (https://docs.gauge.org/getting_started/installing-gauge.html?os=windows&language=java&ide=vscode)
* Установить плагины для Gauge (https://docs.gauge.org/plugin.html?os=windows&language=java&ide=vscode):
* html-report (4.0.12)
* java (0.7.13)
* json-report (0.3.5)
* screenshot (0.0.1)
* spectacle (0.1.4)
* xml-report (0.2.3)

## Как запускать тесты?

* Внутри проекта, в директории "specs", нажимая на кнопку "run" внутри нужного тестового набора, либо у всей папки specs в целом
* В консоли, при помощи команды  , предварительно установив, нужный #тег тестовых наборов:
    ```
  mvn gauge:execute -DspecsDir=specs -Dtags=название тега 
  ```
