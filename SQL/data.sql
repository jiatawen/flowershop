-- 插入 t_flower 表数据
INSERT INTO t_flower (f_id, f_name, f_implication, f_color, f_img, f_price, f_number)
VALUES (1, '玫瑰', '爱情', '红色', 'rose.jpg', 9.99, '100'),
       (2, '百合', '纯洁', '白色', 'lily.jpg', 12.99, '50'),
       (3, '康乃馨', '母爱', '粉色', 'carnation.jpg', 8.99, '75'),
       (4, '向日葵', '阳光', '黄色', 'sunflower.jpg', 10.99, '60'),
       (5, '郁金香', '高雅', '紫色', 'tulip.jpg', 15.99, '40');

-- 插入 t_public_notice 表数据
INSERT INTO t_public_notice (pn_id, pn_content, pn_start_time, pn_end_time)
VALUES (1, '店铺开业大酬宾，全场八折', '2024-05-20 10:00:00', '2024-05-31 23:59:59'),
       (2, '母亲节特惠，康乃馨买一送一', '2024-05-01 00:00:00', '2024-05-10 23:59:59');

-- 插入 t_classify 表数据
INSERT INTO t_classify (c_id, c_variety)
VALUES (1, '玫瑰'),
       (2, '百合'),
       (3, '康乃馨'),
       (4, '向日葵'),
       (5, '郁金香');

-- 插入 t_flower_classify 表数据
INSERT INTO t_flower_classify (id, f_id, c_id)
VALUES (1, 1, 1),
       (2, 2, 2),
       (3, 3, 3),
       (4, 4, 4),
       (5, 5, 5);

-- 插入 t_user 表数据
INSERT INTO t_user (u_id, u_name, u_status, u_password, u_mail, u_expect, u_creat_time)
VALUES (1, 'Alice', '1', md5('password1'), 'alice@example.com', 0.9, '2024-05-01 09:00:00'),
       (2, 'Bob', '0', md5('password2'), 'bob@example.com', 0.8, '2024-05-01 09:05:00'),
       (3, 'Charlie', '1', md5('password3'), 'charlie@example.com', 0.85, '2024-05-01 09:10:00');

-- 插入 t_user_contact 表数据
INSERT INTO t_user_contact (id, u_id, uc_name, uc_address, uc_tel)
VALUES (1, 1, 'Alice', '123 Flower St.', '12345678901'),
       (2, 2, 'Bob', '456 Garden Rd.', '12345678902'),
       (3, 3, 'Charlie', '789 Blossom Blvd.', '12345678903');

-- 插入 t_user_settings 表数据
INSERT INTO t_user_settings (id, u_id, c_id, us_expect)
VALUES (1, 1, 1, 0.9),
       (2, 2, 2, 0.8),
       (3, 3, 3, 0.85);

-- 插入 t_user_login_behavior 表数据
INSERT INTO t_user_login_behavior (id, u_id, ulb_type, ulb_time)
VALUES (1, 1, '0', '2024-05-01 10:00:00'),
       (2, 2, '0', '2024-05-01 10:05:00'),
       (3, 3, '0', '2024-05-01 10:10:00');

-- 插入 t_user_search_behavior 表数据
INSERT INTO t_user_search_behavior (id, u_id, usb_time, ft_id, usb_content)
VALUES (1, 1, '2024-05-01 10:15:00', 1, '玫瑰'),
       (2, 2, '2024-05-01 10:20:00', 2, '百合'),
       (3, 3, '2024-05-01 10:25:00', 3, '康乃馨');

-- 插入 t_Cart 表数据
INSERT INTO t_Cart (id, u_id, f_id, c_count, c_status)
VALUES (1, 1, 1, 2, '1'),
       (2, 2, 2, 1, '1'),
       (3, 3, 3, 3, '1');

-- 插入 t_order 表数据
INSERT INTO t_order (o_id, u_id, o_name, o_tel, o_address, o_notes, o_create_time, o_sum_price, o_status)
VALUES (1, 1, 'Alice', '12345678901', '123 Flower St.', 'Please deliver in the morning.', '2024-05-02 10:00:00', 19.98,
        '1'),
       (2, 2, 'Bob', '12345678902', '456 Garden Rd.', '', '2024-05-02 10:05:00', 12.99, '1'),
       (3, 3, 'Charlie', '12345678903', '789 Blossom Blvd.', 'Handle with care.', '2024-05-02 10:10:00', 26.97, '1');

-- 插入 t_order_details 表数据
INSERT INTO t_order_details (id, o_id, f_id, od_count)
VALUES (1, 1, 1, 2),
       (2, 2, 2, 1),
       (3, 3, 3, 3);
-- 设置模拟所需的变量
SET @start_date = '2024-01-01';
SET @end_date = '2024-08-31';

-- 模拟 8 个月的登录行为
INSERT INTO t_user_login_behavior (u_id, ulb_type, ulb_time)
SELECT 1 AS u_id,
       '0' AS ulb_type,
       TIMESTAMPADD(MINUTE, RAND() * TIMESTAMPDIFF(MINUTE, @start_date, @end_date), @start_date) AS ulb_time
FROM t_user
CROSS JOIN (
    SELECT n FROM (
        SELECT 1 AS n UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5
        UNION ALL SELECT 6 UNION ALL SELECT 7 UNION ALL SELECT 8 UNION ALL SELECT 9 UNION ALL SELECT 10
    ) t
) AS nums
WHERE TIMESTAMPDIFF(MONTH, u_creat_time, @end_date) < 8;

-- 模拟 8 个月的下单行为
INSERT INTO t_order (u_id, o_name, o_tel, o_address, o_notes, o_create_time, o_sum_price, o_status)
SELECT 1 AS u_id,
       '用户1' AS o_name,
       '12345678901' AS o_tel,
       '地址' AS o_address,
       '备注' AS o_notes,
       TIMESTAMPADD(MINUTE, RAND() * TIMESTAMPDIFF(MINUTE, @start_date, @end_date), @start_date) AS o_create_time,
       ROUND(RAND() * 100, 2) AS o_sum_price,
       '1' AS o_status
FROM t_user
CROSS JOIN (
    SELECT n FROM (
        SELECT 1 AS n UNION ALL SELECT 2 UNION ALL SELECT 3 UNION ALL SELECT 4 UNION ALL SELECT 5
        UNION ALL SELECT 6 UNION ALL SELECT 7
    ) t
) AS nums
WHERE TIMESTAMPDIFF(MONTH, u_creat_time, @end_date) < 8;

-- 提交更改
COMMIT;
