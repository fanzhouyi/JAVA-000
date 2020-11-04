package io.github.kimmking.gateway.outbound.okhttp;

import io.github.kimmking.gateway.outbound.HttpOutBoundHandler;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpUtil;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

import static io.netty.handler.codec.http.HttpResponseStatus.NO_CONTENT;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

public class OkhttpOutboundHandler  implements HttpOutBoundHandler {

    private static final Logger logger = LoggerFactory.getLogger(OkhttpOutboundHandler.class);

    private final OkHttpClient client;
    private final String backendUrl;

    public OkhttpOutboundHandler(String backendUrl) {
        Objects.requireNonNull(backendUrl, "BackendUrl can not be null!");
        logger.info("OkHttpOutboundHandler is created for backendUrl {}", backendUrl);
        this.backendUrl = backendUrl;
        this.client = new OkHttpClient();
    }

    @Override
    public void handle(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx) {
        final String url = this.backendUrl + fullRequest.uri();
        handleResponse(fullRequest, ctx, url);
    }

    private void handleResponse(final FullHttpRequest fullRequest, final ChannelHandlerContext ctx, final String url) {
        Request.Builder builder = new Request.Builder().url(url);
        fullRequest.headers().forEach(header -> builder.header(header.getKey(), header.getValue()));
        FullHttpResponse response = null;
        try (Response endpointResponse = client.newCall(builder.build()).execute()) {
            ResponseBody body = endpointResponse.body();
            if (body != null) {
                response = new DefaultFullHttpResponse(HTTP_1_1, OK, Unpooled.wrappedBuffer(body.bytes()));
            } else {
                response = new DefaultFullHttpResponse(HTTP_1_1, OK);
            }
            String header = endpointResponse.header("Content-Length", "0");
            if (header != null) {
                response.headers().setInt("Content-Length", Integer.parseInt(header));
            } else {
                response.headers().setInt("Content-Length", 0);
            }
            response.headers().set("Content-Type", "application/json");
        } catch (IOException e) {
            response = new DefaultFullHttpResponse(HTTP_1_1, NO_CONTENT);
            exceptionCaught(ctx, e);
        } finally {
            if (!HttpUtil.isKeepAlive(fullRequest)) {
                ctx.write(response).addListener(ChannelFutureListener.CLOSE);
            } else {
                ctx.write(response);
            }
            ctx.flush();
        }
    }

    private void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }

}
