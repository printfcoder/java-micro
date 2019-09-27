package com.printfcoder.micro.core.registry;

import lombok.Data;

/**
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/27
 **/
@Data
public class Value {
    private String name;
    private String type;
    private Value[] values;
}
