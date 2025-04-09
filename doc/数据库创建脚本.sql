-- 创建数据库
CREATE
DATABASE IF NOT EXISTS digital_city;
use
digital_city;

-- 创建用户管理模块
CREATE TABLE member
(
    id          bigint unsigned auto_increment,
    mail        VARCHAR(50),
    password    VARCHAR(68),
    status      INT(1),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT uk_mid unique key (mail)
) engine = innodb;
CREATE INDEX idx_mid on member (mail);
-- 创建角色表（rid：角色ID，也是授权检测的名称、title：角色名称）
CREATE TABLE role
(
    rid         VARCHAR(50),
    title       VARCHAR(50),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_rid PRIMARY KEY (rid)
) engine = innodb;
-- 创建用户角色关联表（id：用户ID、rid：角色ID）
CREATE TABLE member_role
(
    id          bigint unsigned,
    rid         VARCHAR(50),
    create_time datetime,
    update_time datetime
) engine = innodb;

-- 景点信息简介
CREATE TABLE attraction
(
    id          int unsigned auto_increment,
    name        VARCHAR(50),
    content     TEXT,
    point       float,
    flow        int,
    cost        int,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 医院信息简介
create table hospital
(
    id          int unsigned auto_increment,
    name        varchar(40),
    tag         varchar(10),
    point       float,
    link        varchar(500),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 医疗公告
create table medical_bulletin
(
    id          int unsigned auto_increment,
    title       varchar(100) not null,
    output_date varchar(30)  not null,
    link        varchar(300),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 交通站点信息
create table traffic_station
(
    id            int unsigned auto_increment,
    name          varchar(20), -- 站点名称
    content       TEXT,        -- 站点简介
    emotion_point float,       -- 用户情感分数
    create_time   datetime,
    update_time   datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 用户交通评论
create table traffic_comment
(
    id          int unsigned auto_increment,
    name        varchar(20),  -- 站点名称
    comment     varchar(500), -- 用户的评论
    score       float,        -- 评论情感分数
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 交通流量
create table traffic_flow
(
    id          int unsigned auto_increment,
    year        int, -- 年份
    name        varchar(20),
    flow        float,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 商业圈类型分布
create table commerce
(
    id          int unsigned auto_increment,
    name        varchar(50),
    type        varchar(30),
    amount      int,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 民生情感
create table emotion_score
(
    id          int unsigned auto_increment,
    tag         varchar(20),
    source      varchar(20), -- 数据来源
    grades      float,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 民生评论
create table comment
(
    id          int unsigned auto_increment,
    tag         varchar(20), -- 评论所属的板块（交通，医疗，教育，住房，饮食）
    source      varchar(20), -- 数据来源
    content     varchar(500),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 娱乐建生场所评分
create table recreation
(
    id          int unsigned auto_increment,
    name        varchar(50), -- 场所名称
    tag         varchar(50), -- 标签类型
    point       float,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 养老服务
create table old_home
(
    id          int unsigned auto_increment,
    name        varchar(50), -- 场所名称
    point       float,
    content     text,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 人口结构
create table population_structure
(
    id          int unsigned auto_increment,
    scope       varchar(30), -- 年龄范围
    male        int,
    female      int,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 场所信息简介
create table site
(
    id          int unsigned auto_increment,
    name        varchar(50), -- 场所名称
    content     TEXT,
    photo       varchar(500),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 15分钟便民圈
create table life_circle
(
    id          int unsigned auto_increment,
    name        varchar(50),
    point       float, -- 用户评分
    content     TEXT,  -- 生活圈简介
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 圈内信息
create table circle_inf
(
    id                int unsigned auto_increment,
    name              varchar(50),
    school            tinyint,
    convenience_store tinyint,
    supermarket       tinyint,
    vegetable_market  tinyint,
    hospital          tinyint,
    drugstore         tinyint,
    bank              tinyint,
    community         tinyint,
    scenic_plot       tinyint,
    parking_lot       tinyint,
    wc                tinyint,
    police            tinyint,
    create_time       datetime,
    update_time       datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;