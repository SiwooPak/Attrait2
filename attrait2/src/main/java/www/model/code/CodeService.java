package www.model.code;

import java.util.*;

public interface CodeService {
	public List<CodeDTO> retrieveCodeList(Map<String, String> codeParam);
}
