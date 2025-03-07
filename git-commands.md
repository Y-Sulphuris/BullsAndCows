# Шпаргалка по командам Git


## Использованные команды
Инициализация репозитория
```cmd
git init
```

Создание ветки
```cmd
git checkout -b "branch_name"
```

Переключение на ветку
```cmd
git checkout branch_name
```

Получение статуса гита (в основном только информации, на какой я сейчас ветке)
```cmd
git status
```

Добавление файлов для комита
```cmd
git add . - 
```

Комит изменений
```cmd
git commit -m "suicide"
```

Пуш изменений в remote
```cmd
git push -u origin (branch_name)
```
***

# Дополнительно изученые команды
## Посмотреть историю комитов:

```cmd
git log [--oneline]
```
## Вырезать и вставить файлы из одной ветки в другую

Нормального способа нет, надо вручную делать:

1. Скопировать файлы из исходной ветки для перемещения:

```cmd
cp path/to/src/file /tmp/
```

2. Переключиться на target ветку:

```cmd
git checkout "br-target"
```

3. Вставить файлы и добавиить их в commit:

```cmd
cp /tmp/file path/to/dst/file
git add path/to/dst/file
```

4. Закомитить ~~и сделать вид что так и должно быть~~:

```cmd
git commit -m "Added files from br-source"
```

## Посмотреть историю тегов

```cmd
git log --tags
```

## Удалить ветку

```cmd
git branch <-d/-D> <branch-name>  
```
(`-d` указывать при удалении уже замёрженой ветки, в противном случае `-D`)

## Вывести исписок всех веток

```cmd
git branch [-r/-a]
```
(`-r` указывать для вывода удалённых веток, `-a` для локальных И удалённых. Для только локальных ничего не указывать)

