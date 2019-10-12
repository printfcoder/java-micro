package com.printfcoder.micro.spring.core.common.io;

import java.io.Flushable;

/**
 * see golang io.Writer
 *
 * @author <a href=mailto:i@shux.me>Printfcoder</a>
 * 2019/9/29
 **/
public interface Writer extends Appendable, Flushable, Closer {
}
