DROP TABLE IF EXISTS `User`;
CREATE TABLE `User` (
  `uid`       INT(11)       NOT NULL AUTO_INCREMENT,
  `uname`     VARCHAR(255)  NOT NULL,
  `upwd`      VARCHAR(255)  NOT NULL,
  `alias`     VARCHAR(16)   NULL,
  `umobile`   VARCHAR(20)   NULL,
  `IDnumber`  VARCHAR(20)   NULL,
  `wallet`    DOUBLE(10, 1) NOT NULL,
  `condition` VARCHAR(10)   NOT NULL,
  PRIMARY KEY (`uid`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8;

DROP TABLE IF EXISTS Orders;
CREATE TABLE Orders
(
  id              INT(20)     NOT NULL
  COMMENT '主键id'
    PRIMARY KEY,
  userName        VARCHAR(20) NULL
  COMMENT '用户名（手机号)',
  objectId        INT(20)     NULL
  COMMENT '商品主表对应id',
  `	subObjectId` INT(20)     NULL
  COMMENT '商品子表id',
  order_code      VARCHAR(20) NULL
  COMMENT '订单号',
  bill            DECIMAL(2)  NULL
  COMMENT '消费金额',
  period          VARCHAR(10) NULL
  COMMENT '使用时间',
  startTime       DATETIME    NULL
  COMMENT '使用起始时间',
  endTime         DATETIME    NULL
  COMMENT '使用结束时间'
)
  ENGINE = InnoDB
  CHARSET = utf8;
# 商品表
DROP TABLE IF EXISTS Objects;
CREATE TABLE Objects
(
  id            INT(20) AUTO_INCREMENT PRIMARY KEY
  COMMENT '主键id',
  object_code   VARCHAR(20)  NOT NULL
  COMMENT '商品序列号',
  merchant_name VARCHAR(20)  NOT NULL
  COMMENT '商品名',
  object_name   VARCHAR(50)  NOT NULL
  COMMENT '商品名称',
  object_price  DOUBLE(5, 2) NOT NULL
  COMMENT '商品租用价格',
  object_status VARCHAR(20)  NOT NULL
  COMMENT '商品的上架状态',
  object_remark VARCHAR(200) NULL
  COMMENT '商品备注'
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  CHARSET = utf8;

DROP TABLE IF EXISTS objectTable;
CREATE TABLE objectTable
(
  id          INT(20)      NOT NULL auto_increment
  COMMENT '主键id'
    PRIMARY KEY,
  objectId    INT(20)      NULL
  COMMENT '商品主表对应id',
  sub_code    VARCHAR(20)  NULL
  COMMENT '子商品序列号',
  password    VARCHAR(20)  NULL
  COMMENT '子商品密码',
  `condition` TINYINT(1)   NULL
  COMMENT '是否可用（好坏）',
  remark      VARCHAR(200) NULL
  COMMENT '商品备注'
)
  ENGINE = InnoDB
  auto_increment = 1000
  CHARSET = utf8;

# 管理员表
DROP TABLE IF EXISTS Manager;
CREATE TABLE Manager
(
  mid       INT AUTO_INCREMENT
    PRIMARY KEY,
  mname     VARCHAR(20) NOT NULL,
  mpassword VARCHAR(20) NULL
)
  COMMENT '管理员'
  CHARSET = utf8
  ENGINE = InnoDB;

# 商家表
DROP TABLE IF EXISTS Merchant;
CREATE TABLE Merchant
(
  id                INT AUTO_INCREMENT PRIMARY KEY,
  merchant_name     VARCHAR(20) NOT NULL,
  merchant_password VARCHAR(20) NOT NULL,
  merchant_status   varchar(20) not null
)
  COMMENT '商家表'
  ENGINE = InnoDB
  CHARSET = utf8;