CREATE TABLE `CUSTOMER` (
                            `ID` INT NOT NULL AUTO_INCREMENT,
                            `EMAIL` VARCHAR(45) NOT NULL,
                            `PASSWORD` VARCHAR(200) NOT NULL,
                            `ROLE` VARCHAR(45) NOT NULL,
                            PRIMARY KEY (`ID`)
);

INSERT INTO CUSTOMER (`EMAIL`, `PASSWORD`, `ROLE`)
VALUES ('exampleuser@gmail.com', '12345', 'admin');
