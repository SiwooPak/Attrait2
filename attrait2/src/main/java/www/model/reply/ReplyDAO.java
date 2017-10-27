package www.model.reply;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReplyDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public void setMybatis(SqlSessionTemplate mybatis) {
		this.mybatis = mybatis;
	}

	public List<Map<String, String>> retrieveReplyList(Map<String, String> replyParam) {
		return mybatis.selectList("reply.retrieveReplyList", replyParam);
	}

	public Map<String, String> retrieveReply(Map<String, String> replyParam) {
		return mybatis.selectOne("reply.retrieveReply", replyParam);
	}

	public void createReply(Map<String, String> replyParam) {
		mybatis.insert("reply.createReply", replyParam);
	}

	public void updateReply(Map<String, String> replyParam) {
		mybatis.update("reply.updateReply", replyParam);
	}

	public void deleteReply(Map<String, String> replyParam) {
		mybatis.delete("reply.deleteReply", replyParam);
	}
}
