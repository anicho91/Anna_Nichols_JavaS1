package com.trilogyed.post.dao;

import com.trilogyed.post.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class PostDaoJdbcTemplate implements PostDao{

    private static final String INSERT_POST_SQL =
            "Insert into post(post_date, poster_name, post) Values (?,?,?)";

    private static final String SELECT_POST_SQL =
            "Select * From post where post_id = ?";

    private static final String SELECT_ALL_POSTS_SQL =
            "Select * From post";

    private static final String UPDATE_POST_SQL =
            "update post set post_date=?, poster_name=?, post=?, post_id=?";

    private static final String DELETE_POST_SQL =
            "delete from post where post_id=?";

    private static final String SELECT_POSTS_BY_NAME_SQL =
            "select * from post where poster_name=?";

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostDaoJdbcTemplate(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public Post addPost(Post post) {

        jdbcTemplate.update(INSERT_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost());

        int id = jdbcTemplate.queryForObject("select last_insert_id()", Integer.class);

        post.setPostID(id);

        return post;
    }

    @Override
    public Post getPost(int id) {

        try {
            return jdbcTemplate.queryForObject(SELECT_POST_SQL, this::mapRowToPost, id);
        }catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public List<Post> getAllPosts() {

        return jdbcTemplate.query(SELECT_ALL_POSTS_SQL, this::mapRowToPost);

    }

    @Override
    public List<Post> getPostByPoster(String poster_name){
        return jdbcTemplate.query(SELECT_POSTS_BY_NAME_SQL, this::mapRowToPost, poster_name);
    }

    @Override
    public void updatePost(Post post) {

        jdbcTemplate.update(UPDATE_POST_SQL,
                post.getPostDate(),
                post.getPosterName(),
                post.getPost(),
                post.getPostID());
    }

    @Override
    public void deletePost(int id) {
        jdbcTemplate.update(DELETE_POST_SQL, id);
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();

        post.setPostID(rs.getInt("post_id"));
        post.setPostDate(rs.getDate("post_date").toLocalDate());
        post.setPosterName(rs.getString("poster_name"));
        post.setPost(rs.getString("post"));

        return post;
    }
    
}
