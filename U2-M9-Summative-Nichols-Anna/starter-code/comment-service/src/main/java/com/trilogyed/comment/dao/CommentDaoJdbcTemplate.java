package com.trilogyed.comment.dao;

import com.trilogyed.comment.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CommentDaoJdbcTemplate implements CommentDao{

    private static final String INSERT_COMMENT_SQL =
            "Insert into comment(post_id, create_date, commenter_name, comment) Values (?,?,?,?)";

    private static final String SELECT_COMMENT_SQL =
            "Select * From comment where comment_id = ?";

    private static final String SELECT_ALL_COMMENTS_SQL =
            "Select * From comment";

    private static final String UPDATE_COMMENT_SQL =
            "update comment set post_id=?, create_date=?, commenter_name=?, comment=?, comment_id=?";

    private static final String DELETE_COMMENT_SQL =
            "delete from comment where comment_id=?";

    private static final String SELECT_COMMENTS_BY_POSTID_SQL =
            "Select * From comment where post_id=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CommentDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Comment addComment(Comment comment) {

        jdbcTemplate.update(INSERT_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        comment.setCommentId(id);

        return comment;
    }

    @Override
    public Comment getComment(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_COMMENT_SQL, this::mapRowToComment, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Comment> getAllComments() {

        return jdbcTemplate.query(SELECT_ALL_COMMENTS_SQL, this::mapRowToComment);

    }

    @Override
    public List<Comment> getCommentsByPost(int post_id){
        return jdbcTemplate.query(SELECT_COMMENTS_BY_POSTID_SQL, this::mapRowToComment, post_id);
    }

    @Override
    public void updateComment(Comment comment) {

        jdbcTemplate.update(UPDATE_COMMENT_SQL,
                comment.getPostId(),
                comment.getCreateDate(),
                comment.getCommenterName(),
                comment.getComment(),
                comment.getCommentId());
    }

    @Override
    public void deleteComment(int id) {
        jdbcTemplate.update(DELETE_COMMENT_SQL, id);
    }

    private Comment mapRowToComment(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();

        comment.setCommentId(rs.getInt("comment_id"));
        comment.setPostId(rs.getInt("post_id"));
        comment.setCreateDate(rs.getDate("create_date").toLocalDate());
        comment.setCommenterName(rs.getString("commenter_name"));
        comment.setComment(rs.getString("comment"));

        return comment;
    }
    
}
