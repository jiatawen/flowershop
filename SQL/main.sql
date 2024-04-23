create table t_flower
(
    f_id     int auto_increment comment '鲜花id'
        primary key,
    f_color  varchar(255) not null comment '鲜花颜色',
    f_price  double       not null comment '鲜花价格',
    f_number varchar(32)  not null comment '鲜花数量'
)
    comment '鲜花;';

create table t_flower_classify
(
    fc_id          int auto_increment comment '表id'
        primary key,
    f_id           int          not null comment '鲜花id',
    fc_color       varchar(32)  not null comment '鲜花颜色',
    fc_implication varchar(255) not null comment '鲜花寓意',
    fc_variety     varchar(255) not null comment '品种'
)
    comment '鲜花分类';

create table t_public_notice
(
    pn_id      int auto_increment comment '鲜花id'
        primary key,
    pn_number  int          not null comment '鲜花数目',
    pn_price   double       not null comment '鲜花价格',
    pn_variety varchar(255) not null comment '鲜花品种'
)
    comment '公告';

create table t_user
(
    u_id         int auto_increment comment '用户id'
        primary key,
    u_name       varchar(255)                       not null comment '用户名',
    u_status     char     default '1'               not null comment '身份标识;管理员0/普通买家1',
    u_password   varchar(255)                       not null comment '用户密码',
    u_mail       varchar(255)                       null comment '用户邮箱',
    u_expect     double   default 0.85              not null comment '用户期望',
    u_creat_time datetime default CURRENT_TIMESTAMP not null comment '创建时间'
)
    comment '用户表;';

create table t_cart
(
    id       int auto_increment comment '序号id'
        primary key,
    u_id     int  not null comment '用户id',
    f_id     int  not null comment '鲜花id',
    c_count  int  not null comment '购买数量',
    c_status char not null comment '状态;0为鲜花下架，1为正常状态',
    constraint t_cart_ibfk_1
        foreign key (u_id) references t_user (u_id),
    constraint t_cart_ibfk_2
        foreign key (f_id) references t_flower (f_id)
)
    comment '购物车;';

create index f_id
    on t_cart (f_id);

create index u_id
    on t_cart (u_id);

create table t_order
(
    o_id          varchar(255)                       not null comment '订单id'
        primary key,
    u_id          int                                not null comment '用户id',
    o_name        varchar(255)                       not null comment '收货人姓名',
    o_tel         char(11)                           not null comment '收货人电话',
    o_address     varchar(255)                       not null comment '收货地址',
    o_notes       varchar(255)                       null comment '备注',
    o_create_time datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    o_sum_price   double                             not null comment '总价',
    o_status      char                               not null comment '订单状态;0为待付款，1为已付款未发货，2为已发货，3为待评价，4为结单',
    constraint t_order_ibfk_1
        foreign key (u_id) references t_user (u_id)
)
    comment '订单表;';

create index u_id
    on t_order (u_id);

create table t_order_details
(
    id       int auto_increment comment '表id'
        primary key,
    o_id     varchar(255) not null comment '订单号',
    f_id     int          not null comment '鲜花id',
    od_count int          not null comment '鲜花数目',
    constraint t_order_details_ibfk_1
        foreign key (f_id) references t_flower (f_id),
    constraint t_order_details_ibfk_2
        foreign key (o_id) references t_order (o_id)
)
    comment '订单详情表;';

create index f_id
    on t_order_details (f_id);

create index o_id
    on t_order_details (o_id);

create table t_user_contact
(
    id         int auto_increment comment '表id'
        primary key,
    u_id       int          not null comment '用户id',
    uc_name    varchar(255) not null comment '收货人',
    uc_address varchar(255) not null comment '收货地址信息',
    uc_tel     varchar(255) not null comment '收货人联系方式',
    constraint t_user_contact_ibfk_1
        foreign key (u_id) references t_user (u_id)
)
    comment '收货联系方式表;';

create index u_id
    on t_user_contact (u_id);

create table t_user_login_behavior
(
    id       int auto_increment comment '表id'
        primary key,
    u_id     int                                not null comment '用户id',
    ulb_type char                               not null comment '用户操作;登录0/登出1',
    ulb_time datetime default CURRENT_TIMESTAMP not null comment '时间',
    constraint t_user_login_behavior_ibfk_1
        foreign key (u_id) references t_user (u_id)
)
    comment '用户登录行为记录表;';

create index u_id
    on t_user_login_behavior (u_id);

create table t_user_search_behavior
(
    id          int auto_increment comment '表id'
        primary key,
    u_id        int                                not null comment '用户id',
    usb_time    datetime default CURRENT_TIMESTAMP not null comment '时间',
    ft_id       varchar(255)                       null comment '鲜花种类id',
    usb_content varchar(255)                       null comment '搜索内容',
    constraint t_user_search_behavior_ibfk_1
        foreign key (u_id) references t_user (u_id)
)
    comment '用户搜索行为记录表;';

create index u_id
    on t_user_search_behavior (u_id);

create table t_user_settings
(
    id        int auto_increment comment '表id'
        primary key,
    u_id      int                 not null comment '用户id',
    f_id      int                 not null comment '鲜花id',
    us_expect double default 0.85 not null comment '该品种鲜花期望',
    constraint t_user_settings_ibfk_1
        foreign key (f_id) references t_flower (f_id),
    constraint t_user_settings_ibfk_2
        foreign key (u_id) references t_user (u_id)
)
    comment '用户鲜花期望表;';

create index f_id
    on t_user_settings (f_id);

create index u_id
    on t_user_settings (u_id);

