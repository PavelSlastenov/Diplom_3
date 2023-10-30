#Diplom_2

### В проекте используется: ###

Java-11
#### Библиотеки: ####
- Selenium-java_3.141.59

- Webdrivermanager_5.4.1

- junit-4-12_2.13_3.3.0.0-SNAP2

- Allure-maven_2.10.0

#### Команда для запуска тестов: ####
- mvn -Dwebdriver.chrome.driver=/opt/chromedriver/chromedriver \
  -Dwebdriver.chrome.binary=/opt/chrome-for-testing/chrome \
  -Dwebdriver.yandex.driver=/opt/chromedriver/chromedriver-116 \
  -Dwebdriver.yandex.binary=/usr/bin/yandex-browser \
  -Dbrowser=yandex test
