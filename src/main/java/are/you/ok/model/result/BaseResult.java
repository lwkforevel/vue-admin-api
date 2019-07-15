package are.you.ok.model.result;

public class BaseResult<T> {
	
	private Integer code;
	
	private T data;
	
	
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BaseResult [code=" + code + ", data=" + data + "]";
	}
	
	
}
