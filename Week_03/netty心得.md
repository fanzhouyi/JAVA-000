netty心得

Bootstrap: 启动线程，开启socket
EventLoopGroup: 线程池
EventLoop: 线程
SocketChannel: 连接
ChannelInitializer: 初始化
ChannelPipeline: 处理器链
ChannelHandler: 处理器 ####入站事件：
通道激活和停用
读操作事件
异常事件
用户事件 ####出站事件：
打开连接
关闭连接
写入数据
刷新数据
MTU: Maxitum Transmission Unit最大传输单元

路由选择：

进站的规则可以随机，或者权重。

进站的时候进行出站选择哪一种HttpOutBoundHandler

