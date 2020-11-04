package io.github.kimmking.gateway.outbound;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/5 0:19
 */
public interface HttpOutBoundHandler {
    void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx);
}
