from sqlalchemy import create_engine, MetaData, Table
from sqlalchemy.sql import func
from faker import Faker
import random
import datetime

# 初始化Faker
fake = Faker()

# 连接到数据库
engine = create_engine('mysql://root:100861@localhost/flower_shop', echo=True)

# 创建元数据
metadata = MetaData()

# 定义用户和鲜花表
t_user = Table('t_user', metadata, autoload=True, autoload_with=engine)
t_flower = Table('t_flower', metadata, autoload=True, autoload_with=engine)
t_classify = Table('t_classify', metadata, autoload=True, autoload_with=engine)

# 插入10个用户和鲜花
with engine.connect() as connection:
    for _ in range(10):
        connection.execute(t_user.insert().values(
            u_name=fake.user_name(),
            u_status=random.choice(['0', '1']),
            u_password=fake.password(),
            u_mail=fake.email(),
            u_expect=random.uniform(0, 1),
            u_creat_time=fake.date_time_between(start_date='-1y', end_date='now')
        ))

        connection.execute(t_flower.insert().values(
            f_name=fake.word(),
            f_implication=fake.sentence(),
            f_color=fake.color_name(),
            f_img=fake.image_url(),
            f_price=random.uniform(10, 1000),
            f_number=str(random.randint(1, 100)),
        ))

# 插入50条购物车数据
t_cart = Table('t_Cart', metadata, autoload=True, autoload_with=engine)
with engine.connect() as connection:
    for _ in range(50):
        connection.execute(t_cart.insert().values(
            u_id=random.randint(1, 10),
            f_id=random.randint(1, 10),
            c_count=random.randint(1, 10),
            c_status=random.choice(['0', '1']),
        ))

# 插入50条订单数据
t_order = Table('t_order', metadata, autoload=True, autoload_with=engine)
with engine.connect() as connection:
    for _ in range(50):
        connection.execute(t_order.insert().values(
            u_id=random.randint(1, 10),
            o_name=fake.name(),
            o_tel=fake.phone_number(),
            o_address=fake.address(),
            o_notes=fake.sentence(),
            o_create_time=fake.date_time_between(start_date='-1y', end_date='now'),
            o_sum_price=random.uniform(10, 1000),
            o_status=random.choice(['0', '1', '2', '3', '4']),
        ))

# 插入50条登录行为数据
t_user_login_behavior = Table('t_user_login_behavior', metadata, autoload=True, autoload_with=engine)
with engine.connect() as connection:
    for _ in range(50):
        connection.execute(t_user_login_behavior.insert().values(
            u_id=random.randint(1, 10),
            ulb_type=random.choice(['0', '1']),
            ulb_time=fake.date_time_between(start_date='-1y', end_date='now'),
        ))

# 插入50条搜索行为数据
t_user_search_behavior = Table('t_user_search_behavior', metadata, autoload=True, autoload_with=engine)
with engine.connect() as connection:
    for _ in range(50):
        connection.execute(t_user_search_behavior.insert().values(
            u_id=random.randint(1, 10),
            usb_time=fake.date_time_between(start_date='-1y', end_date='now'),
            ft_id=random.randint(1, 10),
            usb_content=fake.word(),
        ))

# 提交更改
metadata.create_all(engine)
