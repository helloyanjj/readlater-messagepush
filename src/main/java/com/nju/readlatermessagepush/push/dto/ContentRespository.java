package com.nju.readlatermessagepush.push.dto;

import com.nju.readlatermessagepush.push.data.ShareContent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ContentRespository extends JpaRepository<ShareContent, Long> {

    @Query("SELECT sc.content FROM ShareContent sc " +
            "WHERE sc.userId=:userId")
    List<String> findContentByUserId(@Param("userId") String userId);

    List<ShareContent> findShareContentsByUserId(String userId);

//    @Query("SELECT top 1 * FROM ShareContent sc " +
//            "WHERE sc.userId=:userId AND sc.haveRead=:haveRead")
//    ShareContent findShareContentByUserIdAndId(String userId,String haveRead);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ShareContent sc SET sc.haveRead=:haveRead " +
            "WHERE sc.id=:id")
    @Transactional
    void changeReadStatus(@Param("id") long id,
                          @Param("haveRead") String haveRead);

}
