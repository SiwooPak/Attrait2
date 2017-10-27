package www.model.code;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ICodeService implements CodeService{
	@Autowired
	private CodeDAO dao;
	
	@Override
	public List<CodeDTO> retrieveCodeList(Map<String, String> codeParam) {
		//System.out.println("codeParam"+codeParam.get("commTyCd"));
		return dao.retrieveCodeList(codeParam);
	}
}
