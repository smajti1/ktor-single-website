# ktor single website

Ktor single website is a small project to learn the kotlin language

## How to start

[install gradle](https://yallalabs.com/devops/how-to-install-gradle-ubuntu-18-04-ubuntu-16-04)

Set up environment variables

    cp .env.example .env

Next run

    ./gradlew build

    docker-compose build --no-cache

use --no-cache if you rerun `./gradlew build` to refresh .jar file

    docker-compose up --detach

Or just run:

    ./gradlew build && docker-compose build --no-cache && docker-compose down && docker-compose up --detach

Create table user and insert some users into db
```
create table user (
    id    int,
    name  varchar(63),
    email varchar(63)
);

INSERT INTO `user` (`id`, `name`, `email`) VALUES ('1', 'testA', 'smajti1@gmail.com');
INSERT INTO `user` (`id`, `name`, `email`) VALUES ('2', 'testB', 'smajti1+test2@gmail.com');
```

visit http://localhost:8080/test

#Docs
- https://ktor.io