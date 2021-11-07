-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: db_pruebas
-- ------------------------------------------------------
-- Server version	5.7.34-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `ID_PERFIL` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOMBRE_PERFIL` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_PERFIL`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'ADMON'),(2,'ADMINISTRADOR'),(4,'USER');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil_recurso_seguridad`
--

DROP TABLE IF EXISTS `perfil_recurso_seguridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil_recurso_seguridad` (
  `ID_PERFIL_RECURSO_SEGURIDAD` bigint(20) NOT NULL AUTO_INCREMENT,
  `ID_PERFIL` bigint(20) NOT NULL,
  `ID_RECURSO_SEGURIDAD` bigint(20) NOT NULL,
  PRIMARY KEY (`ID_PERFIL_RECURSO_SEGURIDAD`),
  KEY `ID_PERFIL` (`ID_PERFIL`),
  KEY `ID_RECURSO_SEGURIDAD` (`ID_RECURSO_SEGURIDAD`),
  CONSTRAINT `perfil_recurso_seguridad_ibfk_1` FOREIGN KEY (`ID_PERFIL`) REFERENCES `perfil` (`ID_PERFIL`),
  CONSTRAINT `perfil_recurso_seguridad_ibfk_2` FOREIGN KEY (`ID_RECURSO_SEGURIDAD`) REFERENCES `recurso_seguridad` (`ID_RECURSO_SEGURIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil_recurso_seguridad`
--

LOCK TABLES `perfil_recurso_seguridad` WRITE;
/*!40000 ALTER TABLE `perfil_recurso_seguridad` DISABLE KEYS */;
INSERT INTO `perfil_recurso_seguridad` VALUES (34,2,8),(41,2,6),(42,2,7),(54,4,5),(55,2,5);
/*!40000 ALTER TABLE `perfil_recurso_seguridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `ID_PERSONA` bigint(10) NOT NULL AUTO_INCREMENT,
  `NOMBRES` varchar(255) NOT NULL,
  `PRIMER_APELLIDO` varchar(255) NOT NULL,
  `SEGUNDO_APELLIDO` varchar(255) DEFAULT NULL,
  `NUMERO_IDENTIFICACION` int(20) NOT NULL,
  `ID_TIPO_IDENTIFICACION` bigint(10) NOT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_PERSONA`),
  KEY `ID_TIPO_IDENTIFICACION` (`ID_TIPO_IDENTIFICACION`),
  CONSTRAINT `persona_test_ibfk_1` FOREIGN KEY (`ID_TIPO_IDENTIFICACION`) REFERENCES `tipo_identificacion` (`ID_TIPO_IDENTIFICACION`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'Carlos','z','z',2131231,1,'correa@gmail.com'),(2,'mauriicoi','x','x',1111111,2,'correa@gmail.com'),(3,'Monica','Restrepo',NULL,1026146005,1,NULL),(4,'Laberto','Restrepo','y',1234567,2,'alber@gmail.com');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recurso_seguridad`
--

DROP TABLE IF EXISTS `recurso_seguridad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recurso_seguridad` (
  `ID_RECURSO_SEGURIDAD` bigint(20) NOT NULL AUTO_INCREMENT,
  `NOMBRE_RECURSO` varchar(200) DEFAULT NULL,
  `CONTROL` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID_RECURSO_SEGURIDAD`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recurso_seguridad`
--

LOCK TABLES `recurso_seguridad` WRITE;
/*!40000 ALTER TABLE `recurso_seguridad` DISABLE KEYS */;
INSERT INTO `recurso_seguridad` VALUES (5,NULL,'persona'),(6,NULL,'usuario'),(7,NULL,'perfil'),(8,NULL,'permisosMenuPerfil');
/*!40000 ALTER TABLE `recurso_seguridad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_identificacion`
--

DROP TABLE IF EXISTS `tipo_identificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_identificacion` (
  `ID_TIPO_IDENTIFICACION` bigint(10) NOT NULL AUTO_INCREMENT,
  `CODIGO` varchar(5) DEFAULT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_TIPO_IDENTIFICACION`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_identificacion`
--

LOCK TABLES `tipo_identificacion` WRITE;
/*!40000 ALTER TABLE `tipo_identificacion` DISABLE KEYS */;
INSERT INTO `tipo_identificacion` VALUES (1,'CC','Cédula de ciudadania'),(2,'TI','Tarjeta de identidad');
/*!40000 ALTER TABLE `tipo_identificacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `ID_USUARIO` bigint(10) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(100) NOT NULL,
  `CLAVE` varchar(100) NOT NULL,
  `ID_PERSONA` bigint(10) NOT NULL,
  `ID_PERFIL` bigint(10) NOT NULL,
  `ACTIVO` varchar(1) NOT NULL,
  PRIMARY KEY (`ID_USUARIO`),
  KEY `usuario_ibfk_1` (`ID_PERFIL`),
  KEY `usuario_ibfk_2` (`ID_PERSONA`),
  CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`ID_PERFIL`) REFERENCES `perfil` (`ID_PERFIL`),
  CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`ID_PERSONA`) REFERENCES `persona` (`ID_PERSONA`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'mao','12345',2,2,'S'),(3,'carlosx','12345',1,2,'S'),(4,'juan','12345',4,4,'S');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-31 16:26:27
