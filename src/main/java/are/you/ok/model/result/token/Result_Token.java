package are.you.ok.model.result.token;

import are.you.ok.model.result.BaseResult;
import are.you.ok.model.result.TToken;

public class Result_Token extends BaseResult<TToken>{
	
	private TToken token;
	
	public TToken getToken() {
		return token;
	}

	public void setToken(TToken token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Result_Token [token=" + token + "]";
	}
	 
}
