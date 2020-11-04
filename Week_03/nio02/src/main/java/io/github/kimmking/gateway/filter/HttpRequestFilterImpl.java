package io.github.kimmking.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * @author Fzy
 * @version 1.0
 * @date 2020/11/4 23:52
 */
public class HttpRequestFilterImpl implements  HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
        fullRequest.headers().set("nid","fanzhouyi");
    }
}
