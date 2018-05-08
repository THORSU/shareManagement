# 管理员表
DROP TABLE IF EXISTS Manager;
CREATE TABLE Manager
(
  mid       INT (11)    NOT NULL AUTO_INCREMENT
    PRIMARY KEY,
  mname     VARCHAR(20) NOT NULL,
  mpassword VARCHAR(20) NULL
)
  ENGINE = InnoDB
  AUTO_INCREMENT=1
  COLLATE = utf8_unicode_ci
  COMMENT='管理员';
#商品表
DROP TABLE IF EXISTS bikeTable;
CREATE TABLE bikeTable
(
  id          INT(20)      NOT NULL
  COMMENT '主键id'
    PRIMARY KEY,
  objectId    INT(20)      NULL
  COMMENT '商品主表对应id',
  code        VARCHAR(20)  NULL
  COMMENT '子商品序列号',
  password    VARCHAR(20)  NULL
  COMMENT '子商品密码',
  `condition` TINYINT(1)   NULL
  COMMENT '是否可用（好坏）',
  remark      VARCHAR(200) NULL
  COMMENT '商品备注'
)
  ENGINE = InnoDB
  CHARSET = utf8;

# 商品表
DROP TABLE IF EXISTS Objects;
CREATE TABLE Objects
(
  id     INT(20) AUTO_INCREMENT
  COMMENT '主键id'
    PRIMARY KEY,
  code   VARCHAR(20)  NULL
  COMMENT '商品序列号',
  name   VARCHAR(50)  NULL
  COMMENT '商品名称',
  price  DOUBLE(5, 2) NULL
  COMMENT '商品租用价格',
  remark VARCHAR(200) NULL
  COMMENT '商品备注'
)
  ENGINE = InnoDB
  CHARSET = utf8;
#订单表
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
  code            VARCHAR(20) NULL
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
#用户表
DROP TABLE IF EXISTS User;
CREATE TABLE User
(
  uid         INT AUTO_INCREMENT
    PRIMARY KEY,
  uname       VARCHAR(255)  NOT NULL,
  upwd        VARCHAR(255)  NOT NULL,
  alias       VARCHAR(16)   NULL,
  umobile     VARCHAR(20)   NULL,
  IDnumber    VARCHAR(20)   NULL,
  wallet      DOUBLE(10, 1) NOT NULL,
  `condition` VARCHAR(10)   NOT NULL
)
  ENGINE = InnoDB
  CHARSET = utf8;