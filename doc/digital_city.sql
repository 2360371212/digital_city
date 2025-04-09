CREATE
DATABASE IF NOT EXISTS digital_city;
use
digital_city;

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
-- 城市景点简介
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
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (1, '晋祠',
        '晋祠，全国重点文物保护单位之一，位于太原市西南郊25公里处的悬瓮山麓。晋祠原为纪念西周初年（公元前11世纪）武王次子、晋国开国侯而建。创建年代已不可考。北魏郦道元的《水经注》就有关于晋祠的记载，可见当时已经颇为出名了。晋祠现已称为一个有着几十座古建筑的中国古典园林的游览胜地。',
        4.9, 950000, 100, '2024-01-28 20:08:26', '2024-01-28 20:08:28');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (2, '山西博物院',
        '山西博物院总投资3.1亿元，是我国新建成的大型现代化博物馆之一，为国家“九五”重点建设工程，也是建国以来山西省投资规模最大的文化基础设施。山西，一个历史尤其悠久的地方，被誉为“华夏文明摇篮”，素有“中国古代文化博物馆”之称。山西博物院作为山西古代文化的集大成者，据统计，山西共有国宝级文物12件(组)，其中10件(组)藏于山西博物院。',
        4.0, 800000, 67, '2024-01-28 20:08:51', '2024-01-28 20:08:52');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (3, '迎泽公园',
        '迎泽公园面积为1000余亩，其中湖面240亩。公园原址是一片积水坑。1954年开始，太原市政府拆迁原有居民，组织义务劳动,依势挖湖堆山，大规模进行绿化，筹建公园。1956年5月1日正式开放。',
        4.8, 550000, 10, '2024-01-28 20:09:15', '2024-01-28 20:09:17');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (4, '蒙山大佛',
        '蒙山大佛，也称晋阳西山大佛，是一尊位于山西省太原市晋源区寺底村西北的蒙山中的摩崖大佛，现为太原市文物保护单位。蒙山大佛开凿于北齐天保年间，本是蒙山开化寺后的摩崖佛像。唐高祖李渊、唐高宗李治与皇后武则天、后唐武皇帝李克用、后汉高祖刘知远都曾来此礼佛。',
        4.7, 180000, 300, '2024-01-28 20:09:42', '2024-01-28 20:09:43');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (5, '永祚寺',
        '永祚寺始建于明朝万历二十五年（1597年），当时名为“永明寺”，仅有东塔（文峰塔），于万历二十七年（1599年）建成。文峰塔位于太原城的东南方向，是一座风水塔，由山东布政司参议傅霖、傅之谟父子主持修建，用于弥补太原城文运难以兴盛的风水缺陷。',
        3.5, 80000, 20, '2024-01-28 20:09:57', '2024-01-28 20:09:59');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (6, '汾河公园',
        '太原汾河公园，国家AAAA级旅游景区，始建于1998年10月，北起上兰汾河漫水桥，南至迎宾桥南2公里，贯穿整个太原市长达43公里，宽220米，总面积约20平方公里。其中，绿地面积约8.5平方公里、水面面积约11.5平方公里，蓄水总量约3000万立方米，汾河太原城区段已全面治理完成。',
        4.4, 1200000, 50, '2024-01-28 20:10:15', '2024-01-28 20:10:16');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (7, '太原食品街',
        '太原食品街，国家AAA级旅游景区，始建于宋代太原市的商业中心，清朝时叫“院门前”，新中国成立后，又名“帽儿巷”，1986年更名为“食品街”，历经百年开发，形成了北起府东街，南至钟楼街，宽10米，全长552米的一条集餐饮、观光、休闲为一体的特色休闲街区，同时也是集“食、游、购、娱、展、演”于一体的多元夜间消费市场。',
        4.0, 1750000, 100, '2024-01-28 20:10:54', '2024-01-28 20:10:56');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (8, '碑林公园',
        '碑林公园，始建于1990年，位于太原市汾河东岸滨河东路与康乐街交汇处，是一座集收藏和展示傅山先生及明、清之际历史文化名人墨迹的专业文化名园。山西省五星级城市公园，国家重点公园。',
        4.1, 130000, 20, '2024-01-28 20:10:55', '2024-01-28 20:10:59');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (9, '太原动物园',
        '太原动物园位于省城东北隅的卧虎山上，距市中心6公里，占地面积79.36公顷(1190.41亩)，地形地貌为东南高、西北低，东西直线长约5华里，南北平均宽约2华里，全园有供游客参观的各种动物品种170余种，3300余头(只);各种植物70余种，30余万株，草坪面积60万平方米，绿化覆盖率达到了85%以上;动物表演场四座，生态餐厅两座，游乐设施30余项，年接待游客量130余万人次。',
        4.2, 450000, 50 '2024-01-28 20:11:27', '2024-01-28 20:11:29');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (10, '崇善寺',
        '据文字记载，崇善寺始建于唐初，原为隋炀帝行宫，最初叫做白马寺，后来还用过延寿寺、宗善寺、新寺等名字。其中新寺这个名字用的时间最长。崇善寺的鼎盛时期是在明代，升格成为一座皇家寺院。洪武十四年（1381），晋恭王朱㭎为纪念其母马皇后，在原址扩建。洪武二十四年（1391）建成。占地宽广，占地面积二百四十亩，14万平方米，殿宇近千间，规模宏大，居山西之首。仅中轴线上的大型殿宇就有六座：金刚殿、天王殿、大雄宝殿、毗卢殿、大悲殿和金灵殿。嘉靖年间改名崇善寺。',
        4.7, 50000, 15, '2024-01-28 20:12:14', '2024-01-28 20:12:15');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (11, '晋阳湖',
        '晋阳湖原为晋阳古城遗址北侧的牛家营湖，这个湖泊本身也是一个人工湖，是中华人民共和国建立初期太原市第一热电厂的蓄水池。其名来自大禹治水的传说，据说太原盆地本来是由一个名叫晋阳湖的大湖覆盖的，大禹在灵石县附近开山凿口，将湖水排出，形成太原盆地，即“打开灵石口，空出晋阳湖”。1957年，牛家营湖扩建为水库，依典故改名为晋阳湖。',
        3.7, 1900000, 63, '2024-01-28 20:12:13', '2024-01-28 20:12:16');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (12, '天龙山石窟',
        '天龙山石窟始凿于北魏末至东魏。其为北齐佛教文化的代表。自北齐文宣帝的佛岩石窟寺、孝昭帝天龙石窟寺开始，历代王朝在此营造石窟寺。此处共有21窟，以漫山阁及九连洞著称。有北齐、隋、唐的佛教建筑风格，反映了佛教艺术在以上朝代更替中的变化。',
        4.0, 320000, 130, '2024-01-28 20:12:33', '2024-01-28 20:12:34');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (13, '中国煤炭博物馆',
        '中国煤炭博物馆是我国唯一的国家级煤炭行业博物馆，是全国煤炭行业历史文物、标本、文献、资料的收藏中心，是煤炭工业的科普教育机构、科学研究机构和宣传教育机构，是崇尚科学和文明的象征。',
        4.1, 350000, 75, '2024-01-28 20:12:50', '2024-01-28 20:12:51');
