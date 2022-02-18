CREATE DATABASE mycalc_quyntess DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE mycalc_quyntess;
CREATE TABLE IF NOT EXISTS my_calc (
    mySeq INT AUTO_INCREMENT PRIMARY KEY,
    myFomula VARCHAR(255) NOT NULL,
    result VARCHAR(255) NOT NULL,
    createDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)  

GRANT ALL ON mycalc_quyntess.* TO 'quyntess'@'localhost' IDENTIFIED BY 'passcode';