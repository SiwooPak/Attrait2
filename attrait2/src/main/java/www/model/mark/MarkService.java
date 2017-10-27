package www.model.mark;

import java.util.*;

public interface MarkService {
	public Map<String, String> retrieveMark(Map<String, String> markParam);
	public void createMark(Map<String, String> markParam);
}
