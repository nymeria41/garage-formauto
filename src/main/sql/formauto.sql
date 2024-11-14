---- Creating DB for the project

drop table if exists `voiture`;
drop table if exists 'image';
drop table if exists `config`;

create table `voiture` (
    `id` int NOT NULL AUTO_INCREMENT,
    `marque` varchar(50) not  NULL,
    `modele` varchar(50) not  NULL,
    `annee` int not  NULL,
    `prix` double not  NULL,
    PRIMARY KEY (`id`)
    );


create table 'image' (
     `id` int NOT NULL AUTO_INCREMENT,
     `name` varchar(50) not  NULL,
     `type` varchar(50) not  NULL,
     `imageData` byte not  NULL,
     PRIMARY KEY (`id`)
);