INSERT INTO digital_city.attraction (id, name, content, point, flow, cost, create_time, update_time)
VALUES (14, '太原古县城',
        '太原古县城，俗称“凤凰城”，因其始建于明代而被称为明太原县城，位于中国山西省太原市晋源区的晋阳古城遗址之上，始建于明洪武八年（1375年），占地面积约0.8平方公里。城内现存文物建筑79处，由太原市政府挂牌保护的历史建筑达49处，其中，太原县文庙被列为全国重点文物保护单位。',
        4.8, 1000000, 50, '2024-01-28 20:13:09', '2024-01-28 20:13:10');

-- 创建商业分布表
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
insert into commerce (name, type, amount) value ('柳巷商圈', '购物', 730);
insert into commerce (name, type, amount) value ('柳巷商圈', '娱乐', 128);
insert into commerce (name, type, amount) value ('柳巷商圈', '健身', 58);
insert into commerce (name, type, amount) value ('柳巷商圈', '餐饮', 482);
insert into commerce (name, type, amount) value ('柳巷商圈', '商务', 158);
insert into commerce (name, type, amount) value ('柳巷商圈', '办公', 79);
insert into commerce (name, type, amount) value ('柳巷商圈', '学习', 12);
insert into commerce (name, type, amount) value ('长风西商圈', '购物', 530);
insert into commerce (name, type, amount) value ('长风西商圈', '娱乐', 156);
insert into commerce (name, type, amount) value ('长风西商圈', '健身', 34);
insert into commerce (name, type, amount) value ('长风西商圈', '餐饮', 312);
insert into commerce (name, type, amount) value ('长风西商圈', '商务', 218);
insert into commerce (name, type, amount) value ('长风西商圈', '办公', 221);
insert into commerce (name, type, amount) value ('长风西商圈', '学习', 58);

-- 创建医院排行表
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
insert into hospital (name, tag, point, link) value ('山西医科大学第一医院', '三甲医院', 79.9, 'https://www.sydyy.com/');
insert into hospital (name, tag, point, link) value ('山西医科大学第二医院', '三甲医院', 78.0, 'https://www.sydey.com/');
insert into hospital (name, tag, point, link) value ('山西省人民医院', '三甲医院', 76.5, 'https://www.sxsrmyy.com/index.asp');
insert into hospital (name, tag, point, link) value ('山西白求恩医院', '三甲医院', 75.2, 'https://www.sxbqeh.com.cn/#/home');
insert into hospital (name, tag, point, link) value ('山西省肿瘤医院', '三甲医院', 73.6, 'https://www.sxzlyy.com/');
insert into hospital (name, tag, point, link) value ('太原市中心医院', '三甲医院', 72.5, '');
insert into hospital (name, tag, point, link) value ('山西省中医院', '三甲医院', 71.0, 'https://www.sxzyy.com/');
insert into hospital (name, tag, point, link) value ('太钢总医院', '三甲医院', 69.4, 'https://y.dxy.cn/hospital/1470');
insert into hospital (name, tag, point, link) value ('山西省儿童医院', '三甲医院', 67.8, 'https://www.shanxiwch.com/');
insert into hospital (name, tag, point, link) value ('山西中医学院附属医院', '三甲医院', 66, 'http://www.sxzyfy.com/');

