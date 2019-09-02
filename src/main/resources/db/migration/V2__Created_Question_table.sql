CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `description` text COMMENT '问题详情',
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` int(11) DEFAULT NULL,
  `creator` bigint(20) DEFAULT NULL COMMENT '发起人',
  `comment_count` int(11) DEFAULT '0' COMMENT '评论数',
  `view_count` int(11) DEFAULT '0' COMMENT '阅读数',
  `like_count` int(11) DEFAULT '0' COMMENT '点赞数',
  `tag` varchar(256) DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;