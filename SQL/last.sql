drop database if exists flower_shop;
create database flower_shop;
USE flower_shop;

# 李华祥开始
DROP TABLE IF EXISTS t_flower;
CREATE TABLE t_flower(
    `f_id` INT NOT NULL auto_increment  COMMENT '鲜花id' ,
    `f_name` VARCHAR(255) NOT NULL  COMMENT '鲜花名称',
    `f_implication` VARCHAR(255) NOT NULL  COMMENT '鲜花寓意' ,
    `f_color` VARCHAR(255) NOT NULL  COMMENT '鲜花颜色' ,
    `f_img` VARCHAR(255) NOT NULL COMMENT '鲜花图片',
    `f_price` decimal(13,2) NOT NULL  COMMENT '鲜花价格' ,
    `f_number` VARCHAR(32) NOT NULL  COMMENT '鲜花数量' ,
    PRIMARY KEY (f_id)
)  COMMENT = '鲜花;';

DROP TABLE IF EXISTS t_public_notice;
CREATE TABLE t_public_notice(
    `pn_id` INT NOT NULL auto_increment  COMMENT '公告id' ,
    `pn_content` VARCHAR(255) NOT NULL comment '公告内容',
    `pn_start_time` DATETIME NOT NULL default CURRENT_TIMESTAMP comment '开始时间',
    `pn_end_time` DATETIME NOT NULL default CURRENT_TIMESTAMP comment '结束时间',
    PRIMARY KEY (pn_id)
)  COMMENT = '公告';

DROP TABLE IF EXISTS t_classify;
CREATE TABLE t_classify(
    `c_id` INT AUTO_INCREMENT COMMENT '公告id' ,
    `c_variety` VARCHAR(255) NOT NULL  COMMENT '品种' ,
    PRIMARY KEY (c_id)
)  COMMENT = '鲜花分类';

drop table if exists t_flower_classify;
create table t_flower_classify(
    `id` int not null auto_increment comment '表id',
    `f_id` INT NOT NULL  COMMENT '鲜花id' ,
    `c_id` INT not null COMMENT '公告id' ,
    primary key (id),
    foreign key (f_id) references t_flower (f_id),
    foreign key (c_id) references t_classify (c_id)
) comment = '鲜花分类，鲜花连理表';
# 李华祥结束


# 陈建文开始

DROP TABLE IF EXISTS t_user;

CREATE TABLE t_user
(
    u_id         int NOT NULL auto_increment COMMENT '用户id',
    u_name       VARCHAR(255) NOT NULL COMMENT '用户名',
    u_status     CHAR(1)      NOT NULL DEFAULT 1 COMMENT '身份标识;管理员0/普通买家1',
    u_password   VARCHAR(255) NOT NULL COMMENT '用户密码',
    u_mail       VARCHAR(255) COMMENT '用户邮箱',
    u_expect     double       NOT NULL DEFAULT 0.85 COMMENT '用户期望',
    u_creat_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',

    primary key (u_id)
) COMMENT = '用户表;';

drop table if exists t_user_contact;

create table t_user_contact
(
    id         int AUTO_INCREMENT comment '表id',
    u_id       int not null comment '用户id',
    uc_name    varchar(255) not null comment '收货人',
    uc_address varchar(255) not null comment '收货地址信息',
    uc_tel     varchar(255) not null comment '收货人联系方式',

    primary key (id),
    foreign key (u_id) references t_user (u_id)

) COMMENT = '收货联系方式表;';

drop table if exists t_user_settings;
create table t_user_settings
(
    id        int AUTO_INCREMENT COMMENT '表id',
    u_id      int not null comment '用户id',
    c_id      int not null comment '鲜花分类id',
    us_expect double       NOT NULL DEFAULT 0.85 COMMENT '该品种鲜花期望',

    primary key (id),
    Foreign Key (c_id) REFERENCES t_classify (c_id),
    foreign key (u_id) references t_user (u_id)
) COMMENT = '用户鲜花期望表;';

DROP TABLE IF EXISTS t_user_login_behavior;

CREATE TABLE t_user_login_behavior
(
    id       int AUTO_INCREMENT COMMENT '表id',
    u_id     int NOT NULL COMMENT '用户id',
    ulb_type CHAR(1)      NOT NULL COMMENT '用户操作;登录0/登出1',
    ulb_time DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
    PRIMARY KEY (id),
    Foreign Key (u_id) REFERENCES t_user (u_id)

) COMMENT = '用户登录行为记录表;';

DROP TABLE IF EXISTS t_user_serach_behavior;

CREATE TABLE t_user_search_behavior
(
    id          int AUTO_INCREMENT COMMENT '表id',
    u_id        int NOT NULL COMMENT '用户id',
    usb_time    DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
    ft_id       int COMMENT '鲜花种类id',
    usb_content VARCHAR(255) COMMENT '搜索内容',
    PRIMARY KEY (id),
    Foreign Key (u_id) REFERENCES t_user (u_id)
) COMMENT = '用户搜索行为记录表;';

# 陈建文结束


# 陈成开始

DROP TABLE IF EXISTS t_cart;

CREATE TABLE t_cart
(
    id       int AUTO_INCREMENT COMMENT '序号id',
    u_id     int NOT NULL COMMENT '用户id',
    f_id     int NOT NULL COMMENT '鲜花id',
    c_count  INT          NOT NULL COMMENT '购买数量',
    c_status CHAR(1)      NOT NULL COMMENT '状态;0为鲜花下架，1为正常状态',
    Foreign Key (u_id) REFERENCES t_user (u_id),
    Foreign Key (f_id) REFERENCES t_flower (f_id),
    PRIMARY KEY (id)
) COMMENT = '购物车;';

DROP TABLE IF EXISTS t_order;

CREATE TABLE t_order
(
    o_id          int NOT NULL auto_increment COMMENT '订单id',
    u_id          int NOT NULL COMMENT '用户id',
    o_name        VARCHAR(255) NOT NULL COMMENT '收货人姓名',
    o_tel         CHAR(11)     NOT NULL COMMENT '收货人电话',
    o_address     VARCHAR(255) NOT NULL COMMENT '收货地址',
    o_notes       VARCHAR(255) COMMENT '备注',
    o_create_time DATETIME     NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
    o_sum_price   decimal(13,2)       NOT NULL COMMENT '总价',
    o_status      CHAR(1)      NOT NULL COMMENT '订单状态;0为待付款，1为已付款未发货，2为已发货，3为待评价，4为结单',
    Foreign Key (u_id) REFERENCES t_user (u_id),
    PRIMARY KEY (o_id)
) COMMENT = '订单表;';

DROP TABLE IF EXISTS t_order_details;

CREATE TABLE t_order_details
(
    id       int AUTO_INCREMENT COMMENT '表id',
    o_id     int NOT NULL COMMENT '订单号',
    f_id     int NOT NULL COMMENT '鲜花id',
    od_count INT          NOT NULL COMMENT '鲜花数目',
    Foreign Key (f_id) REFERENCES t_flower (f_id),
    Foreign Key (o_id) REFERENCES t_order (o_id),
    PRIMARY KEY (id)
) COMMENT = '订单详情表;';

# 陈成结束