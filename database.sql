create database pharmacy;

use pharmacy;
CREATE TABLE `locations` (
  `id` int(11) NOT NULL,
  `brandname` varchar(45) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `qualification` varchar(45) DEFAULT NULL,
  `locationId` int(11) DEFAULT NULL,
  `access` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `storeId_idx` (`locationId`),
  CONSTRAINT `storeId` FOREIGN KEY (`locationId`) REFERENCES `locations` (`id`)
);



CREATE TABLE `invoice` (
  `id` int(11) NOT NULL,
  `userid` int(11) DEFAULT NULL,
  `sales` varchar(45) DEFAULT NULL,
  `totalprice` bigint(10) DEFAULT NULL,
  `customername` varchar(45) DEFAULT NULL,
  `customerphone` varchar(45) DEFAULT NULL,
  `dataofsale` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_idx` (`userid`),
  CONSTRAINT `user` FOREIGN KEY (`userid`) REFERENCES `users` (`id`)
);

CREATE TABLE `products` (
  `name` varchar(45) NOT NULL,
  `available` int(11) DEFAULT NULL,
  `price` bigint(10) DEFAULT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `required` varchar(45) DEFAULT NULL,
  `description` varchar(100) DEFAULT NULL,
  `storeid` int(11) DEFAULT NULL,
  `chemicalformula` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`name`),
  KEY `store_idx` (`storeid`),
  CONSTRAINT `store` FOREIGN KEY (`storeid`) REFERENCES `locations` (`id`)
); 

CREATE TABLE `sales` (
  `id` int(11) NOT NULL,
  `tabletname` varchar(45) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` bigint(10) NOT NULL,
  `invoiceid` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `sales_idx` (`invoiceid`),
  KEY `tablet_idx` (`tabletname`),
  CONSTRAINT `sales` FOREIGN KEY (`invoiceid`) REFERENCES `invoice` (`id`)
); 

CREATE TABLE `storeproducts` (
  `id` int(11) NOT NULL,
  `product` varchar(45) DEFAULT NULL,
  `location` int(11) DEFAULT NULL,
  `availablequantity` int(11) DEFAULT NULL,
  `requiredquantity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_idx` (`product`),
  KEY `location_idx` (`location`),
  CONSTRAINT `location` FOREIGN KEY (`location`) REFERENCES `locations` (`id`),
  CONSTRAINT `product` FOREIGN KEY (`product`) REFERENCES `products` (`name`)
); 

CREATE TABLE `supplierorder` (
  `id` int(11) NOT NULL,
  `storeid` varchar(45) DEFAULT NULL,
  `orderplaceddate` datetime DEFAULT NULL,
  `orderrequireddate` datetime DEFAULT NULL,
  `isfullfilled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `supplierorderproducts` (
  `id` int(11) NOT NULL,
  `product` varchar(45) DEFAULT NULL,
  `quantity` varchar(45) DEFAULT NULL,
  `supplierorderid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `product_idx` (`product`),
  KEY `supplier_idx` (`supplierorderid`),
  CONSTRAINT `productfkey` FOREIGN KEY (`product`) REFERENCES `products` (`name`),
  CONSTRAINT `supplierfkey` FOREIGN KEY (`supplierorderid`) REFERENCES `supplierorder` (`id`)
);

SET FOREIGN_KEY_CHECKS=0;
ALTER TABLE `pharmacy`.`users` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT;
ALTER TABLE `pharmacy`.`sales` 
CHANGE COLUMN `id` `id` INT(11) NOT NULL AUTO_INCREMENT;
SET FOREIGN_KEY_CHECKS=1;
