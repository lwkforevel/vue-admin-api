package are.you.ok.model.result;

public class BaseResult<T> {
	
	private Integer code = 20000;
	
	private T data;
	
	public T getData(){
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Integer getCode() throws InstantiationException, IllegalAccessException {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String toString() {
		return "BaseResult [code=" + code + ", data=" + data + "]";
	}

	public BaseResult(Integer code, T data) {
		super();
		this.code = code;
		this.data = data;
	}

	public BaseResult(T data) {
		super();
		this.data = data;
	}

	public BaseResult() {
		super();
	}

	
}
