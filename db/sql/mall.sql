-- MySQL Workbench Synchronization
-- Generated: 2020-04-16 21:17
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Jade

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_product_category` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) NOT NULL COMMENT '名称',
  `sort` INT(11) NOT NULL COMMENT '排序',
  `parent_id` BIGINT(20) NULL DEFAULT NULL COMMENT '父级类目',
  `create_user_id` BIGINT(20) NOT NULL COMMENT '创建人',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` VARCHAR(10) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '产品类目';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_product` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `brand_id` BIGINT(20) NOT NULL COMMENT '品牌',
  `category_id` BIGINT(20) NOT NULL COMMENT '类目',
  `name` VARCHAR(50) NOT NULL COMMENT '名称',
  `code` VARCHAR(20) NOT NULL COMMENT '编号',
  `images` VARCHAR(100) NOT NULL COMMENT '图片',
  `description` TEXT NOT NULL COMMENT '描述',
  `create_user_id` BIGINT(20) NOT NULL COMMENT '创建人',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` VARCHAR(10) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`),
  INDEX `fk_product_product_category_idx` (`category_id` ASC) VISIBLE,
  INDEX `fk_mall_product_mall_brand1_idx` (`brand_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_product_category`
    FOREIGN KEY (`category_id`)
    REFERENCES `kmall`.`mall_product_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_mall_product_mall_brand1`
    FOREIGN KEY (`brand_id`)
    REFERENCES `kmall`.`mall_brand` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '产品（spu）';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_product_category_spec` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT(20) NOT NULL COMMENT '类目',
  `name` VARCHAR(10) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`),
  INDEX `fk_product_attr_product_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_attr_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `kmall`.`mall_product_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '产品类目规格';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_goods` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(20) NOT NULL COMMENT '产品',
  `price` FLOAT(8,2) NOT NULL COMMENT '价格',
  `stoke` INT(11) NOT NULL COMMENT '库存',
  PRIMARY KEY (`id`),
  INDEX `fk_goods_product1_idx` (`product_id` ASC) VISIBLE,
  CONSTRAINT `fk_goods_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `kmall`.`mall_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '商品（sku）';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_shipping_address` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NOT NULL COMMENT '用户',
  `recipient_name` VARCHAR(10) NOT NULL COMMENT '收件人姓名',
  `recipient_mobile` VARCHAR(11) NOT NULL COMMENT '收件人手机',
  `recipient_address` VARCHAR(50) NOT NULL COMMENT '收件人地址',
  `is_default` TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否默认',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '收货地址';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_car` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(20) NOT NULL COMMENT '用户',
  `goods_id` BIGINT(20) NOT NULL COMMENT '商品',
  `num` INT(11) NOT NULL COMMENT '商品数量',
  `status` VARCHAR(10) NOT NULL COMMENT '商品状态',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '购物车';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_goods_spec` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `goods_id` BIGINT(20) NOT NULL COMMENT '商品',
  `category_spec_id` BIGINT(20) NOT NULL COMMENT '类目规格',
  `value` VARCHAR(20) NOT NULL COMMENT '规格值',
  PRIMARY KEY (`id`),
  INDEX `fk_goods_spec_goods1_idx` (`goods_id` ASC) VISIBLE,
  INDEX `fk_goods_spec_product_category_spec1_idx` (`category_spec_id` ASC) VISIBLE,
  CONSTRAINT `fk_goods_spec_goods1`
    FOREIGN KEY (`goods_id`)
    REFERENCES `kmall`.`mall_goods` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_goods_spec_product_category_spec1`
    FOREIGN KEY (`category_spec_id`)
    REFERENCES `kmall`.`mall_product_category_spec` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '商品规格';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_product_category_attr` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `category_id` BIGINT(20) NOT NULL COMMENT '类目',
  `name` VARCHAR(10) NOT NULL COMMENT '名称',
  PRIMARY KEY (`id`),
  INDEX `fk_product_category_attr_product_category1_idx` (`category_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_category_attr_product_category1`
    FOREIGN KEY (`category_id`)
    REFERENCES `kmall`.`mall_product_category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '产品类目属性';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_product_attr` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `product_id` BIGINT(20) NOT NULL COMMENT '产品',
  `category_attr_id` BIGINT(20) NOT NULL COMMENT '类目属性',
  `value` VARCHAR(20) NOT NULL COMMENT '属性值',
  PRIMARY KEY (`id`),
  INDEX `fk_product_attr_product1_idx` (`product_id` ASC) VISIBLE,
  INDEX `fk_product_attr_product_category_attr1_idx` (`category_attr_id` ASC) VISIBLE,
  CONSTRAINT `fk_product_attr_product1`
    FOREIGN KEY (`product_id`)
    REFERENCES `kmall`.`mall_product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_attr_product_category_attr1`
    FOREIGN KEY (`category_attr_id`)
    REFERENCES `kmall`.`mall_product_category_attr` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '产品属性';

CREATE TABLE IF NOT EXISTS `kmall`.`mall_brand` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(10) NOT NULL COMMENT '名称',
  `logo` VARCHAR(30) NULL DEFAULT NULL COMMENT 'logo url',
  `description` VARCHAR(100) NULL DEFAULT NULL COMMENT '描述',
  `sort` INT(11) NOT NULL COMMENT '排序',
  `create_user_id` BIGINT(20) NOT NULL COMMENT '创建人',
  `create_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` VARCHAR(10) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '品牌';


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
