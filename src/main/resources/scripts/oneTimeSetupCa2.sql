/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */; -- 0 er true, 1 = false
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Vi har en database, der hedder ca2_databuilders.
-- Test databasen hedder ca2_test_databuilders. 

CREATE DATABASE `ca2_test_databuilders`;

USE `ca2_test_databuilders`;

-- Vi starter med at lave en kopi af vores tabeller fra ca2_databuilders databasen til ca2_test_databuilders databasen. 
CREATE TABLE ca2_test_databuilders.address LIKE ca2_databuilders.ADDRESS;

-- Laver en ny tabel, som hedder addressTest. 
CREATE TABLE addressTest LIKE ca2_databuilders.ADDRESS;

-- Du 2 ovenstående sql statements gentages nu for hver tabel, så vi har muligheden for at teste mapper metoderne til alle tabellerne. 
CREATE TABLE ca2_test_databuilders.cityinfo LIKE ca2_databuilders.CITYINFO;
CREATE TABLE cityinfoTest LIKE ca2_databuilders.CITYINFO;

CREATE TABLE ca2_test_databuilders.company LIKE ca2_databuilders.COMPANY;
CREATE TABLE companyTest LIKE ca2_databuilders.COMPANY;

CREATE TABLE ca2_test_databuilders.hobby LIKE ca2_databuilders.HOBBY;
CREATE TABLE hobbyTest LIKE ca2_databuilders.HOBBY;

CREATE TABLE ca2_test_databuilders.infoentity LIKE ca2_databuilders.INFOENTITY;
CREATE TABLE infoentityTest LIKE ca2_databuilders.INFOENTITY;

CREATE TABLE ca2_test_databuilders.person LIKE ca2_databuilders.PERSON;
CREATE TABLE personTest LIKE ca2_databuilders.PERSON;

CREATE TABLE ca2_test_databuilders.person_hobby LIKE ca2_databuilders.PERSON_HOBBY;
CREATE TABLE person_hobbyTest LIKE ca2_databuilders.PERSON_HOBBY;

CREATE TABLE ca2_test_databuilders.phone LIKE ca2_databuilders.PHONE;
CREATE TABLE phoneTest LIKE ca2_databuilders.PHONE;

-- DEMO DATA TIL TEST

-- !!!Nedenstående gøres vedhjælp af persistentUnit!!!
-- Laver en ny bruger til test databasen og giver privileger til databasen. Laves kun en gang derfor eer den udkommenteret. 
 -- CREATE USER 'testinguser' IDENTIFIED BY 'tryALot';
 -- GRANT ALL PRIVILEGES ON fogTest.* TO 'testinguser';

-- !!!OBS Nedenstående skal ændres!!!
-- Demo Data til zipcodelistTest

    
    
commit;    
    
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;