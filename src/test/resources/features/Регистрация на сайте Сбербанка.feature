# language: ru

  @test
  Функционал: Регистрация на сайте Сбербанка

    Сценарий: Ввод неверного логина и пароля и последующая регистрация
      Дано Загружена главная страница
      И в поле логина введено значение "Логин94"
      И в поле пароля введено значение "Пароль94"
      И выполнено нажатие на кнопку Войти
      И выполнено ожидание в течение 1 секунд
      И Ошибка входа неверный логин иили пароль
      И выполнено нажатие на кнопку Регистраия
      И выполнено ожидание в течение 2 секунд
      И Загружена страница регистрации
      И в поле номера карты введено значение "4817760132907787"
      И выполнено нажатие на кнопку Продолжить
      И выполнено ожидание в течение 2 секунд
      И Загружена страница подтверждения регистрации смс кодом
      