CREATE TABLE comment
(
    id bigint PRIMARY KEY NOT NULL AUTO_INCREMENT,
    parent_id bigint NOT NULL COMMENT '父类ID',
    type int NOT NULL COMMENT '父类类型',
    commentator bigint NOT NULL COMMENT '评论人ID',
    gmt_create bigint COMMENT '创建时间',
    gmt_modified bigint COMMENT '修改时间'
);