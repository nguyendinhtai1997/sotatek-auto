package common.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseBase {
    public Integer statusCode;
    public Object code;
    public Object status;
    public String message;
    public String msg;
    public Object data;

    public ResponseBase(Object code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
