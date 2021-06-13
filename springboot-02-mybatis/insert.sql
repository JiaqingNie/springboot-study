USE springbootMybatis;
INSERT INTO author (id, name, dob, gender) values(1, '唐家三少','1981/1/10',1);
INSERT INTO author (id, name, dob, gender) values(2, '鲁迅','1881/9/25',1);
INSERT INTO author (id, name, dob, gender) values(3, '张爱玲','1920/9/30',0);
INSERT INTO author (id, name, dob, gender) values(4, '三毛','1943/3/26',0);

INSERT INTO book (id, name, description, publication_date, author_id)VALUES(1,'斗罗大陆','《斗罗大陆》讲述的是穿越到斗罗大陆的唐三如何一步步修炼武魂，由人修炼为神，最终铲除了斗罗大陆上的邪恶力量，报了杀母之仇，成为斗罗大陆最强者的故事。','2009/5/1',1);
INSERT INTO book (id, name, description, publication_date, author_id)VALUES(2,'绝世唐门','这里没有魔法，没有斗气，没有武术，却有武魂。唐门创立万年之后的斗罗大陆上，唐门式微。一代天骄横空出世，新一代史莱克七怪能否重振唐门，谱写一曲绝世唐门之歌？','2012/12/1',1);
INSERT INTO book (id, name, description, publication_date, author_id)VALUES(3,'狂人日记','小说通过被迫害者“狂人”的形象以及“狂人”的自述式的描写，揭示了封建礼教的“吃人”本质，表现了作者对以封建礼教为主体内涵的中国封建文化的反抗；也表现了作者深刻的忏悔意识。','1918/4/1',2);
INSERT INTO book (id, name, description, publication_date, author_id)VALUES(4,'朝花夕拾','此文集作为“回忆的记事”，多侧面地反映了作者鲁迅青少年时期的生活，形象地反映了他的性格和志趣的形成经过。','1928/1/1',2);
INSERT INTO book (id, name, description, publication_date, author_id)VALUES(5,'倾城之恋','《倾城之恋》是一个动听而又近人情的故事。','1943/1/1',3);
INSERT INTO book (id, name, description, publication_date, author_id)VALUES(6,'金锁记','《金锁记》主要描写一个小商人家庭出身的女子曹七巧的心灵变迁历程。','1943/1/1',3);
INSERT INTO book (id, name, description, publication_date, author_id)VALUES(7,'撒哈拉的故事','《撒哈拉的故事》主要描写了三毛和荷西在撒哈拉沙漠生活时的所见所闻','1976/1/1',4);
INSERT INTO book (id, name, description, publication_date, author_id)VALUES(8,'温柔的夜','记述了三毛在加纳利群岛上的生活','2011/7/1',4);