-- 创建医疗公告表
create table medical_bulletin
(
    id          int unsigned auto_increment,
    title       varchar(100),
    output_date varchar(30),
    link        varchar(300),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;
insert into medical_bulletin(title, output_date, link) value ('关于将北京大学第一医院太原医院互联网医院纳入太原市“互联网+”医药服务的通知',
                                                              '2024-03-14',
                                                              'https://ybzx.taiyuan.gov.cn/tzgg2/20240314/30109657.html');
insert into medical_bulletin(title, output_date, link) value ('关于将山西仁安医院互联网医院纳入太原市“互联网+”医药服务的通知',
                                                              '2024-02-21',
                                                              'https://ybzx.taiyuan.gov.cn/tzgg2/20240221/30103007.html');
insert into medical_bulletin(title, output_date, link) value ('关于将山西仁安医院互联网医院纳入太原市“互联网+”医药服务的公示',
                                                              '2024-02-07',
                                                              'https://ybzx.taiyuan.gov.cn/tzgg2/20240207/30101606.html');
insert into medical_bulletin(title, output_date, link) value ('关于将国药集团山西有限公司互联网中心药房分公司等2家医药机构纳入太原市“互联网+”医药服务的通知',
                                                              '2024-01-30',
                                                              'https://ybzx.taiyuan.gov.cn/tzgg2/20240130/30099512.html');
insert into medical_bulletin(title, output_date, link) value ('关于太原泽琦万民药房有限公司等40家药店纳入太原市基本医疗保险定点零售药店的通知
', '2024-01-29', 'https://ybzx.taiyuan.gov.cn/tzgg2/20240129/30099419.html');
insert into medical_bulletin(title, output_date, link) value ('关于将山西和谐医疗健康中心互联网医院纳入太原市“互联网+”医药服务的公示',
                                                              '2024-01-23',
                                                              'https://ybzx.taiyuan.gov.cn/tzgg2/20240123/30097991.html');
insert into medical_bulletin(title, output_date, link) value ('关于太原晋冠口腔门诊部有限公司等医药机构纳入太原市医保定点协议管理的公示',
                                                              '2024-01-19',
                                                              'https://ybzx.taiyuan.gov.cn/tzgg2/20240119/30097352.html');


-- 创建交通站点信息表
create table traffic_station
(
    id          int unsigned auto_increment,
    year        int, -- 年份
    name        varchar(20),
    flow        float,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;
insert into traffic_station(year, name, flow) value ('2018', '太原站', 2030.231);
insert into traffic_station(year, name, flow) value ('2019', '太原站', 2050.231);
insert into traffic_station(year, name, flow) value ('2020', '太原站', 1623.271);
insert into traffic_station(year, name, flow) value ('2021', '太原站', 1530.643);
insert into traffic_station(year, name, flow) value ('2022', '太原站', 1823.91);
insert into traffic_station(year, name, flow) value ('2023', '太原站', 2123.431);
insert into traffic_station(year, name, flow) value ('2018', '太原机场', 1358.8423);
insert into traffic_station(year, name, flow) value ('2019', '太原机场', 1400.26);
insert into traffic_station(year, name, flow) value ('2020', '太原机场', 901.32);
insert into traffic_station(year, name, flow) value ('2021', '太原机场', 999.53);
insert into traffic_station(year, name, flow) value ('2022', '太原机场', 552.68);
insert into traffic_station(year, name, flow) value ('2023', '太原机场', 889.823);
insert into traffic_station(year, name, flow) value ('2018', '太原南站', 3909.423);
insert into traffic_station(year, name, flow) value ('2019', '太原南站', 4230.823);
insert into traffic_station(year, name, flow) value ('2020', '太原南站', 2534.583);
insert into traffic_station(year, name, flow) value ('2021', '太原南站', 2313.283);
insert into traffic_station(year, name, flow) value ('2022', '太原南站', 3239.823);
insert into traffic_station(year, name, flow) value ('2023', '太原南站', 3823.03);


-- 创建民生情感分数表
create table emotion_score
(
    id          int unsigned auto_increment,
    tag         varchar(20),
    grades      float,
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;

-- 用户评论
create table comment
(
    id          int unsigned auto_increment,
    tag         varchar(20),
    content     varchar(500),
    create_time datetime,
    update_time datetime,
    CONSTRAINT pk_id PRIMARY KEY (id)
) engine = innodb;
