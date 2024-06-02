-- 添加测试鲜花数据
INSERT INTO t_flower (f_name, f_implication, f_color, f_img, f_price, f_number)
VALUES
    ('玫瑰', '爱情', '红色', 'rose.jpg', 99.99, '100'),
    ('郁金香', '美好', '粉色', 'tulip.jpg', 89.99, '80'),
    ('百合', '纯洁', '白色', 'lily.jpg', 79.99, '120'),
    ('康乃馨', '母爱', '粉白色', 'carnation.jpg', 69.99, '150'),
    ('勿忘我', '不变的爱', '蓝色', 'forget_me_not.jpg', 59.99, '200'),
    ('向日葵', '阳光', '黄色', 'sunflower.jpg', 49.99, '180'),
    ('满天星', '美梦成真', '紫色', 'baby\'s_breath.jpg', 39.99, '220'),
    ('康乃馨', '美好的一天', '粉色', 'pink_carnation.jpg', 69.99, '190'),
    ('桔梗', '希望', '蓝紫色', 'bellflower.jpg', 59.99, '210'),
    ('玉簪', '纯真', '淡黄色', 'freesia.jpg', 79.99, '140');

-- 添加测试用户数据
INSERT INTO t_user (u_name, u_status, u_password, u_mail, u_expect, u_creat_time)
VALUES
    ('admin', '0', 'admin123', 'admin@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user1', '1', 'user123', 'user1@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user2', '1', 'user123', 'user2@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user3', '1', 'user123', 'user3@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user4', '1', 'user123', 'user4@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user5', '1', 'user123', 'user5@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user6', '1', 'user123', 'user6@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user7', '1', 'user123', 'user7@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user8', '1', 'user123', 'user8@example.com', 0.85, '2023-01-01 00:00:00'),
    ('user9', '1', 'user123', 'user9@example.com', 0.85, '2023-01-01 00:00:00');

-- 添加测试鲜花分类数据
INSERT INTO t_classify (c_variety)
VALUES
    ('玫瑰'),
    ('郁金香'),
    ('百合'),
    ('康乃馨'),
    ('勿忘我'),
    ('向日葵'),
    ('满天星'),
    ('康乃馨'),
    ('桔梗'),
    ('玉簪');

-- 添加测试用户收货联系方式数据
INSERT INTO t_user_contact (u_id, uc_name, uc_address, uc_tel)
SELECT
    u_id,
    CONCAT('收货人', u_id),
    CONCAT('地址', u_id),
    CONCAT('电话', u_id)
FROM t_user;

-- 添加测试用户鲜花期望数据
INSERT INTO t_user_settings (u_id, c_id, us_expect)
SELECT
    u_id,
    c_id,
    RAND() * 0.15 + 0.7 -- 随机生成期望值
FROM t_user, t_classify;

-- 添加测试用户登录行为记录数据
INSERT INTO t_user_login_behavior (u_id, ulb_type, ulb_time)
SELECT
    u_id,
    '0',
    DATE_ADD('2023-01-01 00:00:00', INTERVAL FLOOR(RAND() * 365) DAY) -- 随机生成一年内的时间
FROM t_user
LIMIT 50;

-- 添加测试用户搜索行为记录数据
INSERT INTO t_user_search_behavior (u_id, usb_time, ft_id, usb_content)
SELECT
    u_id,
    DATE_ADD('2023-01-01 00:00:00', INTERVAL FLOOR(RAND() * 365) DAY), -- 随机生成一年内的时间
    FLOOR(RAND() * 10) + 1, -- 随机鲜花种类id
    CONCAT('搜索内容', u_id)
FROM t_user
LIMIT 50;

-- 添加测试购物车数据
INSERT INTO t_Cart (u_id, f_id, c_count, c_status)
SELECT
    u_id,
    FLOOR(RAND() * 10) + 1, -- 随机鲜花id
    FLOOR(RAND() * 10) + 1, -- 随机数量
    '1'
FROM t_user
LIMIT 50;

-- 添加测试订单数据
INSERT INTO t_order (u_id, o_name, o_tel, o_address, o_notes, o_create_time, o_sum_price, o_status)
SELECT
    u_id,
    CONCAT('收货人', u_id),
    CONCAT('电话', u_id),
    CONCAT('地址', u_id),
    CONCAT('备注', u_id),
    DATE_ADD('2023-01-01 00:00:00', INTERVAL FLOOR(RAND() * 365) DAY), -- 随机生成一年内的时间
    0,
    FLOOR(RAND() * 5)
FROM t_user
LIMIT 50;

-- 添加测试订单详情数据
INSERT INTO t_order_details (o_id, f_id, od_count)
SELECT
