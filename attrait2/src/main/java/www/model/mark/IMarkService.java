package www.model.mark;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IMarkService implements MarkService {
	@Autowired
	private MarkDAO dao;
	
	@Override
	public Map<String, String> retrieveMark(Map<String, String> markParam){
		return dao.retrieveMark(markParam);
	}

	@Override
	public void createMark(Map<String, String> markParam){
		dao.createMark(markParam);
	}

}
