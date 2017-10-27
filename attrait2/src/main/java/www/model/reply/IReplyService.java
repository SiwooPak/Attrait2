package www.model.reply;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IReplyService implements ReplyService {
	@Autowired
	private ReplyDAO dao;
	
	public List<Map<String, String>> retrieveReplyList(Map<String, String> replyParam){
		return dao.retrieveReplyList(replyParam);
	}

	public Map<String, String> retrieveReply(Map<String, String> replyParam){
		return dao.retrieveReply(replyParam);
	}

	public void createReply(Map<String, String> replyParam){
		dao.createReply(replyParam);
	}

	public void updateReply(Map<String, String> replyParam){
		dao.updateReply(replyParam);
	}

	public void deleteReply(Map<String, String> replyParam){
		dao.deleteReply(replyParam);
	}

}
