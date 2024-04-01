drop database if exists flower_shop;
create database flower_shop;
USE flower_shop;

CREATE TABLE `t_User`
(
    `id`       INT AUTO_INCREMENT PRIMARY KEY,
    `username` VARCHAR(255),
    `password` VARCHAR(255),
    `xingming` VARCHAR(255),
    `role`     INT,
    `dianhua`  VARCHAR(255),
    `dizhi`    VARCHAR(255)
);

INSERT INTO `t_User` (`id`, `username`, `password`, `xingming`, `role`, `dianhua`, `dizhi`)
VALUES (1, 'admin', '111111', 'admin', 1, NULL, NULL),
       (2, '111111', '111111', '张三', 0, '13011111211', '山西省太原市太原理工大学'),
       (3, '222222', '222222', '李四', 0, '13812121111', '太原');

CREATE TABLE `t_Fenlei`
(
    `id`    INT AUTO_INCREMENT PRIMARY KEY,
    `fname` VARCHAR(255)
);

INSERT INTO `t_Fenlei` (`id`, `fname`)
VALUES (1, '爱情类'),
       (2, '友情类');

CREATE TABLE `t_Product`
(
    `id`         INT AUTO_INCREMENT PRIMARY KEY,
    `pname`      VARCHAR(255),
    `imgpath`    VARCHAR(255),
    `createtime` VARCHAR(255),
    `fenleiid`   int,
    `jiage`      FLOAT,
    `tuijian`    VARCHAR(255),
    `miaoshu`    TEXT
);

INSERT INTO `t_Product` (`id`, `pname`, `imgpath`, `createtime`, `fenleiid`, `jiage`, `tuijian`, `miaoshu`)
VALUES (1, '玫瑰花', '20170502221745.jpg', '2017-05-02 22:14:27', 1, 99, '未推荐',
        '玫瑰原产中国，栽培历史悠久，玫瑰在植物分类学上是一种蔷薇科蔷薇属灌木(Rosa ru;sa)，在日常生活中是蔷薇属一系列花大艳丽的栽培品种的统称，这些栽培品种亦可称做月季或蔷薇。\n花语:爱情、爱与美、容光焕发，勇敢。'),
       (2, '郁金香', '20170502223117.jpg', '2017-05-02 22:21:46', 2, 66, '未推荐',
        '郁金香在植物分类学上，是一类属于百合科郁金香属(学名：Tulipa)的具鳞茎草本植物，又称洋荷花、旱荷花。\n郁金香花语：博爱、体贴、善良');

CREATE TABLE `t_gouwuche`
(
    `id`       INT AUTO_INCREMENT PRIMARY KEY,
    `userid`   INT,
    `pid`      INT,
    `shuliang` INT,
    foreign key (userid) references t_User (id),
    foreign key (pid) references t_Product (id)
);

INSERT INTO `t_gouwuche` (`id`, `userid`, `pid`, `shuliang`)
VALUES (1, 1, 1, 3);

CREATE TABLE `t_gonggao`
(
    `id`      INT AUTO_INCREMENT PRIMARY KEY,
    `biaoti`  VARCHAR(255),
    `neirong` TEXT,
    `shijian` VARCHAR(255)
);

INSERT INTO `t_gonggao` (`id`, `biaoti`, `neirong`, `shijian`)
VALUES (1, '毕业季', '毕业季也是离别季，买束鲜花送给老师和同学，感恩一路陪伴！', '2017-05-02 22:33:03'),
       (2, '入店须知', '本店所有产品均为货到付款，收到产品后请检查好！', '2017-05-02 22:42:13');

CREATE TABLE `t_Dingdan`
(
    `id`      INT AUTO_INCREMENT PRIMARY KEY,
    `orderid` CHAR(14),
    `status`  VARCHAR(255),
    `userid`  INT,
    `pid`     INT,
    `shumu`   INT,
    `dianhua` VARCHAR(255),
    `dizhi`   VARCHAR(255),
    `beizhu`  TEXT,
    `shijian` TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

INSERT INTO `t_Dingdan` (`id`, `orderid`, `status`, `userid`, `pid`, `shumu`, `dianhua`, `dizhi`, `beizhu`)
VALUES (1, '20170502223651', '已处理', 3, 1, 10, '13011111212', '山西省太原市太原理工大学', '包装好'),
       (2, '20170502223651', '已处理', 3, 1, 10, '13011111212', '山西省太原市太原理工大学', '包装好'),
       (3, '20170511113034', '未处理', 3, 1, 10, '13011111212', '山西省太原市太原理工大学', ''),
       (4, '20170511134257', '未处理', 3, 1, 10, '13011111212', '山西省太原市太原理工大学', ''),
       (5, '20170511163001', '已处理', 3, 1, 10, '13011111212', '山西省太原市太原理工大学', ''),
       (6, '20170605122020', '未处理', 7, 1, 10, '13834341212', '2222', ''),
       (7, '20170605122519', '未处理', 8, 1, 10, '13011111211', '山西省太原市太原理工大学', ''),
       (8, '20170605123015', '未处理', 8, 1, 10, '13011111211', '山西省太原市太原理工大学', ''),
       (9, '20170605123331', '未处理', 8, 1, 10, '13011111211', '山西省太原市太原理工大学', ''),
       (10, '20170605160527', '未处理', 9, 1, 10, '13812121111', '太原', '');
