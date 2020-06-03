# ktor single website

Ktor single website is a small project to learn the kotlin language

## How to start

[install gradle](https://yallalabs.com/devops/how-to-install-gradle-ubuntu-18-04-ubuntu-16-04)

Set up environment variables

    cp .env.example .env

Next run

    ./gradlew build

    docker-compose up --detach

#Development

Run in another terminal continuous build application

    ./gradlew --continuous build

When gradle end build just restart container

    docker-compose restart web

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