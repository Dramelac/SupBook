
SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

CREATE TABLE `USER` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(32) NOT NULL,
  `PASSWORD` varchar(32) NOT NULL,
  `EMAIL` varchar(64) NOT NULL,
  `ISADMIN` BIT NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `LOGIN` (`LOGIN`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE `POST`(
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) NOT NULL,
  `CONTENT` VARCHAR(255),
  `Image` VARCHAR(255),
  `createAt` DATETIME,
  `ACL` VARCHAR(3),
  PRIMARY KEY (`ID`),
  FOREIGN KEY (UserID) REFERENCES USER(ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

CREATE TABLE `FRIENDREQUEST`(
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `OwnerID` int(11) NOT NULL,
  `ReceiverID` int(11) NOT NULL ,
  `createAt` DATETIME,
  `status` BIT NOT NULL,
  PRIMARY KEY (`ID`),
  FOREIGN KEY (OwnerID) REFERENCES USER(ID),
  FOREIGN KEY (ReceiverID) REFERENCES USER(ID)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

ALTER TABLE `FRIENDREQUEST` ADD CONSTRAINT uc_OR UNIQUE (`OwnerID`,`ReceiverID`);


INSERT INTO `USER` VALUES(1, 'toto', 'toto', 'toto@toto.com', 1);